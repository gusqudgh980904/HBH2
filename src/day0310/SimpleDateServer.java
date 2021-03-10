package day0310;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ڰ� �����ϸ� ������ �޼����� ������ �޼��� ����
 * @author user
 */
public class SimpleDateServer  {
	
	public SimpleDateServer() throws IOException{
		//1.ServerSocket ����(PORT����)
		ServerSocket server=null;
		Socket client=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		
		try {
			server=new ServerSocket(65000);
			System.out.println("����������...");
			while(true) {
				
				
		//3.������ ������ �޴´�
			client=server.accept();
			System.out.println("������ ����");
		//4.�����ڿ��� �޼����� ������ ���� ���Ͽ��� ��Ʈ���� ��´�.
			String msg="211.63.89.149 ������ �����Ͽ����ϴ�.�ȳ��ϼ���:)";
			dos=new DataOutputStream(client.getOutputStream());
		//5.��Ʈ���� �����͸� ����Ѵ�.
			dos.writeUTF(msg);
		//6.������(����)�� ���� (����� �����ʹ� ����� ��ǻ���� �������� ���޵ȴ�.)
			dos.flush();
		//8.�����ڰ� �������� �޼����� �б� ���� ��Ʈ���� ���Ͽ��� ���
			dis=new DataInputStream(client.getInputStream());
		//11.�������� �޼����� �б�
			System.out.println("������ �޼���:"+dis.readUTF());
			}//whie
			
		}finally {
			if(dos!=null) {dos.close();}//if
			if(dis!=null) {dis.close();}//if
			if(client!=null) {client.close();}//if
			if(server!=null) {server.close();}//if
		}//finally
		
	}//SimpleDateServer

	
	public static void main(String[] args) {
		try {
			new SimpleDateServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
