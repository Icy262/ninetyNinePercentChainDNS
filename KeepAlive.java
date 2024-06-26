import java.net.Socket;
import java.lang.Thread;
import java.net.SocketTimeoutException;

class KeepAlive extends Thread {
	private String ip;
	public void run() {
		int port=9939;
		try {
			Socket socket=new Socket(ip, port);
			socket.setSoTimeout(10000);
			socket.close();
		} catch(Exception e) {
			if(e instanceof SocketTimeoutException) {
				NodeIP.removeIP(ip);
			} else {
				System.out.println();
			}
		}
	}
	public KeepAlive(String ip) {
		this.ip=ip;
	}
}