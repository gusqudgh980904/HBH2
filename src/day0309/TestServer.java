package day0309;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ʈ�� ���� ������ ��ǻ�Ͱ� ���� �ϱ⸦ ��ٸ��� ��
 * ��ǻ�Ϳ��� ������ ��Ʈ�� ������ 0~65535�����̴�.
 * ���� 1024�� ������ ��Ʈ�� �̹� ������� ��찡 �����Ƿ� ��Ʈ�浹�� �Ͼ��.(����)
 * �������̸� 1024�� ������ ��Ʈ�� ��� ���
 * @author user
 */
public class TestServer {

	public static void main(String[] args) {
		try {
			//1.������ǻ�Ϳ��� Port�� ����(Port�� �����̱� ������ ���� ���α׷� ������ �� �� �����ϸ� �����߻�)
			ServerSocket server=new ServerSocket(50000);
			System.out.println("����������");
			//3.Ŭ���̾�Ʈ���� Socket�� �����ϸ� ������ ������ �õ��Ѵ�.
			//������ �õ��ϴ� Socket�� �㰡�Ͽ� �޴´�.
			Socket client=server.accept();
			System.out.println("������ ����:"+client);
		} catch (IOException e) {
			e.printStackTrace();
		}//catch

	}//main

}//class
