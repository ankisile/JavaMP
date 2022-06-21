
public class Item { 
	private int price; //멤버 변수 선언
	private String name;
	
	public int getPrice() { //price에 접근할수 있는 접근자 메소드
		return price;
	}
	public void setPrice(int price) { //price를 설정할 수 있는 설정자 메소드
		this.price = price;
	}
	public String getName() { //name에 접근할수 있는 접근자 메소드
		return name;
	}
	public void setName(String name) { //name을 설정할 수 있는 설정자 메소드
		this.name = name;
	}
	
	
}
