package day0305;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseDataOutputStream {

	public UseDataOutputStream() throws IOException {
		
		DataOutputStream dos = null; //기본형 데이터형을 쓰기위한 스트림
		DataInputStream dis = null; //기본형 데이터형을 읽기위한 스트림
		
		try {
			//1. 스트림 생성
			dos = new DataOutputStream(new FileOutputStream("c:/dev/temp1/write1.txt"));
			dis = new DataInputStream(new FileInputStream("c:/dev/temp1/write1.txt"));
			//2. 스트림에 기록
			int data = Integer.MAX_VALUE;
			dos.writeInt(data); // int -> writeInt() , long -> writeLong() , boolean -> writeBoolean
			dos.writeBoolean(true);
			//3. 목적지로 분출
			dos.flush();
			System.out.println("파일 생성 완료");
			
			//파일에 기록된 기본형데이터형을 읽어들이기
			System.out.println("정수 : " + dis.readInt());
			System.out.println("불린 : " + dis.readBoolean());
			
		}finally {
			if( dos != null ) { dos.close(); }//end if
			if( dis != null ) { dos.close(); }//end if
		} //end finally
	}//UseDataOutputStream
	public static void main(String[] args) {
		
		try {
			new UseDataOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
