public class KeepAliveHandler extends Thread {
	public void run() {
		try {
			while(true) {
				for(int i=0; i<NodeIP.getSize(); i++) {
					new KeepAlive(NodeIP.getIP(i)).start();
				}
				Thread.sleep(300000);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}