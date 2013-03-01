

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;;

public class Client extends JApplet {
	private static final long serialVersionUID = -1860864635170787346L;

	public void init() {
		this.setSize(900, 600);
		BorderLayout layout =new BorderLayout();
		layout.setVgap( 5 );layout.setHgap( 5 );
		this.setLayout( layout );
		
		
		
		JList<String> channels = new JList<String>();
		channels.setPreferredSize( new Dimension( 150, 0 ) );
		channels.setListData( new String[] { "#wikipedia-en-accounts", "#freenode", "#ubuntu", "#mediawiki", "#wikipedia-en" } );
		
		JList<String> users = new JList<String>();
		users.setPreferredSize( new Dimension( 150, 0 ) );
		users.setListData( new String[] { "@ChanServ", "+Helpmebot", "Bsadowski1", "Chris_G", "delirious", "DoRD", "FastLizard4|zZzZ", "Izawayz", "Matthew_", "MJ94", "QueenOfFrance", "ReaperEternal", "Riley", "Snowolf", "stwalkerster", "Superfreak", "Thehelpfulone", "Theopolisme", "Tiggerjay" } );
		
		JTextArea topic = new JTextArea("Status: Up | Tool: http://is.gd/tsacc | Doc: http://is.gd/accguide | ML: http://is.gd/accmail");
		JTextArea input = new JTextArea("");
		JTextArea textarea = new JTextArea("<FastLizard4> Valve really has put a lot of effort to making Steam and Source work well on Linux\n<Superfreak> \"I'm going to gut you, like a corcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcorcor\"\n<FastLizard4> lol\n<FastLizard4> I think I like the overtime bug more though\n<Superfreak> My friend likes to interrupt the spy\n<Superfreak> \"Just lay your weapons down and place a teleporter here!\"\n* Mlpearc|Away (~chatzilla@wikipedia/Mlpearc) has joined #wikipedia-en-accounts\n<FastLizard4> LOL\n<Superfreak> \"I'm going to gut you like a MEDIC!\"\n<FastLizard4> o_o\n<FastLizard4> That actually would make sense as a taunt :P\n<Superfreak> I'm trying to think what other quirks he has with the sounds.\n<FastLizard4> Superfreak: YOu know the Overtime bug, right?\n* stwalkerster is actually wearing http://www.thinkgeek.com/product/dac0/ AND http://www.thinkgeek.com/product/e5a2/ today :)\n<Superfreak> FastLizard4: No, actually.\n<Superfreak> stwalkerster: That portal hoodie is awesome.\n<FastLizard4> Superfreak: It's a bug that's so popular that when Valve patched it they actually added an svar to make it \"occur\" again\n<FastLizard4> I think it originally happened on CP maps, maybe others too\n<FastLizard4> During Overtime, the announcer would repeatedly say \"OVERTIME!\" in her various tones and inflections\n<FastLizard4> Of course, she's only \"supposed\" to say it once, when Overtime starts\n<Superfreak> Ahahah, I just looked it up on youtube.\n<Superfreak> That's hilarious.\n<Superfreak> That reminds me of the UKCS servers.\n<FastLizard4> stwalkerster: Awesome\n<FastLizard4> stwalkerster: My girlfriend got me a combustible lemons t-shirt :P\n<Superfreak> The current game time limit was clearly indicated by the clock.\n<FastLizard4> *combustable\n<stwalkerster> :D\n<Superfreak> But the map time limit was not.\n<FastLizard4> Superfreak: o_o\n<FastLizard4> Superfreak: OMG\n<FastLizard4> I had that on a MvM match once\n<Superfreak> So to avoid confusion, the UKCS servers added the countdown clock when the map time was coming up.\n<Superfreak> You know this right?");
		textarea.setLineWrap( true );
		textarea.setRows( 500 );
		JButton send = new JButton("Send");
		
		JPanel centre = new JPanel();
		
		BorderLayout innerlayout = new BorderLayout();
		innerlayout.setVgap( 5 );
		centre.setLayout( innerlayout );
		centre.add( topic, BorderLayout.NORTH  );
		
		JPanel bottom = new JPanel();
		BorderLayout innerinnerlayout = new BorderLayout();
		innerinnerlayout.setHgap( 5 );
		bottom.setLayout( innerinnerlayout );
		bottom.add( send, BorderLayout.EAST );

		bottom.add( input, BorderLayout.CENTER );
		
		centre.add( bottom, BorderLayout.SOUTH );
		centre.add(textarea, BorderLayout.CENTER);
		
		this.add( channels, BorderLayout.WEST );
		this.add( users, BorderLayout.EAST  );

		this.add( centre, BorderLayout.CENTER  );
		
		
	}
}
