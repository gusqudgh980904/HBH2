package day0303;

/**
 *	���� ���� ���� ó�� Ŭ����
 *	CompileException : �����ڰ� �ڵ带 �ۼ��Ҷ� �ݵ�� ����ó��(try ~catch)�� �ؾ��ϴ� ����
 * @author user
 */
@SuppressWarnings("serial")
public class TobaccoException extends Exception {

		/**
		 * 	�⺻ ��� ������ ����ϴ� ������
		 */
		public TobaccoException() {
			super("����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");
		}//TobaccoException
		
		/**
		 * ������� ����ڰ� �����ϴ� ������
		 * @param msg
		 */
		public TobaccoException(String msg) {
			super( msg );
		}//TobaccoException
	
}//class
