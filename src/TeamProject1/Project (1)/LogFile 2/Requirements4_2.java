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
 *4. ��û�� ���� ���� �ð� [ 10 ��]
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
			
			keyMap.put("9��", nineHours);
			keyMap.put("10��", tenHours);
			keyMap.put("11��", elevenHours);
			keyMap.put("12��", twelveHours);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
		if(br!=null) {br.close();}
		}//finally
		
		int[] count = {keyMap.get("9��"), keyMap.get("10��"), keyMap.get("11��"),keyMap.get("12��")};
		
		max = count[0];
		
		for(int i = 1; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
			}//end if
		}//end for
		
		if(max == keyMap.get("9��")) {
			maxHours = "9��";
		}//end if
		if(max == keyMap.get("10��")) {
			maxHours = "10��";
		}//end if
		if(max == keyMap.get("11��")) {
			maxHours = "11��";
		}//end if
		if(max == keyMap.get("12��")) {
			maxHours = "12��";
		}//end if
		
		
		return "��û�ð��� ���� ���� �ð��� "+"["+maxHours+"]"+max+"��";
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
