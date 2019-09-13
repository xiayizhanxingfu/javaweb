# 接口回调法
>开发者只需要重新实现接口就可以了

## 模拟输出监听事件

### 第一步先定义事件接口
```
public interface PrintListener {
	public void print();
}
```

### 第二步自定义输出类
```
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
```

### 第三步实现监听事件接口
```
public class PrintListenerDemo implements PrintListener {

	@Override
	public void print() {
		System.out.println("监听到输出事件");
	}

}
```

### 测试
```
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
```

### 结果
![]()
