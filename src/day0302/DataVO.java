package day0302;

/**
 *	Data�� ������ ������¸� ������ �������� ����ϴ� Ŭ����
 * @author user
 */
public class DataVO implements Cloneable {

	private String name;
	private int age;
	
	public DataVO() {
		
	}
	public DataVO(String name, int age) {
		
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	/**
	 * 	��ü����
	 * @return
	 */
	public DataVO cloneObj() {
		DataVO temp = null;
		
		try {
			temp=(DataVO)this.clone();//CompileException �߻� => �����ڴ� �ݵ�� try~catch�� ó��	
		}catch( CloneNotSupportedException cnse ) {
			System.err.println("��! �����߻� �����ȵ� : "+ cnse );
		}//end catch
		
		return temp;
	}//cloneObj

	@Override
	public String toString() {
		return super.toString() + "DataVO [name=" + name + ", age=" + age + "]";
	}
	
	
}//class
