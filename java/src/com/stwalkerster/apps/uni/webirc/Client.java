package com.stwalkerster.apps.uni.webirc;

import java.awt.BorderLayout;

import javax.swing.*;;

public class Client extends JApplet {
	private static final long serialVersionUID = -1860864635170787346L;

	public void init() {
		this.setSize(800, 480);
		this.setLayout( new BorderLayout() );
		
		JButton channels = new JButton("Channels");
		JButton users = new JButton("users");
		JButton topic = new JButton("topic");
		JButton textarea = new JButton("textarea");
		JButton input = new JButton("input");
		
		JPanel centre = new JPanel();
		
		centre.setLayout( new BorderLayout() );
		centre.add( topic, BorderLayout.NORTH  );
		
		centre.add( input, BorderLayout.SOUTH );
		centre.add(textarea, BorderLayout.CENTER);
		
//		JList<String> channels = new JList<String>();
		this.add( channels, BorderLayout.WEST );
//		JList<String> users = new JList<String>();
		this.add( users, BorderLayout.EAST  );
//		JTextArea topic = new JTextArea();

		this.add( centre, BorderLayout.CENTER  );
		
		
	}
}
