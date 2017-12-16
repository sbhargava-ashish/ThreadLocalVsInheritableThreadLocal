
public class ThreadLocalTestMain {
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

		threadLocal.set("In Main");
		inheritableThreadLocal.set("In Main Inheritable");
		
		System.out.println("ThreadLocal value is : " + threadLocal.get() );
		System.out.println("InheritableThreadLocal value is : " + inheritableThreadLocal.get() );
		
		Thread childThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("ThreadLocal value in Child Thread is : " + threadLocal.get());
				System.out.println("InheritableThreadLocal value in Child Thread is : " + inheritableThreadLocal.get());
			}
		});
		
		childThread.start();
	}
}
