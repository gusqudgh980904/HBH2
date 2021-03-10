package kr.co.sist.javamemo.run;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.javamemo.JavaMemo;

/**
 * 메모장을 실행하기 위한 클래스
 * @author user
 */
public class RunJavaMemo {
	
	public RunJavaMemo() throws FileNotFoundException, IOException, ClassNotFoundException {
		//글꼴정보를 저장한 파일에서 글꼴을 읽어들여 디자인 객체(JavaMemo)에 전달
		ObjectInputStream ois=null;
		Font font=null;
		
		try {
			//파일에 스트림 연결
			ois=new ObjectInputStream(new FileInputStream("c:/dev/memo/memo.dat"));
			//파일에 기록된 객체를 읽기
			font=(Font)ois.readObject();
		}finally {
			//스트림 연결 끊기
			if(ois!=null) {ois.close();}
			//스트림에서 읽어들이기를 실패하더라도 연결은 반드시 끊고,사용자에게 프로그램은 제공되어야 한다
			new JavaMemo(font); //실행하는 클래스는 RunJavaMemo가 되어야합니다.
		}//finally
		
	}//RunJavaMemo

	public static void main(String[] args) {
		try {
			new RunJavaMemo();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		
	}//main

}//class
