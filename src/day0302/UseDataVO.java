package day0302;

/**
 *	������ DataVO��ü�� �����Ͽ� ����ϴ� Ŭ����
 * @author user
 */
public class UseDataVO {

	public static void main(String[] args) {

		//������ Ŭ������ ��üȭ
		DataVO dVO = new DataVO("�ڱ��",20);
		//��ü�� ����( ��ü�� �����ϴ� method�� �ش� ��ü�ȿ��� ȣ���� �� �ִ� -clone()�� ���� �����ڰ� protected)
//		DataVO dVO = dVO.clone();
		DataVO dVO2 = dVO.cloneObj();//������ ��ü�� ��´�
		
		System.out.println("���� ��ü �ּ� : "+ dVO);
		System.out.println("������ ��ü �ּ� : "+ dVO2);
		
		
	}//main
	
}//class


