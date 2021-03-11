package day0311;

/**
 * 생명주기(ready->running<->block)
 * @author user
 */
//1.Runnable 구현
public class UseSleep implements Runnable {

	//2.run method override
	@Override
	public void run() {
	//Thread로 동작해야 할 코드 작성
		for(int i=0;i<10;i++) {
			System.out.println("run i="+i);
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//catch
		}//for
		
	}//run
	
	
	public static void main(String[] args) {
		//3.클래스 생성
		UseSleep us=new UseSleep();
		//4.Thread와 has a관계 설정
		Thread thread=new Thread(us);
		//5.start();
		thread.start();
		
	}//main

}//class
