
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

public class Client extends JApplet implements IIrcDataListener {
	private static final long serialVersionUID = -1860864635170787346L;
	private JList<String> channels;
	private JList<String> users;
	private JTextArea input;
	private JTextArea textarea;
	private JTextArea topic;
	private JButton send;
	IrcAbstractionLayer irc ;
	
	public void init() {
		setupUI();
		
		channels.setListData( new String[] { } );
		users.setListData( new String[] {  } );
		
		String loginpw = "";
		if( (!getParameter("user").equals("")) &&( !getParameter("password").equals(""))) {
			loginpw = getParameter("user") + ":" + getParameter("password");
		}
		
		irc = new IrcAbstractionLayer( getParameter("host"), Integer.parseInt( getParameter("port")), getParameter("nick"), "f21na", "F21NA Network Applications coursework", loginpw );
		irc.addDataEventListener( this );
		irc.connect();
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {
				irc.send( input.getText() );
				input.setText( "" );
			}
		};
		
		send.addActionListener( listener );
		
		String keyStrokeAndKey = "ENTER";
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);
		input.getInputMap().put(keyStroke, keyStrokeAndKey);
		input.getActionMap().put(keyStrokeAndKey, new AbstractAction() {
			private static final long serialVersionUID = 3735017923997908076L;
			public void actionPerformed( ActionEvent e ) {
				irc.send( input.getText() );
				input.setText( "" );
			}
		});
		
	}

	
	
	private void setupUI() {
		this.setSize(900, 600);
		BorderLayout layout =new BorderLayout();
		layout.setVgap( 5 );layout.setHgap( 5 );
		this.setLayout( layout );
		channels = new JList<String>();
		channels.setPreferredSize( new Dimension( 150, 0 ) );
		users = new JList<String>();
		users.setPreferredSize( new Dimension( 150, 0 ) );
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
		topic = new JTextArea("");
		centre.add( topic, BorderLayout.NORTH  );
		JPanel bottom = new JPanel();
		BorderLayout innerinnerlayout = new BorderLayout();
		innerinnerlayout.setHgap( 5 );
		bottom.setLayout( innerinnerlayout );
		bottom.add( send, BorderLayout.EAST );
		bottom.add( input, BorderLayout.CENTER );
		centre.add( bottom, BorderLayout.SOUTH );
		centre.add(scroller, BorderLayout.CENTER);
		this.add( channels, BorderLayout.WEST );
		this.add( users, BorderLayout.EAST  );
		this.add( centre, BorderLayout.CENTER  );
		
	}

	@Override
	public void handleIrcDataEvent( IrcDataObject dataobj ) {
		String rawdata = dataobj.toString();
		
		if( rawdata.equals( "null" )) {
			irc.removeDataEventListener( this );
			return;
		}
		

		textarea.setText( textarea.getText() + "\r\n" + dataobj.toString() );
		
		// move view to bottom.
		textarea.select(textarea.getDocument().getLength(),textarea.getDocument().getLength());
	}
}
