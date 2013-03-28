import java.util.LinkedList;

public class IrcWriterThread extends Thread {

	IrcAbstractionLayer irc;
	LinkedList<String> sendQ;
	
	public IrcWriterThread(IrcAbstractionLayer irclayer) {
		irc = irclayer;
		synchronized( this ) {
			sendQ = new LinkedList<String>(  );
		}
	}
	
	public void enqueue(String line){
		synchronized( this ) {
			sendQ.add(line);
		}
	}
	
	public void run() {
		while(true) {
			String buffer = sendQ.poll();
			
			if(buffer != null){
				
				irc.writeLine( buffer );
				try {
					Thread.sleep(500); // flood protection
				} catch ( InterruptedException e ) { } 
			} else {
				try {
					Thread.sleep(100); // wait a while
				} catch ( InterruptedException e ) { } 
			}
		}
	}
}
