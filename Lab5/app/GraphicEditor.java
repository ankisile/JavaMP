package app; //클래스가 소속될 app 패키지
import base.Shape; //base 패키지의 Shape 클래스를 이용하기위해 import문 사용
import derived.Circle2; //derived 패키지의 Circle2 클래스를 이용하기위해 import문 사용

public class GraphicEditor { //GraphicEditor 클래스는 app패키지에 속함

	public static void main(String[] args) {
		Shape shape = new Circle2(); //객체 생성
		shape.draw(); //메소드 호출
	}

}
