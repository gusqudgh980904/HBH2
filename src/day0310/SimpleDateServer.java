package day0310;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 접속자가 접속하면 지정된 메세지를 보내는 메세지 서버
 * @author user
 */
public class SimpleDateServer  {
	
	public SimpleDateServer() throws IOException{
		//1.ServerSocket 생성(PORT열림)
		ServerSocket server=null;
		Socket client=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		
		try {
			server=new ServerSocket(65000);
			System.out.println("서버가동중...");
			while(true) {
				
				
		//3.접속자 소켓을 받는다
			client=server.accept();
			System.out.println("접속자 접속");
		//4.접속자에게 메세지를 보내기 위해 소켓에서 스트림을 얻는다.
			String msg="211.63.89.149 서버에 접속하였습니다.안녕하세용:)";
			dos=new DataOutputStream(client.getOutputStream());
		//5.스트림에 데이터를 기록한다.
			dos.writeUTF(msg);
		//6.목적지(소켓)로 분출 (분출된 데이터는 연결된 컴퓨터의 소켓으로 전달된다.)
			dos.flush();
		//8.접속자가 보내오는 메세지를 읽기 위한 스트림을 소켓에서 얻기
			dis=new DataInputStream(client.getInputStream());
		//11.접속자의 메세지를 읽기
			System.out.println("접속자 메세지:"+dis.readUTF());
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
