package day0302;

public class DataVO2  implements Cloneable {
	private String name;
	private int age;
	
	public DataVO2 InputDataVO(){
		return null;
		
	}

	public DataVO2 InputDataVO(String name, int age ){
		DataVO2 temp = null;
		
		try {
			temp=(DataVO2)this.clone();//CompileException 발생 => 개발자는 반드시 try~catch를 처리	
		}catch( CloneNotSupportedException cnse ) {
			System.err.println("아! 문제발생 복제안됨 : "+ cnse );
		}//end catch
		
		return temp;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	
	
}//class
