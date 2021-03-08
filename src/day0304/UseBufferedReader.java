package day0304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *	Ű���忡�� �Էµ� �����͸� JVM���η� �о���̱�
 *	���� : �ѱ��� ������
 *	�ذ� : 8bit stream �� 16bit stream �� ����
 * @author user
 */
public class UseBufferedReader {
	
	public UseBufferedReader() throws IOException {
		//Ű���忡�� ���� �� �ִ� ��Ʈ�� ���
//		InputStream is = System.in;
//		//8bit ��Ʈ���� 16bit ��Ʈ���� ����
//		InputStreamReader isr = new InputStreamReader( is );
//		//�ٴ����� �б����� ������ ��Ʈ���� ����
//		BufferedReader br = new BufferedReader(isr);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�ƹ�Ű�� ������ ����");
		String text = br.readLine();
		
		System.out.println("�Է� �� : "+ text);
		
		br.close();
		
	}//UseBufferedReader

	public static void main(String[] args) {
		try {
			new UseBufferedReader();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//main

}//class
