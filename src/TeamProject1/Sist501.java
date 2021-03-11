package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  프로젝트 문제 5-1번
 */
public class Sist501 {

	public String Sist5() throws IOException{
		int success = 0;
		int fail = 0;
		int request =0;
		String temp;
		
		File file = new File("C:\\dev\\project\\sist_input_1.log");
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(file));
		int sum = 0;
		
		while((temp = br.readLine())!=null) {
			if(temp.substring(1,4).equals("200")) {
				success++;
			}
			if(temp.substring(1,4).equals("404")){
				fail++;
			}
			if(temp.substring(1,4).equals("403")) {
				request++;
			}
			sum++;
		}//while

			if( br != null) {br.close();}//end if
			
			return "성공적으로 수행한 횟수(200) : "+success+"번\n실패한 횟수(404) : "+fail+"번\n비정상적인 요청인 횟수(403) : "+ request+"번\n"
					+ "\n성공적으로 수행한 비율(200) : "+(((float)success / (float)sum)*100)+"%"
					+"\n실패한 비율(404) : "+(((float)fail/(float)sum)*100)+"%"
					+"\n비정상적인 요청 비율(403) : "+(((float)request/sum)*100)+"%";
			
		}//Sist5
	
	public static void main(String[] args) {
			Sist501 st = new Sist501();
			try {
				st.Sist5();
				System.out.println(st.Sist5());
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
			
	}//main 
	
}//class