
public class Movie extends Item{ //Item 클래스를 상속받는 클래스
	public String director; //멤버변수 선언
	public Movie(String name, int price, String director) { //이름, 가격, 감독을 매개변수로 받아 설정
		setName(name); //setName함수 호출로 name설정
		setPrice(price); //setPrice함수 호출로 price 설정
		this.director = director; //매개변수로 받아온 director를 멤버변수에 저장
	}
	
	public String toString() { //재정의
		return "[Movie]"+getName()+", 감독:"+director;
	}
	
}
