package day0302;

/**
 *	RuntimeException�� ó��
 *	JVM�� �ڵ����� ó���ϴ� ���ܷ�, �����ڰ� �ڵ带 �ۼ��ϴ� �ܰ迡���� Compile Error�� �߻����� �ʴ� ����
 *	(�����ڰ� ��ġ�� ���� ����)<br>
 *	JVM�� �ڵ����� ó���Ͽ� ���ܸ޼����� ������ش� ( ������ ������ �ܺ� ���� )
 * @author user
 */
public class UseRuntimeException {

	/**
	 * main method�� arguments�� �ΰ��� �Է¹޾� �μ��� ������ ����� ����ϴ� ��
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		try {
			num1 = Integer.parseInt( args[0] );
			num2 = Integer.parseInt( args[1] );
			
			result = num1 / num2;
			
			System.out.println(num1 + " / " + num2 + " = " + result);//���� ���
			//��Ӱ��谡 �ƴ� ����ó����ü�� ���ǿ� ���� �켱 ������ ����
		} catch(ArithmeticException ae) {
			System.err.println("0���� ���� �� �����ϴ�");
			ae.printStackTrace();//�ڼ��� ����
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			//���� ���
			System.err.println("�迭���� �ε����� �������� �ʴ� ���ܹ߻�");//�ܼ��� �޼���
			System.err.println("������ ���� ������ ���"+aioobe.getMessage() );//���� ����
			System.err.println("����ó�� Ŭ������ ���� ��� " + aioobe );// ����ó�� Ŭ������ ���� ����
			aioobe.printStackTrace(); // �ڼ��� ����
		}catch(NumberFormatException nfe) {
			System.err.println("���������� �ƴմϴ�");
			nfe.printStackTrace();//�ڼ��� ����
		} catch(Exception e ) {//����ó�� Ŭ������ �θ�Ŭ������ ��� ���ܸ� �� ���� �� �ִ�
			System.err.println("�����ڰ� �������� ���� ����");
			e.printStackTrace();
		}finally {
			System.out.println("�ݵ�� ����Ǿ���� �ڵ�");
		}
	}//main

}//class
