import java.util.Scanner;

public class ScoreArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		
		String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"}; //course 배열 생성
		int score[] = {95, 88, 76, 62, 55}; //score 배열 생성
		
		while(true) {
			System.out.print("과목 이름>>");
			String name = scan.next(); //사용자가 입력한 값을 저장
			if(name.equals("그만")) break; //name이 "그만"이면 break를 통해 while문 빠져나오기
			int i; //i라는 변수 선언
			for(i=0;i<course.length;i++) { //i가 0부터 (course배열의 크기-1)까지 반복하면서
				if(course[i].equals(name)) { //name값이 course[i]와 같으면
					System.out.println(name+"의 점수는 "+score[i]); //출력하고 break를 통해 for문 빠져나오기
					break;
				}
			}
			if(i==course.length) //i가 course.length와 같으면 이것은 course 배열안에 name과 같은 값이 없다는 뜻으로 "없는 과목입니다"를 출력
				System.out.println("없는 과목입니다.");
			
		}
		
		scan.close();
	}

}
