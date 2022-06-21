
public class Student extends Human{ //Human 클래스 상속
	private String major; //멤버변수 선언
	private int sID;
	
	public Student(String name, int age, String major, int sID) {//매개변수로 이름, 나이, 전공, 학번을 받아와서 초기화
		super(name, age); //부모 클래스의 생성자 호출
		this.major = major; //매개변수로 받아온 값으로 멤버 변수의 전공과 학번을 초기화
		this.sID = sID;
		
	}

	public String getMajor() { //전공에 대한 접근자 메소드. major를 반환
		return major;
	}

	public void setMajor(String major) { //전공에 대한 설정자 메소드
		this.major = major;
	}

	public String toString() { //toString() 메소드 재정의. 
		return "[학생 정보]"+super.toString()+", 전공:" + major + ", 학번:" + sID+"]";
	//부모의 toString()을 호출하여 받아온 문자열 값에 추가로 전공 값을 연결하여 문자열 반환
	}
	
}
