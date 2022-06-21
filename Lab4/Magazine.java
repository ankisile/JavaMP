
public class Magazine extends Book1{ //Book1 클래스 상속
	private String date; //멤버 변수 선언
	
	public Magazine(String title, int page, String writer, String date) { //매개변수 받아와 그 값으로 변수 초기화 하는 생성자 선언
		super(title, page, writer); //Book1 클래스의 Book1(title, page, writer) 호출(부모클래스의 생성자 호출)
		this.date = date;
	}
	public String getDate() { //date를 반환하는 접근자 메소드
		return date;
	}

	public void setDate(String date) { //date를 설정하는 설정자 메소드
		this.date = date;
	}
}
