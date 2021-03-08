package day0305;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *	JVM 내부의 데이터를 JVM 외부로 내보내기위한 스트림
 * @author user
 */
public class UseFileOutputStream {

	public UseFileOutputStream() throws IOException{
		//c:/dev/temp1 이라는 폴더가 존재하지 않으면 폴더를 생성하고
		//폴더가 존재하면 폴더를 생성하지 않는다
		File dir = new File("c:/dev/temp1");
		
		if(!dir.exists()) {
			dir.mkdirs();
		}//end if
		
		File file = new File(dir.getAbsolutePath() + "/write_test.txt");
		//파일이 없다면 파일 생성하고, 존재한다면 덮어쓸것인지를 ConfirmDialog를 사용하여 물어보고, "Yes"가 눌려지면
		//파일에 덮어 쓰고, 그렇지 않다면 파일에 덮어쓰지 않도록 코드 작성
		
		boolean overWriteFlag = false;
		
		if(file.exists()) {
			
		switch ( JOptionPane.showConfirmDialog(null, file+"이 있음. 덮어쓰겠습니까?")) {
		case JOptionPane.OK_OPTION: 
			overWriteFlag=true;
		}//end switch
		} else {//파일이 없는 경우
			overWriteFlag=true;
		}//end else
		
		if(overWriteFlag) {
			FileOutputStream fos = null;
		//		FileOutputStream fos = new FileOutputStream(file);
			try {
				//1.스트림 생성
				fos = new FileOutputStream(file);
				//2.스트림에 파일로 기록 내용 쓰기
				fos.write(97);
				//3. 스트림에 기록된 내용을 목적지로 분출
			}finally {
				//4. 스트림 사용이 종료되었으면 연결 끊
				if( fos != null ) { fos.close();}//end if
			}//end finally
		}//end if
		
	}//UseFileOutputStream
	
	public static void main(String[] args) {
		
		try {
			new UseFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//main

}//class
