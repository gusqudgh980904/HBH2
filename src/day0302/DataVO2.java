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
			temp=(DataVO2)this.clone();//CompileException �߻� => �����ڴ� �ݵ�� try~catch�� ó��	
		}catch( CloneNotSupportedException cnse ) {
			System.err.println("��! �����߻� �����ȵ� : "+ cnse );
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
