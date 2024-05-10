import java.net.Socket;
import java.lang.Thread;
import java.io.ObjectOutputStream;

class DNSResponse extends Thread {
	Socket connection;
	public void run() {
		try {
			ObjectOutputStream write=new ObjectOutputStream(connection.getOutputStream());
			for(int i=0; i<10; i++) {
				write.writeObject(NodeIP.getNextIP());
			}
			write.close();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public DNSResponse(Socket connection) {
		this.connection=connection;
	}
}