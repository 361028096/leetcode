package Thread;

public class Cooberate {
	public static volatile int flag = 1;
	public void test(String[] args) {
		Thread threads[] = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new ThreadImp(i, threads.length));
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
	public static void main(String[] args) {
		new Cooberate().test(null);
	}

}
