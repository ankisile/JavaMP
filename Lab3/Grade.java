import java.util.Scanner;

public class Grade {
	private int math, science, english; //멤버변수 선언
	
	public Grade(int math, int science, int english) { // 생성자 작성(수학, 과학, 영어 점수를 위한 매개변수 3개를 받아서 멤버 변수에 저장) 
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	public int average() { //세 과목의 평균을 리턴하는 average() 메소드 작성
		return (math+science+english)/3;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math = scanner.nextInt(); //수학 성적 입력받아 저장
		int science = scanner.nextInt(); //과학 성적 입력받아 저장
		int english = scanner.nextInt(); //영어 성적 입력받아 저장
		Grade me = new Grade(math,science, english); //Grade 객체 생성
		System.out.println("평균은 "+me.average());//average()는 평균을 계산하여 리턴
		scanner.close();
	}

}
