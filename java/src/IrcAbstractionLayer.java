
import java.io.*;
import java.net.*;
import java.util.*;

public class IrcAbstractionLayer {
	
	Socket _connection = null;
	
	PrintWriter out = null;
	BufferedReader in = null;
	
	String serverDnsName;
	int serverTcpPort;
	String nickname;
	String username;
	String realname;
	String password;
	
	IrcWriterThread writer;
	IrcReaderThread reader;
	
	String server = "";
	
	private List<IIrcDataListener> _dataEventListeners = new ArrayList<IIrcDataListener>();
	public synchronized void addDataEventListener(IIrcDataListener listener) {
		_dataEventListeners.add(listener);
	}
	public synchronized void removeDataEventListener(IIrcDataListener listener) {
		_dataEventListeners.remove(listener);
	}
	
	public IrcAbstractionLayer(String server, int port, String nickname, String username, String realname ) {
		this.serverDnsName = server;
		this.serverTcpPort = port;
		this.nickname = nickname;
		this.username = username;
		this.realname = realname;
		this.password = "";
	}
	
	public IrcAbstractionLayer(String server, int port, String nickname, String username, String realname, String password ) {
		this.serverDnsName = server;
		this.serverTcpPort = port;
		this.nickname = nickname;
		this.username = username;
		this.realname = realname;
		this.password = password;
	}
	
	/**
	 * Connect to the server
	 * @return boolean
	 */
	public boolean connect() {
		try {
			_connection = new Socket( this.serverDnsName, this.serverTcpPort );
			
			out = new PrintWriter( _connection.getOutputStream() );
			in = new BufferedReader( new InputStreamReader (_connection.getInputStream() ));
			
			writer = new IrcWriterThread( this );
			writer.start();
			
			reader = new IrcReaderThread( this );
			reader.start();
			
			System.out.println("DBG: registering connection...");
			
			this.registerConnection();
			
			return true;
		} catch ( IOException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Read a line from the socket. DON'T USE THIS!
	 * @return
	 */
	public String readLine(){
		try {
			return in.readLine();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void fireDataEvent(String data) {
		IrcDataObject dobj = new IrcDataObject( data, this );

		if(server.equals("") && dobj.prefix != null)
		{
			// server is always the first thing to send us anything
			server = dobj.prefix.toString();
		}
		
		if(dobj.prefix != null) {
			if(dobj.prefix.nickname.equals(server)) dobj.isFromServer(true);
		}
		
		if( dobj.handled() ) {
			// the data has been dealt with, it's fine, go away.
			return;
		}
		
		Iterator<IIrcDataListener> i = _dataEventListeners.iterator();
		while(i.hasNext()){
			((IIrcDataListener)i.next()).handleIrcDataEvent( dobj );
		}
	}
	
	/**
	 * Write direct to the socket. DON'T USE THIS
	 * @param line
	 */
	public void writeLine(String line) {
		System.out.println("IRC-SOCKW: " + line);
		out.println(line);
		out.flush();
	}
	
	/**
	 * Write a line to the IRC stream.
	 * 
	 * This goes through flood protection, and is therefore safe.\
	 * @param line
	 */
	public void send(String line) {
		writer.enqueue( line );
	}

	private void registerConnection() {
		
		send("CAP END"); // IRCv3 (http://ircv3.org/) - we don't want any client extensions, pure RFC1459/2812 is good.
		
		if(!this.password.equals("")){
			send("PASS " + password );
		}
		send("USER " + username + " * * :" + realname);
		send("NICK " + nickname);
	}
	
	
	
	
	
}
