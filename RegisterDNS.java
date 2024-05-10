import java.net.Socket;
import java.lang.Thread;
import java.io.ObjectInputStream;

class RegisterDNS extends Thread {
	Socket connection;
	public void run() {
		try {
			ObjectInputStream read=new ObjectInputStream(connection.getInputStream());
			NodeIP.addIP((String) read.readObject());
			read.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public RegisterDNS(Socket connection) {
		this.connection=connection;
	}
}