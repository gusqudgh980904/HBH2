package day0303;

import day0302.UseJOptionPane;

/**
 *	method안에서 발생하는 예외를 호출하는 곳에서 처리하도록 만드는 throws
 *	예외발생코드와 예외처리코드를 분리하여 작성할 수 있다
 * @author user
 */
public class UseThrows {

	/**
	 * Class.forName method를 사용하여 객체 생성
	 */
	public void useClass() throws ClassNotFoundException{
		//throws를 정의하면 method안에서 try~catch로 예외를 처리하지 않아도 된다 호출하는 곳에서 처리
//		Class<String> c = (Class<String>) Class.forName("java.lang.String");
		Class<UseJOptionPane> c = (Class<UseJOptionPane>) Class.forName("day0302.UseJOptionPane");
		//윗줄에서 예외를 발생시키면 아랫줄의 코드는 실행되지 않는다
		System.out.println("객체 : " + c );
	}//useClass
	
	public void callUseClass() {
		try {
		useClass();//throws된 예외 중 Compile Exception은 반드시 처리해야한다
		}catch( ClassNotFoundException cnfe ) {
			System.err.println("클래스명 또는 패키지명을 확인하세요");
			cnfe.printStackTrace(); //자세한 예외의 이유를 출력
		}//end catch
	}//callUseClass
	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		ut.callUseClass();
	}//main

}//class
