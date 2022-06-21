
public class Person {
	private String name, address, tel; //멤버 변수 선언

	public Person() { //매개변수 없는 생성자 선언
		this.name = "숙명";
		this.address = "서울";
		this.tel = "010-1234-5678";
	}
	public Person(String name, String address, String tel) { //매개변수 있는 생성자 선언. 매개변수의 값으로 변수들 초기화
		this.name = name;
		this.address = address;
		this.tel = tel;
	}
	public String getName() { //이름을 반환하는 접근자 메소드
		return name;
	}

	public void setName(String name) { //이름을 설정하는 설정자 메소드
		this.name = name;
	}

	public String getAddress() { //주소를 반환하는 접근자 메소드
		return address;
	}

	public void setAddress(String address) { //주소를 설정하는 설정자 메소드
		this.address = address;
	}

	public String getTel() { //전화번호를 반환하는 접근자 메소드
		return tel;
	}

	public void setTel(String tel) { //전화번호를 설정하는 설정자 메소드
		this.tel = tel;
	}
	
}
