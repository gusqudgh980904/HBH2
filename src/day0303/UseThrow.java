package day0303;

import java.util.Random;

/**
 *	���� �����߻�
 * @author user
 */
public class UseThrow {
	/**
	 * �߻��� ���ܴ� ��κ��� ������ ó���Ѵ�
	 * ������ ���ܴ� �߻��� ���ܸ� �״�� ������ �ǰ�, �θ𿹿�ó�� Ŭ������ ����Ͽ� ������ �ȴ�
	 */
	public void useThrow() throws Exception {
		System.out.println("���ܹ߻� ��");
		if( new Random().nextBoolean() ) {
			//���ܸ� ������ �߻���ų���� :throw new ����ó��Ŭ����();
//			try {
				throw new Exception("���ܻ�����!!");
//			}catch(Exception e) {
//				// �߻��� ���ܸ� �ٷ� try ~catch�� ó���� �� �ִ�
//				e.printStackTrace();
//			}//end catch
		}//end if
		System.out.println("���ܹ߻� ��");
		
	}//useThrow

	public void callUseThrow() {
		try {
			useThrow();
		}catch(Exception e) {
			System.err.println("ȣ���� ������ ���� ó��"+e);
		}//end catch
	}//callUseThrow
	
	public static void main(String[] args) {
		UseThrow ut = new UseThrow();
		ut.callUseThrow();
	}//main

}//class
