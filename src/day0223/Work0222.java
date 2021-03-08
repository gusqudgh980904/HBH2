package day0223;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Work0222 {

	private Map<String, String> bloodMap; //instance����
	
	public String bloodType(String blood) {
		String result = "�Է� �������� ����� ���� �ƴմϴ�";
		//Map ���� : 
		bloodMap = new HashMap<String, String>(); //16���� �� ����
		//���Ҵ�
		bloodMap.put("A", "�ҽ��ϴ�");
		bloodMap.put("B", "�����巴��");
		bloodMap.put("AB", "������");
		bloodMap.put("O", "�����δ�");
		
		//�� ���
		blood = blood.toUpperCase(); //�ҹ��� -> �빮�� , �빮�� -> �빮��
		//Ű�� �����Ѵٸ� ���� ���
		if(bloodMap.containsKey( blood)) {//Ű�� �����Ѵٸ� 
			result = bloodMap.get(blood);//Ű�� ���� ���� ��´�
		}//end if
		
		return result;
	}//bloodType
	
	public void searchBlood() {
		String inputBlood = "A";
		System.out.println(inputBlood + "���� Ư¡��" + bloodType(inputBlood));
	}//searchBlood
	
	public void validationMap() {
		//Map �� ���Ű�� Set���� �ޱ�
		if( bloodMap != null ) {//��ü�� �����Ǿ�����? (heap�� �ּҸ� �Ҵ� �޾Ҵ°�?)
			Set<String> set =bloodMap.keySet();
			//Set�� ���˻� (Iteractor ���)
			Iterator<String> ita = set.iterator(); //set�� ������� iterator�� �Ҵ�
			
			String key = "";
			while(ita.hasNext()) {//���� �����ϴ���?
				key = ita.next(); //���� ��� �����͸� �������� �̵�
				System.out.println( key + " / " + bloodMap.get(key));
			}//end while
			
		}else {
			System.out.println("Map�� �����ҷ��� Map�� ��ü�� �����Ǿ��־���մϴ�");
			System.out.println("searchBlood()�� ȣ�� �� ��밡���մϴ�");
		}//end else
	}//validationMap
	
	public char chageChar(char ch) {
		char temp = ch;
		if(ch > 64 && ch < 91) {//�빮�� -> �ҹ���
			temp += 32;
		}//end if
		if(ch > 96 && ch < 123) {//�ҹ��� -> �빮��
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
