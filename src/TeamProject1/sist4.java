package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  프로젝트 문제 4번
 * @author user
 */
public class sist4 {

	public String Sist4() throws IOException{
		int success = 0;
		int fail = 0;
		String temp;
		
		File file = new File("c:/dev/group_prj1/sist_input_1.log");
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(file));
		
		while((temp = br.readLine())!=null) {
			if(temp.substring(1,4).equals("200")) {
				success++;
			}else if(temp.substring(1,4).equals("404")){
				fail++;
			}	
		}
			if( br != null) {br.close();}
			return "성공적으로 수행한 횟수(200) : "+success+"번\n실패(404) : "+fail+"번";
		}
	
	public static void main(String[] args) {
		try {
			sist4 st = new sist4();
			System.out.println(st.Sist4());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
