import java.net.ServerSocket;
import java.lang.Thread;

class DNSResponseHandler extends Thread {
	public void run() {
		int port=9940;
		try(ServerSocket socket=new ServerSocket(port)) {
			while(true) {
				new DNSResponse(socket.accept()).start();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}