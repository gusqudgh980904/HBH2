package day0309;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���������� ������ ��ǻ�Ϳ� ������ �õ�
 * 211.63.89.150 ���� ip�ּ�
 * @author user
 */
public class TestClient {

	public static void main(String[] args) {
		//2.���� ����.������ ������ �õ�
		try {
			Socket client=new Socket("211.63.89.150",50000);
			System.out.println("������ ���� �Ͽ����ϴ�.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		
	}//main

}//class
