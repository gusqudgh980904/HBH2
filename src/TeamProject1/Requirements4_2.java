package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


/**
 *4. 요청이 가장 많은 시간 [ 10 시]
 * @author user
 */
public class Requirements4_2 {
	private File log2;
	Map<String, Integer> keyMap =null;
	private int nineHours;
	private int tenHours;
	private int elevenHours;
	private int twelveHours;
	
	public String Requirements4_2() throws IOException {
		log2= new File("c:/dev/group_prj1/sist_input_2.log");
		keyMap= new HashMap<String, Integer>();
		String log="";
		int max=0;
		String maxHours="";
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader(log2));
			while((log=br.readLine())!=null) {
//				if(log.substring(log.indexOf("6")+1).contains(" 09")) {
//					nineHours++;
//				}//if
//				if(log.substring(log.indexOf("6")+1).contains(" 10")) {
//					tenHours++;
//				}//if
				if(log.substring(log.indexOf("6")+1).contains(" 11")) {
					elevenHours++;
				}//if
//				if(log.substring(log.indexOf("6")+1).contains(" 12")) {
//					twelveHours++;
//				}//if
			}//while
			
			keyMap.put("9시", nineHours);
			keyMap.put("10시", tenHours);
			keyMap.put("11시", elevenHours);
			keyMap.put("12시", twelveHours);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
		if(br!=null) {br.close();}
		}//finally
		
		int[] count = {keyMap.get("9시"), keyMap.get("10시"), keyMap.get("11시"),keyMap.get("12시")};
		
		max = count[0];
		
		for(int i = 1; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
			}//end if
		}//end for
		
		if(max == keyMap.get("9시")) {
			maxHours = "9시";
		}//end if
		if(max == keyMap.get("10시")) {
			maxHours = "10시";
		}//end if
		if(max == keyMap.get("11시")) {
			maxHours = "11시";
		}//end if
		if(max == keyMap.get("12시")) {
			maxHours = "12시";
		}//end if
		
		
		return "요청시간이 제일 많은 시간은 "+"["+maxHours+"]"+max+"번";
	}//Requirements4_2


	public static void main(String[] args) {
		Requirements4_2 r4=new Requirements4_2();
		try {
			System.out.println(r4.Requirements4_2());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//main

}//class
