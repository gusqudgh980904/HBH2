package day0303;

import java.util.Random;

public class UseDefineException {

	/**
	 * 	��踦 �ǿ�� ���� �����ϸ� ���� ����
	 * @return
	 */
	public String kibum() throws TobaccoException {
//	public String kibum() throws Exception {//kibum�� ����ϸ� ���ܰ� �߻��ϴµ� � ������ �������� �� �� ����
		String result = "";
		
		String[] stuGrade = {"�ʵ�","�ߵ�","���"};
		
		String temp = stuGrade[ new Random().nextInt(stuGrade.length)];
		if( temp.equals("�ʵ�") ) {//���ڰ� �ʵ��̶�� ���ܸ� �߻�
//			throw new Exception(temp + "�� �ݿ���!!"); //� ���ܰ� �߻��ߴ��� �˱� ��ƴ�
			throw new TobaccoException(temp + "�� �ݿ���!!"); 
		}//end if
		
		result = temp + "���� �� �� �� ô ��������";
		
		return result;
	}//kibum
	
	public static void main(String[] args) {

		UseDefineException ude = new UseDefineException();
		try {
			System.out.println( ude.kibum() );//����� ����ϸ� ����(����)�� �߻��Ѵ�
		} catch (TobaccoException e) { //�߻��� ���ܸ� ��Ȯ�ϰ� �����Ͽ� ó���� �� �ִ�
			e.printStackTrace(); //�߻��� ������ ���
		} //end catch
		
	}//main

}//class
