package day0310;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * �����������Ͽ� �������� �������� �޼����� �б� ���� Ŭ���̾�Ʈ
 * @author user
 */
public class SimpleDataClient {
	
	public SimpleDataClient() throws IOException {
		//2.������ �����Ͽ� ������ ����
		Socket client=null;
		DataInputStream dis=null;
		DataOutputStream dos=null;
		
		try {//211.63.89.150<=���� ip(public ip) �ܺο��� ��ǻ�͸� �ĺ��� �� �ִ�.
			//�缳ip(private ip) ����ip-�ܺο��� ��ǻ�͸� �ĺ��� �� ����.
			//127.0.0.1(localhost)=>loopback
			String ip=JOptionPane.showInputDialog("������ ������ �ּ� �Է�\n150,132,133,135,134,148,139");
			client=new Socket("211.63.89."+ip,65000);
			//4.�������� �������� �޼����� �б� ���ؼ� �б� ��Ʈ���� ����
			dis=new DataInputStream(client.getInputStream());
			//7.�������� ������ �޼��� �б�
			String revMsg=dis.readUTF();
			String sendMsg=JOptionPane.showInputDialog("������� �޽���\n"+revMsg);
			//8.������ �޽����� ������ ���� ���� ��Ʈ���� ����
			dos=new DataOutputStream(client.getOutputStream());
			//9.��Ʈ���� �޽��� ���
			dos.writeUTF(sendMsg);
			//10.��Ʈ���� �������� ����
			dos.flush();
			
		}finally {
			if(dos!=null) {client.close();}//if
			if(dis!=null) {dis.close();}//if
			if(client!=null) {client.close();}//if
		}//finally
		
	}//SimpleDataClient

	
	public static void main(String[] args) {
		try {
			new SimpleDataClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
