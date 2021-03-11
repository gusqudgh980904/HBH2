package TeamProject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisLog1 {
	/**
	 * 1. 최다사용 키의 이름과 횟수  |  java xx회
	 * 키의 종류:java,javascript,d8,jg9k,front,jsp,hadoop ,res,ora,mongodb
	 * @author user
	 */
	public class MaxKey {
		
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
					
					if(log.contains("java") &&!log.contains("script")) {
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
					if(log.contains("ora&")) {
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
	}		
	
			public String GoValue() throws IOException{
				int ie = 0;
				int opera = 0;
				int firefox = 0;
				int chrome = 0;
				int safari = 0;

				
				String temp;
				String temp2;
				File file = new File("c:/dev/group_prj1/sist_input_1.log");
				BufferedReader br = null; 
				br = new BufferedReader(new FileReader(file));
				int Total=0;

				while((temp = br.readLine())!=null) {
					String[] sTmp = temp.split("\\]\\[");
						switch (sTmp[2]) {
						case "ie": ie++; break;
						case "opera": opera++; break;
						case "firefox": firefox++; break;
						case "Chrome": chrome++; break;
						case "Safari": safari++; break;
					}//end switch
						Total++;
				}//end while
			
				System.out.println("--------------------------------------------------------------------------");
//				System.out.println("Total="+Total);
				System.out.println("ie 들어간 횟수 = " +ie +" 번");
				System.out.println("opera 들어간 횟수 = "+opera+" 번");
				System.out.println("firefox 들어간 횟수 = "+firefox+" 번");
				System.out.println("chrome 들어간 횟수 = "+chrome+" 번");
				System.out.println("Safari 들어간 횟수 = "+safari+" 번");
				System.out.println();
				System.out.println( "ie 들어간 비율 = " + ((float)ie /(float)Total)*100+" %" );
				System.out.println( "opera 들어간 비율 = " + ((float)opera /(float)Total)*100+" %" );
				System.out.println( "firefox 들어간 비율 = " + ((float)firefox /(float)Total)*100+" %" );
				System.out.println( "chrome 들어간 비율 = " + ((float)chrome /(float)Total)*100+" %" );
				System.out.println( "Safari 들어간 비율 = " + ((float)safari /(float)Total)*100+" %" );
				System.out.println("--------------------------------------------------------------------------");
				if( br != null) {br.close();}
						return "";
				
			}//GoValue 

			public String DoneValue() throws IOException{
				int success = 0;
				int fail = 0;
				String temp;
				
				File file = new File("c:/dev/group_prj1/sist_input_1.log");
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
					return "성공적으로 수행한 횟수(200) : "+success+"번\n실패(404) : "+fail+"번";
				
			}//DoneValue
			
			private File log1;
			Map<String, Integer> keyMap =null;
			private int nineHours;
			private int tenHours;
			private int elevenHours;
			
			public String MaxRequest() throws IOException {
				log1= new File("c:/dev/group_prj1/sist_input_1.log");
				keyMap= new HashMap<String, Integer>();
				String log="";
				int max=0;
				String maxHours="";
				BufferedReader br=null;
				
				try {
					br=new BufferedReader(new FileReader(log1));
					while((log=br.readLine())!=null) {
						if(log.substring(log.indexOf("5")+1).contains(" 09")) {
							nineHours++;
						}//if
						if(log.substring(log.indexOf("5")+1).contains(" 10")) {
							tenHours++;
						}//if
						if(log.substring(log.indexOf("5")+1).contains(" 11")) {
							elevenHours++;
						}//if
					}//while
					
					keyMap.put("9시", nineHours);
					keyMap.put("10시", tenHours);
					keyMap.put("11시", elevenHours);
					
					
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
				if(br!=null) {br.close();}
				}//finally
				
				int[] count = {keyMap.get("9시"), keyMap.get("10시"), keyMap.get("11시")};
				
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
				
				
				return "요청시간이 제일 많은 시간은 "+"["+maxHours+"]"+max+"번";
			}//MaxRequest
	
			public String  ErrorValue() throws IOException{
				int success = 0;
				int fail = 0;
				int request =0;
				String temp;
				
				File file = new File("c:/dev/group_prj1/sist_input_1.log");
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
					
					return "성공적으로 수행한 횟수(200) : "+success+"번\n실패한 횟수(404) : "+fail+"번\n비정상적인 요청인 횟수(403) : "+ request+"번\n"
							+ "\n성공적으로 수행한 비율(200) : "+(((float)success / (float)sum)*100)+"%"
							+"\n실패한 비율(404) : "+(((float)fail/(float)sum)*100)+"%"
							+"\n비정상적인 요청 비율(403) : "+(((float)request/sum)*100)+"%";
					
				}// ErrorValue
			

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
				
			
			public String RangeMaxKey(int startLine, int endLine) throws IOException, FileNotFoundException {

				listLog1 = new ArrayList<String>();  
				Map<String, Integer> keyMap = new HashMap<String, Integer>();
				
				File file1 = new File("c:/dev/group_prj1/sist_input_1.log");
				
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
			}
}
			