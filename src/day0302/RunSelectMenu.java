package day0302;

public class RunSelectMenu {

	public static void main(String[] args) {
		new SelectMenu();
		DataVO2 dVO = new DataVO2();
		//��ü�� ����( ��ü�� �����ϴ� method�� �ش� ��ü�ȿ��� ȣ���� �� �ִ� -clone()�� ���� �����ڰ� protected)
//		DataVO dVO = dVO.clone();
		DataVO2 dVO1 = dVO.InputDataVO();//������ ��ü�� ��´�
		 
	}//main

}//class
