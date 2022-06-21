
public class Human {
	private String name; //멤버변수 선언
	private int age;
	
	public Human(String name, int age){ //매개변수로 이름과 나이를 받아와서 멤버 변수 값 초기화
		this.name = name;
		this.age = age;
	}

	public String getName() { //name을 반환하는 접근자 메소드
		return name;
	}

	public void setName(String name) { //name을 설정하는 설정자 메소드
		this.name = name;
	}

	public int getAge() { //age를 반환하는 접근자 메소드
		return age;
	}

	public void setAge(int age) { //age를 설정하는 설정자 메소드
		this.age = age;
	}

	
	public String toString() { //객체의 현재 값들을 문자열로 반환
		return "이름: " + name + ", 나이: " + age ;
	}
	
}
