import java.util.Scanner;
//Person 클래스가 동일 프로젝트에 있기 때문에 생성할 필요 x
public class GamblingGame2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("겜블링 게임에 참여할 선수 숫자>>");
		int n =scan.nextInt(); //참여할 선수 숫자 입력받고 저장
		Person p[] = new Person [n]; //객체 배열 생성
		for(int i=0;i<n;i++) { //n번 만큼 다음 반복
			System.out.print(i+1+"번째 선수 이름>>");
			String name= scan.next(); //이름 입력받아 저장
			p[i]= new Person(name); //객체 생성
		}
		scan.nextLine(); //입력을 받고나서 엔터를 눌렀을때 엔터값이 입력 스트림 버퍼에 남아있기 때문에 공백도 입력받는 nextLine()을 이용하여 남아있는 엔터값 읽어들임
		
		int i=0; //i라는 변수 0으로 초기화
		while(true) {
			System.out.print("["+p[i].getName()+"]:<Enter>"); //객체의 getName()메소드 호출하여 이름 출력
			scan.nextLine(); //엔터값 읽어들임
			boolean result= p[i].game(); //객체의 game()메소드 호출. game()메소드의 리턴타입이 boolean이므로 boolean 타입 변수에 저장
			if(result) break;  //game()메소드의 리턴값이 true인 경우 break를 통해 루프 빠져나오기
			else { //true가 아닌 경우
				if(i==p.length-1) i=0; //i값이 p.length-1과 같으면 i에 0저장 (인덱스가 마지막이기 때문에 다시 처음으로 돌아가야 하므로)
				else i++; //i값이 p.length값과 다른 경우 i값 1 증가
			}
		}
		
		scan.close();
	}
}
