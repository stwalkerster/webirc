
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

public class Client extends JApplet implements IIrcDataListener {
	private static final long serialVersionUID = -1860864635170787346L;
	private JTextArea input;
	private JTextArea textarea;
	private JButton send;
	IrcAbstractionLayer irc ;
	
	private String activeChannel = "NickServ";
	
	public void init() {
		setupUI();
		
		
		String loginpw = "";
		if( (!getParameter("user").equals("")) &&( !getParameter("password").equals(""))) {
			loginpw = getParameter("user") + ":" + getParameter("password");
		}
		
		irc = new IrcAbstractionLayer( getParameter("host"), Integer.parseInt( getParameter("port")), getParameter("nick"), "f21na", "F21NA Network Applications coursework", loginpw );
		irc.addDataEventListener( this );
		irc.connect();
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {
				sendToIrc();
			}
		};
		
		send.addActionListener( listener );
		
		String keyStrokeAndKey = "ENTER";
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);
		input.getInputMap().put(keyStroke, keyStrokeAndKey);
		input.getActionMap().put(keyStrokeAndKey, new AbstractAction() {
			private static final long serialVersionUID = 3735017923997908076L;
			public void actionPerformed( ActionEvent e ) {
				sendToIrc();
			}
		});
		
	}

	public void sendToIrc()
	{
		String text = input.getText();
		
		if(text.toLowerCase().startsWith( "/channel" )) {
			String[] temp = text.split(" ");
			activeChannel = temp[1];
			appendText("Active channel set to " + activeChannel);
		} else if (text.toLowerCase().startsWith("/join")) {
			text = text.substring( 1 );
			irc.send(text);
			String[] temp = text.split(" ");
			activeChannel = temp[1];
			appendText("Active channel set to " + activeChannel);
		} else if (text.startsWith("/")) {
			text = text.substring( 1 );
			appendText("RAW:\t" + text);
			irc.send(text);
		} else {
			irc.send( "PRIVMSG " + activeChannel + " :" + text );
			// = dataobj.parameters[0] + "\t" + name + "\t" + dataobj.parameters[1];
			// :Helpmebot!~hmb6@wikimedia/bot/helpmebot PRIVMSG ##helpmebot :pong
			appendText( activeChannel + "\t<" + irc.nickname + ">\t"+ text);
		}
		
		
		
		input.setText( "" );
	}
	
	private void setupUI() {
		this.setSize(900, 600);
		BorderLayout layout =new BorderLayout();
		layout.setVgap( 5 );layout.setHgap( 5 );
		this.setLayout( layout );
		input = new JTextArea("");
		
		input.setRows( 1 );
		
		
		textarea = new JTextArea("");
		textarea.setLineWrap( true );
		textarea.setRows( 500 );
		textarea.setEditable( false );
		JScrollPane scroller = new JScrollPane(textarea);
		
		
		send = new JButton("Send");
		JPanel centre = new JPanel();
		BorderLayout innerlayout = new BorderLayout();
		innerlayout.setVgap( 5 );
		centre.setLayout( innerlayout );
		JPanel bottom = new JPanel();
		BorderLayout innerinnerlayout = new BorderLayout();
		innerinnerlayout.setHgap( 5 );
		bottom.setLayout( innerinnerlayout );
		bottom.add( send, BorderLayout.EAST );
		bottom.add( input, BorderLayout.CENTER );
		centre.add( bottom, BorderLayout.SOUTH );
		centre.add(scroller, BorderLayout.CENTER);
		this.add( centre, BorderLayout.CENTER  );
		
	}

	@Override
	public void handleIrcDataEvent( IrcDataObject dataobj ) {
		String rawdata = dataobj.toString();
		
		if( rawdata.equals( "null" )) {
			irc.removeDataEventListener( this );
			return;
		}
		
		String text = dataobj.toString();
		String name = "<" + dataobj.prefix.nickname  + ">";
		
		if(dataobj.isFromServer()){
			name = "<** SERVER **>";
		}

		
		
		if(dataobj.command.equals( "PRIVMSG" ))
		{
			if(dataobj.parameters[0].equals(irc.nickname)){
				text = "\t\t" + name + "\t" + dataobj.parameters[1];
			} else {
				text = dataobj.parameters[0] + "\t" + name + "\t" + dataobj.parameters[1];
			}
			
		}
		else if(dataobj.command.equals( "NOTICE" ))
		{
			text = dataobj.parameters[0] + "\t" + name + "\t==NOTICE== " + dataobj.parameters[1];
		}
		else {
			text = "\t" + name + "\t" + dataobj.noprefix;
		}
		
		
		
		appendText( text );
	}

	private void appendText( String text ) {
		//// add to box;
		textarea.setText( textarea.getText() + "\r\n" + text );
		// move view to bottom.
		textarea.select(textarea.getDocument().getLength(),textarea.getDocument().getLength());
	}
}
