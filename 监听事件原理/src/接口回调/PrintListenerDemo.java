package 接口回调;

public class PrintListenerDemo implements PrintListener {

	@Override
	public void print() {
		System.out.println("监听到输出事件");
	}

}
