package day0303;

import day0302.UseJOptionPane;

/**
 *	method�ȿ��� �߻��ϴ� ���ܸ� ȣ���ϴ� ������ ó���ϵ��� ����� throws
 *	���ܹ߻��ڵ�� ����ó���ڵ带 �и��Ͽ� �ۼ��� �� �ִ�
 * @author user
 */
public class UseThrows {

	/**
	 * Class.forName method�� ����Ͽ� ��ü ����
	 */
	public void useClass() throws ClassNotFoundException{
		//throws�� �����ϸ� method�ȿ��� try~catch�� ���ܸ� ó������ �ʾƵ� �ȴ� ȣ���ϴ� ������ ó��
//		Class<String> c = (Class<String>) Class.forName("java.lang.String");
		Class<UseJOptionPane> c = (Class<UseJOptionPane>) Class.forName("day0302.UseJOptionPane");
		//���ٿ��� ���ܸ� �߻���Ű�� �Ʒ����� �ڵ�� ������� �ʴ´�
		System.out.println("��ü : " + c );
	}//useClass
	
	public void callUseClass() {
		try {
		useClass();//throws�� ���� �� Compile Exception�� �ݵ�� ó���ؾ��Ѵ�
		}catch( ClassNotFoundException cnfe ) {
			System.err.println("Ŭ������ �Ǵ� ��Ű������ Ȯ���ϼ���");
			cnfe.printStackTrace(); //�ڼ��� ������ ������ ���
		}//end catch
	}//callUseClass
	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		ut.callUseClass();
	}//main

}//class
