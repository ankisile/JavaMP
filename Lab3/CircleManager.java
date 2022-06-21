import java.util.Scanner;

class Circle{
	private double x,y;
	private int radius;
	public Circle(double x, double y, int radius) { //x,y,radius 초기화
		this.x=x;
		this.y=y;
		this.radius = radius;
	}
	public void show() {
		System.out.println("("+x+","+y+")"+radius); //화면에 출력
	}
	public double getArea() { //PI 값은 Math 클래스의 PI 상수 활용. Math.PI
		return radius*radius*Math.PI; //면적 계산하여 반환
	}
}
public class CircleManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //스캐너 객체 생성
		Circle c [] = new Circle [3]; //3개의 Circle배열 선언
		for(int i=0;i<c.length;i++) { //배열의 크기만큼 다음을 반복
			System.out.print("x, y, radius >>");
			double x = scanner.nextDouble(); //x값 읽기
			double y = scanner.nextDouble(); //y값 읽기
			int radius = scanner.nextInt(); //반지름 읽기
			c[i] = new Circle(x,y,radius); //Circle 객체 생성
		}
		for(int i=0;i<c.length;i++) 
			c[i].show(); //모든 Circle 객체 출력 (해당 메소드 출력)
		int biggestIndex = 0; //가장 큰 면적을 가진 객체의 index를 저장하는 변수
		for(int i=1;i<c.length;i++) {
			if(c[biggestIndex].getArea()<c[i].getArea()) //면적함수를 통해 비교
				biggestIndex = i; //가장 큰 면적을 가진 index 저장
		}
		System.out.print("가장 면적이 큰 원은 ");
		c[biggestIndex].show(); //가장 큰 면적을 가진 index에 해당하는 객체 출력
		scanner.close();

	}

}
