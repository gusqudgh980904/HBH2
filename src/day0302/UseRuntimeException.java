package day0302;

/**
 *	RuntimeException의 처리
 *	JVM이 자동으로 처리하는 예외로, 개발자가 코드를 작성하는 단계에서는 Compile Error가 발생하지 않는 예외
 *	(개발자가 놓치기 좋은 예외)<br>
 *	JVM이 자동으로 처리하여 예외메세지를 출력해준다 ( 서버의 정보가 외부 유출 )
 * @author user
 */
public class UseRuntimeException {

	/**
	 * main method의 arguments를 두개를 입력받아 두수를 나누어 결과를 출력하는 일
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		try {
			num1 = Integer.parseInt( args[0] );
			num2 = Integer.parseInt( args[1] );
			
			result = num1 / num2;
			
			System.out.println(num1 + " / " + num2 + " = " + result);//정상 출력
			//상속관계가 아닌 예외처리객체는 정의에 대한 우선 순위가 없다
		} catch(ArithmeticException ae) {
			System.err.println("0으로 나눌 수 없습니다");
			ae.printStackTrace();//자세한 이유
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			//문제 출력
			System.err.println("배열에서 인덱스가 존재하지 않는 예외발생");//단순한 메세지
			System.err.println("간단한 예외 이유만 출력"+aioobe.getMessage() );//간단 이유
			System.err.println("예외처리 클래스와 이유 출력 " + aioobe );// 예외처리 클래스와 간단 이유
			aioobe.printStackTrace(); // 자세한 이유
		}catch(NumberFormatException nfe) {
			System.err.println("숫자형식이 아닙니다");
			nfe.printStackTrace();//자세한 이유
		} catch(Exception e ) {//예외처리 클래스의 부모클래스로 모든 예외를 다 잡을 수 있다
			System.err.println("개발자가 인지하지 못한 예외");
			e.printStackTrace();
		}finally {
			System.out.println("반드시 실행되어야할 코드");
		}
	}//main

}//class
