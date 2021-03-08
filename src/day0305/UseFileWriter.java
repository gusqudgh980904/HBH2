package day0305;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *	16bit Stream을 사용한 파일에 문자열 기록하기
 * @author user
 */
public class UseFileWriter {

	public UseFileWriter() throws IOException{
		String data = "아버님이 누구인지 궁금합니다.";
		
		File file = new File("c:/dev/temp1/string_data.txt");
		
		BufferedWriter bw = null;
		
		try {
			//1.스트림 목적지 파일에 연결한다
			bw = new BufferedWriter(new FileWriter(file));
			//2.스트림에 파일로 기록할 내용을 쓴다.
			bw.write( data );
			//3.스트림에 기록된 내용을 목적지 파일로 분출
			bw.flush();
			
			System.out.println("파일에 기록 되었습니다");
		}finally {
			//4.스트림 연결 끊기  (스트림에 기록된 내용이 목적지로 분출되고 연결이 끊어진다)                                         
			if( bw != null ) { bw.close(); }//end if
		}//end finally
		
	}//UseFileWriter
	
	public static void main(String[] args) {
		
		try {
			new UseFileWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//main

}//class
