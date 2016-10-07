package simple03;

public class MessageBeanEnglish implements MessageBean{

	@Override
	public void sayHello(String name) {
		System.out.println("hello "+name+"!!");
	}

}
