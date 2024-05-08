public class Main {
	public static void main(String[] args) {
		new DNSResponse().start();
		new RegisterDNS().start();
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