
public class Circle implements Shape{ //Shape의 모든 추상메소드 구현
	private int radius; //멤버 변수 선언
	public Circle(int radius){ //매개변수로 멤버 변수 값 초기화 하는 생성자 생성
		this.radius= radius;
	}
	public void draw() { //추상 메소드 구현
		System.out.println("반지름이 "+radius+"인 원입니다.");
	}
	public double getArea() { //추상 메소드 구현
		return radius*radius*PI;
	}
}
