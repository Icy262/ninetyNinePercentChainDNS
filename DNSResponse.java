import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;
import java.io.ObjectOutputStream;

class DNSResponse extends Thread {
	public void run() {
		int port=9940;
		try {
			ServerSocket socket=new ServerSocket(port);
			while(true) {
				Socket connection=socket.accept();	
				ObjectOutputStream write=new ObjectOutputStream(connection.getOutputStream());
				for(int i=0; i<10; i++) {
					write.writeObject(NodeIP.getNextIP());
				}
				write.close();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}