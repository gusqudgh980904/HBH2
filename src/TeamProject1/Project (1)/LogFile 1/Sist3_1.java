package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  ������Ʈ ���� 4-1��
 * @author user
 */
public class Sist3_1 {
	
	//4-1��
	public String Sist4() throws IOException{
		int success = 0;
		int fail = 0;
		String temp;
		
		File file = new File("C:\\dev\\projecet\\sist_input_1.log");
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
			return "���������� ������ Ƚ��(200) : "+success+"��\n����(404) : "+fail+"��";
		}
	
	
	public static void main(String[] args) {
		try {
			Sist3_1 st = new Sist3_1();
			System.out.println(st.Sist4());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
