
public class Food extends Item{ //Item 클래스를 상속받음
	public Food(String name, int price) { //이름과 가격을 매개변수로 받아서 설정
		setName(name); //setName함수 호출을 통해 이름 설정
		setPrice(price); //setPrice함수 호출을 통해 가격 설정
	}
	public String toString() { //toString()메소드 재정의
		return "[Food]"+getName();
	}
}
