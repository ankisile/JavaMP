
public class Circle {
	private int x, y, radius; //멤버 변수 선언
	public Circle(int x, int y, int radius) { //매개변수 값을 받아와 멤버 변수를 초기화 하는 생성자 선언
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	public String toString() { //Object 클래스의 toString() 메소드 재정의
		return "Circle("+x+","+y+")반지름"+radius;
	}

	
	public boolean equals(Object obj) { //Object 클래스의 equals() 메소드 재정의
		Circle p = (Circle)obj; //객체 obj는 하위 클래스에 접근하지 못하기 때문에 객체 obj를 Circle 타입으로 다운 캐스팅 해야됨
		if (x==p.x&& y==p.y) //중심이 같으면 true를 리턴
			return true;
		else return false; //중심이 다르면 false를 리턴
	}
	
	
}
