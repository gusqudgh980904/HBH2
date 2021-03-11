package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseLogInputStream1 {
	
	private List<String> listLog1;
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
	
	public UseLogInputStream1() {
		
	}//UseLogInputStream

	public String getLog1(int startLine, int endLine) throws IOException, FileNotFoundException {

		listLog1 = new ArrayList<String>();  
		Map<String, Integer> keyMap = new HashMap<String, Integer>();
		
		File file1 = new File("c:/dev/log/sist_input_1.log");
		
		BufferedReader brLog1 = new BufferedReader(new FileReader(file1));
			
		String log1 = null;
		String maxName = null;
		int max = 0;
			
			if(file1.exists()) {
				while((log1 = brLog1.readLine()) != null) {

					listLog1.add(log1);
					
				}//end while
				
				for(int i = startLine - 1; i < endLine; i++) {
					if((listLog1.get(i).contains("key=java")) && (!listLog1.get(i).contains("script"))) {
						java++;
					}//end if
					
					if(listLog1.get(i).contains("key=javascript")) {
						javascript++;
					}//end if

					if(listLog1.get(i).contains("key=d8")) {
						d8++;
					}//end if
					
					if(listLog1.get(i).contains("key=jg9k")) {
						jg9k++;
					}//end if

					if(listLog1.get(i).contains("key=front")) {
						front++;
					}//end if
					
					if(listLog1.get(i).contains("key=jsp")) {
						jsp++;
					}//end if
					
					if(listLog1.get(i).contains("key=hadoop")) {
						hadoop++;
					}//end if
					
					if(listLog1.get(i).contains("key=res")) {
						res++;
					}//end if
					
					if(listLog1.get(i).contains("key=ora")) {
						ora++;
					}//end if

					if(listLog1.get(i).contains("key=mongodb")) {
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
			
			brLog1.close();
			
			return startLine + " ~ " + endLine + " 번 라인 중 최다 사용 키의 이름 : " + maxName + " / 횟수 : " + max + "회" ;
		}//UseLogInputStream
	
	public static void main(String[] args) {
		UseLogInputStream1 ulis1 =  new UseLogInputStream1();
		
		try {
			String maxName_Count = ulis1.getLog1(1, 100);
			System.out.println(maxName_Count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//main
	
}//class
