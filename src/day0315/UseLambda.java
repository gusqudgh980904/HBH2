package day0315;

/**
 * ���� Ŭ������ �ۼ����� �ʰ�, �������̽��� ���� ����ϴ� Lambda��
 * @author user
 */
public class UseLambda {
	
	/**
	 * interface�� �Ű������� �� method
	 * @param in1
	 */
	public void method(Inter1 in1) {
		in1.test();
	}//method
	
	public static void main(String[] args) {
		
		//����:()->{};
		Inter1 in1=()->{System.out.println("��ȯ�� ���� �Ű����� ���� ���� method ����");};
		//ȣ��:method�� ȣ���ϸ� lambda������ ������ �ڵ尡 ����ȴ�.
		in1.test();
		
		//�Ű��������� �޶� �ȴ�. ���������� ������ �ȴ�.
		Inter2 in2=(String name)->{System.out.println("��ȯ�� ����, �Ű����� �ִ� ���� method���� "+name);};
		//ȣ��
		in2.test("�ڱ��");
		
		//
		Inter3 in3=()->{return "������ ������ �Դϴ�.";};
		String msg=in3.test();
		System.out.println("��ȯ�� �ְ�, �Ź躯�� ���� ���� method���� "+msg);
		
		Inter4 in4=(String name)->{return name+"�� �ȳ��ϼ���?";};
		msg=in4.test("����ȣ");
		System.out.println("��ȯ�� �ְ�, �Ű����� �ִ� ���� method���� "+msg);
		
		
		//1~100���� "Thread"�� ����Ͽ� ����ϴ� �ڵ� �ۼ�
		Runnable r=()->{
				for(int i=1;i<101;i++) {
					System.out.println(i);}
				};
		Thread t=new Thread(r);
		t.start();
		System.out.println("-----------");
		UseLambda ul=new UseLambda();
		ul.method(in1);//Lambda���� ����Ͽ� ������ ��ü�� �Ҵ�
		ul.method( ()->{System.out.println("�Ű������� ���ǵ� Lambda");});

	}//main

}//class
