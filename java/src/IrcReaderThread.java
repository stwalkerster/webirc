public class IrcReaderThread extends Thread {

	IrcAbstractionLayer irc;
	
	public IrcReaderThread(IrcAbstractionLayer irclayer) {
		irc = irclayer;
	}
	
	public void run() {
		while(true) {
			String buffer = irc.readLine();
			
			if(buffer != ""){
				irc.fireDataEvent( buffer );
			} else {
				try {
					Thread.sleep(100); // wait a while
				} catch ( InterruptedException e ) { } 
			}
		}
	}
}
