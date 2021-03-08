package day0222;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WorkMap {

	public void bloodType() {
		Map<String, String> type = new HashMap<String, String>();
		type.put("A", "내향적입니다. 그들이 비록 외향적으로 보일지라도 실제 내면의 모습은 조심스럽고 세심한 면이 있습니다.대체로 생각은 비관적입니다.");
		type.put("AB", "합리적입니다. 그래서 사회의 의리나 인정 그리고 가타 제도 등에 대해 관심이 적고 합리적인 반듯함을 선호하게 됩니다. ");
		type.put("O", "따스한 인간성 자신이 목표로 하고있는 일에 대하여 한결같은 노력과 전문가적인 강점으로 목표를 달성하는 추진력이 있다. ");
		type.put("B", "대체적으로 자기중심적입니다. 규율이나 규칙, 속박을 극히 싫어함. 생각이 유연하고 기발한 발상에 뛰어납니다.");
		
		System.out.println(type + " / " + type.size() );
		System.out.println("------------------------------------");
		String value = type.get("A");
		System.out.println( value );
		
		Set<String> set = type.keySet();
		Iterator<String> ita = set.iterator();
		while (ita.hasNext()) {
			System.out.println(type.get(ita.next()));
		}
	}//bloodType
	
//	public void param() {
//		char alpha = ' ';
//		for( ; ; ) {
//			alpha =(char)((int)(Math.random()*26)+65);
//			}if(alpha == ) {
//				System.out.println((char)((int)(Math.random()*26)+97));
//			}
//		System.out.println(alpha);
//		break;
//	}//param
	
	public static void main(String[] args) {
		WorkMap bt = new WorkMap();
		bt.bloodType();
//		bt.param();
	}//main

}//class
