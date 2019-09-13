package 接口回调;

public class Out {
	PrintListener listener=null;
	public Out() {
		
	}
	public Out(PrintListener listener) {
		this.listener=listener;
	}
	public void printlen(String s) {
		System.out.println(s);
		if(listener!=null) {
			listener.print();
		}
	}
}
