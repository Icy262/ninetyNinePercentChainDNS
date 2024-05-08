import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;
import java.io.ObjectInputStream;

class RegisterDNS extends Thread {
	public void run() {
		int port=9941;
		try {
			ServerSocket socket=new ServerSocket(port);
			while(true) {
				Socket connection=socket.accept();	
				ObjectInputStream read=new ObjectInputStream(connection.getInputStream());
				NodeIP.addIP((String) read.readObject());
				read.close();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}