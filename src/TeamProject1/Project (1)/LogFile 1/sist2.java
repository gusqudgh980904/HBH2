package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class sist2 {
	
	public String Sist2() throws IOException{
		int ie = 0;
		int opera = 0;
		int firefox = 0;
		int chrome = 0;
		int safari = 0;

		
		String temp;
		String temp2;
		File file = new File("C:\\dev\\project\\sist_input_1.log");
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader(file));
		int Total=0;

		while((temp = br.readLine())!=null) {
			String[] sTmp = temp.split("\\]\\[");
//			for(int i=0; i<sTmp.length; i++) {
				switch (sTmp[2]) {
				case "ie": ie++; break;
				case "opera": opera++; break;
				case "firefox": firefox++; break;
				case "Chrome": chrome++; break;
				case "Safari": safari++; break;
			}//end switch
//				System.out.println("sTmp["+i+"]="+sTmp[i]);
//		}//end for
				Total++;
		}//end while
	
		System.out.println("--------------------------------------------------------------------------");
//		System.out.println("Total="+Total);
		System.out.println("ie �� Ƚ�� = " +ie +" ��");
		System.out.println("opera �� Ƚ�� = "+opera+" ��");
		System.out.println("firefox �� Ƚ�� = "+firefox+" ��");
		System.out.println("chrome �� Ƚ�� = "+chrome+" ��");
		System.out.println("Safari �� Ƚ�� = "+safari+" ��");
		System.out.println();
		System.out.println( "ie �� ���� = " + ((float)ie /(float)Total)*100+" %" );
		System.out.println( "opera �� ���� = " + ((float)opera /(float)Total)*100+" %" );
		System.out.println( "firefox �� ���� = " + ((float)firefox /(float)Total)*100+" %" );
		System.out.println( "chrome �� ���� = " + ((float)chrome /(float)Total)*100+" %" );
		System.out.println( "Safari �� ���� = " + ((float)safari /(float)Total)*100+" %" );
		System.out.println("--------------------------------------------------------------------------");
		if( br != null) {br.close();}
				return "";
		
	}//Sist2

	public static void main(String[] args) throws IOException {
		try {
			sist2 st = new sist2();
			System.out.println(st.Sist2());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}//main

}//class
