package day0303;

import java.io.IOException;

/**
 *	입력의 근원이 Keyboard일때의 처리
 * @author user
 */
public class UseSystemInput {
	
	public UseSystemInput() {
		
		System.out.println("아무키나 누르고 엔터를 치세요");
		/////////////////처음 한 글자 읽기 //////////////////////////////////////
//		try {
//		int keyValue = System.in.read();
//		System.out.println("입력한 값 : "+ keyValue+ "\t"+ (char)keyValue);
//		}catch( IOException ie) {
//			System.err.println("키보드 입력 중 문제가 발생" +ie );
//		}//end catch
		
		/////////////////1 byte로 된 여러 글자(한글 못읽음) 읽기 ////////////////
		
		int readChar = 0;
		
		try {
		while( (readChar = System.in.read()) != 10 ) {
			System.out.print( (char)readChar );
		}//end while
		}catch(IOException ie) {
			System.err.println("문제발생!!!");
		}//end catch
		
	}//UseSystemInput
	
	public static void main(String[] args) {
		new UseSystemInput();
	}//main

}//class
