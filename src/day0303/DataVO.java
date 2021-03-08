package day0303;

/**
 *	데이터를 저장하고 사용할 목적
 * @author user
 */
public class DataVO {
	private String name;
	private int age;
	
	public DataVO() {
	}

	public DataVO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	//생성자 ,매개변수 생성자, getter
	
}
