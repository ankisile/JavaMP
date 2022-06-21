
public class Oval implements Shape{ //Shape의 모든 추상메소드 구현
	private int width, height; //멤버변수 선언
	public Oval(int width, int height) { //매개변수로 값 초기화 하는 생성자 생성
		this.width = width;
		this.height = height;
	}
	public void draw() { //추상 메소드 구현
		System.out.println("너비: "+width+", 높이:"+height+"에 내접하는 타원입니다.");
	}
	public double getArea(){ //추상 메소드 구현
		return (width/2)*(height/2)*PI; 
	}
}
