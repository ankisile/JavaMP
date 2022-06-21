package derived; //클래스가 소속될 derived 패키지
import base.Shape; //base 패키지의 Shape 클래스를 이용하기위해 import문 사용

public class Circle2 extends Shape{ //Circle2 클래스는 Shape 클래스를 상속받고 derived 패키지에 있음
	public void draw() { System.out.println("Circle"); } //draw() 메소드 재정의
}
