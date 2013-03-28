public class IrcIdentifier {
	String nickname = null;
	String username = null;
	String hostname = null;

	public IrcIdentifier( String nick, String user, String host ) {
		nickname = nick;
		username = user;
		hostname = host;
	}

	public IrcIdentifier( String nick, String host ) {
		nickname = nick;
		hostname = host;
	}

	public IrcIdentifier( String nick ) {
		nickname = nick;
	}

	public static IrcIdentifier newFromString( String source ) {
		String user, host;
		String nick = user = host = null;

		if( ( source.contains( "@" ) ) && ( source.contains( "!" ) ) ) {
			String splitSeparators = "[!@]";
			String[] sourceSegment = source.split( splitSeparators, 3 );
			nick = sourceSegment[ 0 ];
			user = sourceSegment[ 1 ];
			host = sourceSegment[ 2 ];
		} else if( source.contains( "@" ) ) {
			String splitSeparators = "[@]";
			String[] sourceSegment = source.split( splitSeparators, 2 );
			nick = sourceSegment[ 0 ];
			host = sourceSegment[ 1 ];
		} else {
			nick = source;
		}

		IrcIdentifier ret = new IrcIdentifier( nick, user, host );

		return ret;
	}
	
	public String toString() {
		String value = nickname;
		
		if(hostname != null){
			if(username != null) {
				value += "!" + username;
			}
			value += "@" + hostname;
		}
		return value;
	}
	
}
