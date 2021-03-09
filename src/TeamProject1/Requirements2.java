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
public class Requirements2 {
	
	private File log2;
	private List<Integer> list=new Vector<Integer>();
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
	
	public String Requirements2() throws IOException {
		log2= new File("c:/dev/group_prj1/sist_input_2.log");
		String log="";
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(log2));
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
			list.add(java);
			list.add(javascript);
			list.add(d8);
			list.add(jg9k);
			list.add(front);
			list.add(jsp);
			list.add(hadoop);
			list.add(res);
			list.add(ora);
			list.add(mongodb);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null) {br.close();}//if
		}//finally
		
		Integer[] arr=new Integer[list.size()];
		list.toArray(arr);
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {//최대값구하는식
			if(arr[i]>max) {
				max=arr[i];
			}//if
		}//for
		
		return "요청횟수가 가장 많은 키는 "+max+"회";	
	}//Requirements1_1
	
	
	public static void main(String[] args) {
		Requirements2 r2=new Requirements2();
			try {
				System.out.println(r2.Requirements2());
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
	}//main

}//class
