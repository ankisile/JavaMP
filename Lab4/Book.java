
public class Book extends Item{ //Item 클래스 상속받는 클래스
	private String writer; //멤버변수 선언
	public Book(String name, int price, String writer) { //이름, 가격, 저자를 매개변수로 받아서 설정
		setName(name); //setName함수를 호출하여 이름 설정
		setPrice(price); //setPrice 함수를 호출하여 가격 설정
		this.writer= writer; //매개변수로 받아온 writer를 멤버변수에 저장
	}
	
	public String toString() { //재정의
		return "[Book]"+getName()+", 저자:"+ writer;
	}
	
}
