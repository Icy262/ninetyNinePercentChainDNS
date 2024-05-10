import java.net.ServerSocket;
import java.lang.Thread;

class RegisterDNSHandler extends Thread {
	public void run() {
		int port=9941;
		try(ServerSocket socket=new ServerSocket(port)) {
			while(true) {
				new RegisterDNS(socket.accept()).start();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}