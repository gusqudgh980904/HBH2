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
 * 1. 최다사용 키의 이름과 횟수  |  java xx회
 * 키의 종류:java,javascript,d8,jg9k,front,jsp,hadoop,res,ora,mongodb
 * @author user
 */
public class Requirements1_1 {
	
	private File log1;
	Map<String, Integer> keyMap =null;
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
	
	public String Requirements1_1() throws IOException {//1번 로그
		log1= new File("c:/dev/group_prj1/sist_input_1.log");
		keyMap= new HashMap<String, Integer>();
		String log="";
		BufferedReader br=null;
		int max=0;
		String maxName=null;
		try {
			br=new BufferedReader(new FileReader(log1));
			while((log=br.readLine())!=null) {//각 키가 얼마나 들어있는지
				
				if(log.contains("key=java")&&!log.contains("script")) {
					java++;
				}//
				if(log.contains("key=javascript")) {
					javascript++;
				}//if
				if(log.contains("key=d8")) {
					d8++;
				}//if
				if(log.contains("key=jg9k")) {
					jg9k++;
				}//if
				if(log.contains("key=front")) {
					front++;
				}//if
				if(log.contains("key=jsp")) {
					jsp++;
				}//if
				if(log.contains("key=hadoop")) {
					hadoop++;
				}//if
				if(log.contains("key=res")) {
					res++;
				}//if
				if(log.contains("key=ora")) {
					ora++;
				}//if
				if(log.contains("mongodb")) {
					mongodb++;
				}//if
			}//while
			
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) {br.close();}//if
		}//finally
		
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
		
		return "요청횟수가 가장 많은 키는 "+maxName+" "+max+"회";	
	}//Requirements1_1
	
	
	public static void main(String[] args) {
		Requirements1_1 r1=new Requirements1_1();
			try {
				System.out.println(r1.Requirements1_1());
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
	}//main

}//class
