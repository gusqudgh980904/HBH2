package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * 1. 최다사용 키의 이름과 횟수  |  java xx회
 * 키의 종류:java,javascript,d8,jg9k,front,jsp,hadoop,res,ora,mongodb
 * @author user
 */
public class Requirements1 {
	
	private File log1;
	private List<Integer> list1=new Vector<Integer>();
	private int java=0;
	private int javascript=0;
	private int d8=0;
	private int jg9k=0;
	private int front=0;
	private int jsp=0;
	private int hadoop=0;
	private int res=0;
	private int ora=0;
	private int mongodb=0;
	
	public String Requirements1_1() throws IOException {//1번 로그
		log1= new File("c:/dev/group_prj1/sist_input_1.log");
		String log="";
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(log1));
			while((log=br.readLine())!=null) {//각 키가 얼마나 들어있는지
				if(log.contains("java")) {
					java++;
				}//if
				if(log.contains("javascript")) {
					javascript++;
				}//if
				if(log.contains("d8")) {
					d8++;
				}//if
				if(log.contains("jg9k")) {
					jg9k++;
				}//if
				if(log.contains("front")) {
					front++;
				}//if
				if(log.contains("jsp")) {
					jsp++;
				}//if
				if(log.contains("hadoop")) {
					hadoop++;
				}//if
				if(log.contains("res")) {
					res++;
				}//if
				if(log.contains("ora")) {
					ora++;
				}//if
				if(log.contains("mongodb")) {
					mongodb++;
				}//if
			}//while
			list1.add(java);
			list1.add(javascript);
			list1.add(d8);
			list1.add(jg9k);
			list1.add(front);
			list1.add(jsp);
			list1.add(hadoop);
			list1.add(res);
			list1.add(ora);
			list1.add(mongodb);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) {br.close();}//if
		}//finally
		
		Integer[] arr=new Integer[list1.size()];
		list1.toArray(arr);
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {//최대값구하는식
			if(arr[i]>max) {
				max=arr[i];
			}//if
		}//for
		
		return "요청횟수가 가장 많은 키는 "+max+"회";	
	}//Requirements1_1
	

	
	
	public static void main(String[] args) {
		Requirements1 r1=new Requirements1();
			try {
				System.out.println(r1.Requirements1_1());
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
	}//main

}//class
