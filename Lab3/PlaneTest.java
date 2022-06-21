class Plane{
	private String model; //멤버 변수 선언
	private int seat; //멤버 변수 선언
	private static int planes=0; //static 변수 선언
	
	public Plane() { //매개변수가 없는 생성자
		this.model="에어버스 - A380";
		this.seat=500; //정해진 값으로 초기화 됨
		planes++; //객체 생성은 즉 비행기가 하나 생성되었다는 뜻으로 planes값 1증가
	}
	public Plane(String model, int seat) { //매개변수를 받아오는 생성자. 매개변수를 받아 멤버 변수 초기화
		this.model = model;
		this.seat = seat;
		planes++; //객체 생성은 즉 비행기가 하나 생성되었다는 뜻으로 planes값 1증가
	}
	
	public String getModel() { //비행기의 이름을 반환하는 접근자 메소드
		return model;
	}
	public void setModel(String model) { //비행기의 이름을 매개변수로 바꾸는 설정자 메소드
		this.model = model;
	}
	public int getSeat() { //최대 승객수를 반환하는 접근자 메소드
		return seat;
	}
	public void setSeat(int seat) { //최대 승객수를 매개변수의 값으로 바꾸는 설정자 메소드
		this.seat = seat;
	}
	public static int getPlanes() { //정적변수에 접근할수 있는 접근자 메소드
		return planes; //planes 반환
	}
	public String toString() { //객체의 정보를 문자열로 반환하는 toString 메소드
		return "Plane [model="+model+", seats="+seat+"]";
	}
	
}
public class PlaneTest {

	public static void main(String[] args) {
		Plane plane1 = new Plane("보잉 484", 200);
		Plane plane2 = new Plane();
		Plane plane3 = new Plane("보잉 737", 300); //Plane 객체 여러개 생성
		
		plane1.setModel("보잉 777"); //setModel 설정자 메소드를 호출하여 plane1의 model 바꿈
		plane3.setSeat(120); //setSeat 설정자 메소드를 호출하여 plane3의 seat 바꿈
		
		System.out.println("전체 보유 비행기 수 = "+Plane.getPlanes()); //전체 보유 비행기 수 출력
		System.out.println("각 비행기 정보 출력");
		System.out.println(plane1.toString()); 
		System.out.println(plane2.toString()); 
		System.out.println(plane3.toString());  //비행기 정보 출력

	}

}
