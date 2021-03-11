package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  ������Ʈ ���� 5-1��
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
			
			return "���������� ������ Ƚ��(200) : "+success+"��\n������ Ƚ��(404) : "+fail+"��\n���������� ��û�� Ƚ��(403) : "+ request+"��\n"
					+ "\n���������� ������ ����(200) : "+(((float)success / (float)sum)*100)+"%"
					+"\n������ ����(404) : "+(((float)fail/(float)sum)*100)+"%"
					+"\n���������� ��û ����(403) : "+(((float)request/sum)*100)+"%";
			
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