package day0222;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WorkMap {

	public void bloodType() {
		Map<String, String> type = new HashMap<String, String>();
		type.put("A", "�������Դϴ�. �׵��� ��� ���������� �������� ���� ������ ����� ���ɽ����� ������ ���� �ֽ��ϴ�.��ü�� ������ ������Դϴ�.");
		type.put("AB", "�ո����Դϴ�. �׷��� ��ȸ�� �Ǹ��� ���� �׸��� ��Ÿ ���� � ���� ������ ���� �ո����� �ݵ����� ��ȣ�ϰ� �˴ϴ�. ");
		type.put("O", "������ �ΰ��� �ڽ��� ��ǥ�� �ϰ��ִ� �Ͽ� ���Ͽ� �Ѱᰰ�� ��°� ���������� �������� ��ǥ�� �޼��ϴ� �������� �ִ�. ");
		type.put("B", "��ü������ �ڱ��߽����Դϴ�. �����̳� ��Ģ, �ӹ��� ���� �Ⱦ���. ������ �����ϰ� ����� �߻� �پ�ϴ�.");
		
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
