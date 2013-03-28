import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IrcDataObject {
	String rawdata;
	boolean _handled = false;
	
	IrcAbstractionLayer irc;
	
	
	IrcIdentifier prefix;
	String command;
	String[] parameters;
	
	public IrcDataObject (String rawData, IrcAbstractionLayer irc) {
		this.irc = irc;
		this.rawdata = rawData;
		
		if(rawData.charAt( 0 ) == ':') { // take out prefix
			prefix = IrcIdentifier.newFromString( 
					rawData.substring( 1 /* ignoring : */, rawData.indexOf( ' ' ) )
					);
			rawData = rawData.substring( rawData.indexOf( ' ' ) + 1 );
		} // end of prefix search
		
		// command
		command = rawData.substring( 0, rawData.indexOf( ' ' ) );
		rawData = rawData.substring( rawData.indexOf( ' ' ) + 1 );
		
		// params... //////////////////////////////////////////////

		// look for a :, if one exists.
		if( rawData.contains( " :" )) {
			String[] paramStage1;
			String extendedParams;
			
			// split by " :", then the first bit by spaces.
			String[] temp = rawData.split( " :" );
			paramStage1 = temp[0].split(" ");
			extendedParams = temp[1];
			
			parameters = Arrays.copyOf(paramStage1, paramStage1.length + 1);
			parameters[paramStage1.length] = extendedParams;
			
		} else {
			// nope. just split on spaces
			parameters = rawData.split(" ");
		}
		
		_handled = handleMessage();
	}
	
	private boolean handleMessage() {
		if(command.equals( "PING" )) {
			irc.send( "PONG :" + parameters[0] );
			return true;
		}
		
		
		return false;
	}

	public String toString(){return rawdata;}
	
	public boolean handled()
	{
		return _handled;
	}
	
}
