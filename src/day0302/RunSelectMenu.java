package day0302;

public class RunSelectMenu {

	public static void main(String[] args) {
		new SelectMenu();
		DataVO2 dVO = new DataVO2();
		//객체를 복제( 객체를 복제하는 method는 해당 객체안에만 호출할 수 있다 -clone()의 접근 지정자가 protected)
//		DataVO dVO = dVO.clone();
		DataVO2 dVO1 = dVO.InputDataVO();//복제된 객체를 얻는다
		 
	}//main

}//class
