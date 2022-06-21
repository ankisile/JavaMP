import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//스캐너 객체 생성
		Human h[] = new Human[3]; //크기 3인 Human 객체 배열 생성
		Student s [] = new Student[3]; //크기 3인 Student 객체 배열 생성
		for(int i=0;i<h.length;i++) { //h의 크기동안 다음을 반복
			System.out.print("["+(i+1)+"] Human 입력:");
			String name = scan.next(); //이름 입력받아 변수에 저장
			int age = scan.nextInt(); //나이 입력받아 변수에 저장
			h[i] = new Human(name, age); //Human 객체 생성
		}
		for(int i=0;i<s.length;i++) { //s의 크기동안 다음을 반복
			System.out.print("["+(i+1)+"] Student 입력:");
			String name = scan.next(); //이름을 입력받아 변수에 저장
			int age = scan.nextInt(); //나이를 입력받아 변수에 저장
			String major = scan.next(); //전공을 입력받아 변수에 저장
			int sID = scan.nextInt(); //학번을 입력받아 변수에 저장
			s[i] = new Student(name, age, major, sID); //Student 객체 생성
		}
		for(int i=0;i<h.length;i++) { //객체참조변수 이름으로 출력문 작성
			System.out.println(h[i]);
		}
		for(int i=0;i<s.length;i++) { //객체참조변수 이름으로 출력문 작성
			System.out.println(s[i]);
		}
		scan.close();
	}

}
