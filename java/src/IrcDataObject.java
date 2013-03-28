
public class IrcDataObject {
	String rawdata;
	
	public IrcDataObject (String rawData) {
		this.rawdata = rawData;
	}
	
	public IrcDataObject(IrcIdentifier source, String command, String arguments){}
	
	public String toString(){return rawdata;}
	
}
