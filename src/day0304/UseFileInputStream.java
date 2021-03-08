package day0304;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *	8bit Stream�� ����Ͽ� ������ �����б� ( �ѱ۱���-������ �����ϸ� ������ �ʴ´� )
 * @author user
 */
public class UseFileInputStream {

	public UseFileInputStream() {
		
		File file = new File("c:/dev/temp/java_read.txt"); //������ ������ ���� �� �ִ�
		
		try {
			if( file.exists() ) {//������ �����Ѵٸ�
			FileInputStream fis = new FileInputStream(file); //���Ͽ� ��Ʈ�� �����ϰ�
//			int data = fis.read(); //ó�� ���ڸ� �о���δ�
//			System.out.println( data  );
			
			int data = 0;
			while( (data = fis.read()) != -1  ) {//read()�� �����͸� �о� ���̴ٰ� �����Ͱ� ������ -1�� ������
				System.out.print( (char)data );//1byte�� �о� ���� ������ ���. ���ڳ� ����� 1byte�̱� ������
				//1byte�� �о�鿩 ����ϸ� ������ ������, �ѱ��� �ּ� 2byte�� �������� ���ڰ� ��������� ������
				//1byte�� �о�鿩 ����ϸ� ������
			}//end while
			
			//��Ʈ�� ����� �����ٸ� ��Ʈ���� ��� �޸𸮸� Ȯ���Ѵ�
			fis.close();
			}else {
				System.err.println(file + "�� ��θ� Ȯ�����ּ���");
			}//end else
		} catch (IOException ie ) {
			System.err.println("������ �д� ���� ������ �߻�");
			ie.printStackTrace();
		}//end catch
	}//UseFileInputStream
	
	public static void main(String[] args) {
		new UseFileInputStream();
		
	}//main

}//class
