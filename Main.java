public class Main {
	public static void main(String[] args) {
		new DNSResponseHandler().start();
		new RegisterDNSHandler().start();
		new KeepAliveHandler().start();
	}
}