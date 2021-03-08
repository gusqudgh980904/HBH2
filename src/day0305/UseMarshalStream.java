package day0305;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *	Object Stream을 사용하여 객체를 JVM 외부로 내보내거나(ObjectOutputStream - marshaling), 
 *	JVM 외부에 존재하는 객체를 JVM 내부로 읽어들이기 위한 일(ObjedctInputStream - unmarshal)
 * @author user
 */
public class UseMarshalStream {
	
	/**
	 * 객체를 생성하여 스트림으로 내보내기
	 */
	public void useObjectOutputStream() throws FileNotFoundException, NotSerializableException, IOException {
		MyData md = new MyData("이학민", 180.5, 73.4);
	
		//1. 스트림 생성
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("c:/dev/temp1/obj.dat") );
			//2. 객체를 스트림에 쓴다
			oos.writeObject(md);
			//3. 스트림에 기록된 내용을 목적지로 분출
			oos.flush();
			System.out.println("객체가 JVM외부로 나갔음");
		}finally {
			//4. 연결 끊기
			if ( oos != null ) { oos.close(); } //end if
		}//end finally
		
	}//useObjectOutputStream
	
	
	/**
	 * 스트림을 사용하여 객체를 읽어들이기
	 */
	public void useObjectInputStream() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			//1. 객체를 읽어들일 수 있는 스트림 생성
		ois = new ObjectInputStream(new FileInputStream("c:/dev/temp1/obj.dat"));
			//2. 객체 읽기
		MyData md = (MyData) ois.readObject();
			//3. 값사용
		System.out.println("이름" + md.getName());
		System.out.println("몸무게" + md.getWeight());
		System.out.println("키" + md.getHeight());
		
		}finally {
			if( ois != null ) { ois.close(); } //end if
		}//end finally
	}//useObjectInputStream

	public static void main(String[] args) {
		UseMarshalStream ums = new UseMarshalStream();
		
		try {
				ums.useObjectInputStream();
			} catch (FileNotFoundException e) {
				System.err.println("경로확인");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("읽어들인 것인 객체가 아닌 부분");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("읽는 도중 문제 발생");
				e.printStackTrace();
		}
		
		
//		try {
//			ums.useObjectOutputStream();
//		} catch (NotSerializableException e) {
//			System.err.println("직렬화 안됨");
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			System.err.println("경로 잘못");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.err.println("쓰는도중 문제발생");
//			e.printStackTrace();
//		}
		
		
	}//main

}//class
