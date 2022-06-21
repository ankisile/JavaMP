
public class Customer extends Person{ //Person 클래스 상속
	private int no, mileage; //멤버변수 선언

	public Customer(int no, int mileage) { //매개변수로 값 초기화하는 생성자. 매개변수로 고객번호와 마일리지를 받아옴
		super(); //Person 클래스의 Person()생성자 호출
		this.no = no; 
		this.mileage = mileage;
	}
	public Customer(String name, String address, String tel, int no, int mileage) { //매개변수로 값 초기화하는 생성자
		super(name, address, tel); //Person클래스의 Person(name, address, tel) 호출. 
		this.no = no; 
		this.mileage =mileage;
	}
	
	public int getNo() { //고객번호를 반환하는 접근자 메소드
		return no;
	}

	public void setNo(int no) { //고객번호를 설정하는 설정자 메소드
		this.no = no;
	}

	public int getMileage() { //마일리지를 반환하는 접근자 메소드
		return mileage;
	}

	public void setMileage(int mileage) { //마일리지를 설정하는 설정자 메소드
		this.mileage = mileage;
	}
	
}
