package Thread;

public class ThreadImp implements Runnable{
	int i;
	int count;
	public ThreadImp(int i, int count) {
		this.i = i;
		this.count = count;
	}
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			synchronized (Cooberate.class) {
				while (Cooberate.flag != i) {
					try {
						Cooberate.class.wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			synchronized (Cooberate.class) {
				System.out.println(Thread.currentThread() + ":" + i);
				Cooberate.flag = i + 1;
				if (i + 1 == count) {
					Cooberate.flag  = 0;
				}
				Cooberate.class.notifyAll();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	

}
