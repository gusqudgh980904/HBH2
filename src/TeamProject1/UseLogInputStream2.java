package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseLogInputStream2 {
	
	private List<String> listLog2;
	private int java;
	private int javascript;
	private int d8;
	private int jg9k;
	private int front;
	private int jsp;
	private int hadoop;
	private int res;
	private int ora;
	private int mongodb;
	
	public String getLog2(int startLine, int endLine) throws IOException {
		
		listLog2 = new ArrayList<String>();
		Map<String, Integer> keyMap = new HashMap<String, Integer>();
		
		File file2 = new File("c:/dev/log/sist_input_2.log");
		
		BufferedReader brLog2 = new BufferedReader(new FileReader(file2));
		
		String log2 = null; 
		String maxName = null;
		int max = 0;
		
		if(file2.exists()) {
			while((log2 = brLog2.readLine()) != null) {
				listLog2.add(log2);
			}//end while

			for(int i = startLine - 1; i < endLine; i++) {
				if(listLog2.get(i).contains("key=java") && (!listLog2.get(i).contains("script"))) {
					java++;
				}//end if
				
				if(listLog2.get(i).contains("key=javascript")) {
					javascript++;
				}//end if

				if(listLog2.get(i).contains("key=d8")) {
					d8++;
				}//end if
				
				if(listLog2.get(i).contains("key=jg9k")) {
					jg9k++;
				}//end if

				if(listLog2.get(i).contains("key=front")) {
					front++;
				}//end if
				
				if(listLog2.get(i).contains("key=jsp")) {
					jsp++;
				}//end if
				
				if(listLog2.get(i).contains("key=hadoop")) {
					hadoop++;
				}//end if
				
				if(listLog2.get(i).contains("key=res")) {
					res++;
				}//end if
				
				if(listLog2.get(i).contains("key=ora")) {
					ora++;
				}//end if

				if(listLog2.get(i).contains("key=mongodb")) {
					mongodb++;
				}//end if
			}//end for
			
			keyMap.put("java", java);
			keyMap.put("javascript", javascript);
			keyMap.put("jg9k", jg9k);
			keyMap.put("d8", d8);
			keyMap.put("front", front);
			keyMap.put("jsp", jsp);
			keyMap.put("hadoop", hadoop);
			keyMap.put("res", res);
			keyMap.put("ora", ora);
			keyMap.put("mongodb", mongodb);
		
			int[] count = {keyMap.get("java"), keyMap.get("javascript"), keyMap.get("jg9k"), keyMap.get("d8"), keyMap.get("front"), keyMap.get("jsp"), keyMap.get("hadoop"),
					keyMap.get("res"), keyMap.get("ora"), keyMap.get("mongodb")};
			
			max = count[0];
			
			for(int i = 1; i < count.length; i++) {
				if(max < count[i]) {
					max = count[i];
				}//end if
			}//end for
			
			if(max == keyMap.get("java")) {
				maxName = "java";
			}//end if

			if(max == keyMap.get("javascript")) {
				maxName = "javascript";
			}//end if
			
			if(max == keyMap.get("jg9k")) {
				maxName = "jg9k";
			}//end if

			if(max == keyMap.get("d8")) {
				maxName = "d8";
			}//end if
			
			if(max == keyMap.get("front")) {
				maxName = "front";
			}//end if
			
			if(max == keyMap.get("jsp")) {
				maxName = "jsp";
			}//end if
			
			if(max == keyMap.get("hadoop")) {
				maxName = "hadoop";
			}//end if
			
			if(max == keyMap.get("res")) {
				maxName = "res";
			}//end if
			
			if(max == keyMap.get("ora")) {
				maxName = "ora";
			}//end if
			
			if(max == keyMap.get("mongodb")) {
				maxName = "mongodb";
			}//end if
		}//end if
		
		brLog2.close();
		
		return startLine + " ~ " + endLine + " 번 라인 중 최다 사용 키의 이름 : " + maxName + " / 횟수 : " + max + "회" ;
	}//getLog2

	public static void main(String[] args) {
		UseLogInputStream2 ulis2 = new UseLogInputStream2();
		
		String maxName_count;
		try {
			maxName_count = ulis2.getLog2(1000, 1500);
			System.out.println(maxName_count);
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
