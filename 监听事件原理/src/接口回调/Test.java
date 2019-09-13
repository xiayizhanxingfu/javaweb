package 接口回调;

public class Test {
	public static void main(String[] args) {
		//新建一个默认输出类
		Out b=new Out();
		b.printlen("这里不会被监听到输出事件");		
		//新建一个输出类,为输出类添加一个输出监听事件
		Out b1=new Out(new PrintListenerDemo());
		b1.printlen("这里输出后会被监听到输出事件");
	}
}
