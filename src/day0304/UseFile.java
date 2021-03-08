package day0304;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *	HDD 에 존재하는 File의 정보를 얻기 위해 만들어진 클래스의 사용
 * @author user
 */
public class UseFile {

	public UseFile() {
		//1.객체생성
		File file = new File("c:/dev/temp/java_read.txt");
		System.out.println( file );//객체를 출력했을 때 주소가 나오지 않는 이유? java.lang.Object 클래스의 toString()를 Override했기때문
		System.out.println("파일이 존재?"+file.exists());
		
		try {
			System.out.println("규범경로 : " +file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		System.out.println("절대경로 : "+file.getAbsolutePath());
		System.out.println("상대경로 : "+file.getPath()); //절대경로(AbsolutePath)랑 똑같
		
		System.out.println("파일이 있는 폴더명 : " + file.getParent());
		System.out.println("파일명 : " + file.getName());
		
		System.out.println("파일?  " + file.isFile());
		System.out.println("폴더?  " + file.isDirectory());
		
		System.out.println("실행가능?  " + file.canExecute());
		System.out.println("읽기가능?  " + file.canRead());
		System.out.println("쓰기가능?  " + file.canWrite()); //쓰기불가능한 파일 ODD
		
		System.out.println("숨김파일?  " + file.isHidden());
		long lm = file.lastModified();
		System.out.println("마지막으로 수정된 날짜 : " + lm);
		Date date = new Date(lm);
		System.out.println(date); //마지막으로 수정된 날짜를 볼 수 있다=>원하는 형식변환 : SimpleDateFormat

		
//		System.out.println("파일삭제?  " + file.delete());
		
		File mk = new File("c:/test/temp");
		mk.mkdir();
		System.out.println("폴더생성?  " + mk.mkdir()); //make directory -폴더가 하나이면 어디든 생성가능
																		//최상위폴더부터 생성하는데 하위폴더가 존재하면 생성
		System.out.println("폴더생성?  " + mk.mkdirs()); //-폴더가 하나이면 어디든 생성가능
																		// 하위폴더가 존재하더라도 생성가능
		
	}//UseFile
	
	public static void main(String[] args) {
		new UseFile();
	}//main

}//class
