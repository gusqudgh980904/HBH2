package day0223;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Work0222 {

	private Map<String, String> bloodMap; //instance변수
	
	public String bloodType(String blood) {
		String result = "입력 혈액형은 사람의 것이 아닙니다";
		//Map 생성 : 
		bloodMap = new HashMap<String, String>(); //16개의 행 생성
		//값할당
		bloodMap.put("A", "소심하다");
		bloodMap.put("B", "성질드럽다");
		bloodMap.put("AB", "싸이코");
		bloodMap.put("O", "우유부단");
		
		//값 얻기
		blood = blood.toUpperCase(); //소문자 -> 대문자 , 대문자 -> 대문자
		//키가 존재한다면 값을 얻기
		if(bloodMap.containsKey( blood)) {//키가 존재한다면 
			result = bloodMap.get(blood);//키에 대한 값을 얻는다
		}//end if
		
		return result;
	}//bloodType
	
	public void searchBlood() {
		String inputBlood = "A";
		System.out.println(inputBlood + "형의 특징은" + bloodType(inputBlood));
	}//searchBlood
	
	public void validationMap() {
		//Map 의 모든키를 Set으로 받기
		if( bloodMap != null ) {//객체가 생성되었는지? (heap의 주소를 할당 받았는가?)
			Set<String> set =bloodMap.keySet();
			//Set을 사용검색 (Iteractor 사용)
			Iterator<String> ita = set.iterator(); //set의 제어권을 iterator로 할당
			
			String key = "";
			while(ita.hasNext()) {//값이 존재하는지?
				key = ita.next(); //값을 얻고 포인터를 다음으로 이동
				System.out.println( key + " / " + bloodMap.get(key));
			}//end while
			
		}else {
			System.out.println("Map을 검증할려면 Map의 객체가 생성되어있어야합니다");
			System.out.println("searchBlood()를 호출 후 사용가능합니다");
		}//end else
	}//validationMap
	
	public char chageChar(char ch) {
		char temp = ch;
		if(ch > 64 && ch < 91) {//대문자 -> 소문자
			temp += 32;
		}//end if
		if(ch > 96 && ch < 123) {//소문자 -> 대문자
			temp -= 32;
		}//end if
		
		return temp;
	}//change
	
	public static void main(String[] args) {
		Work0222 work = new Work0222();
//		work.searchBlood();
		work.validationMap();
		System.out.println(work.chageChar('z'));
	}//main

}//class
