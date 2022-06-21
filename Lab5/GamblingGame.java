import java.util.Scanner;

class Person{
	private String name; //멤버 변수 선언
	public Person(String name) { //매개 변수 값으로 멤버 변수 초기화 하는 생성자 선언
		this.name = name;
	}
	
	public String getName() { //name 값을 리턴하는 접근자 메소드
		return name;
	}

	public boolean game() {
		int n1=(int)(Math.random()*3+1); //1~3까지의 랜덤값 생성후 저장
		int n2=(int)(Math.random()*3+1);
		int n3=(int)(Math.random()*3+1);
		System.out.print("\t\t"+n1+"\t"+n2+"\t"+n3+"\t"); //3개의 랜덤값 출력
		if(n1==n2&&n2==n3) { //랜덤값이 3개 다 같으면 문구 출력 후 true를 리턴
			System.out.println(name+"님이 이겼습니다!");
			return true;
		}
		else { //랜덤값이 하나라도 다른 경우 문구 출력 후 false 리턴
			System.out.println("아쉽군요!");
			return false;
		}
	}
}

public class GamblingGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("1번째 선수 이름>>");
		String name= scan.next(); //이름 입력받아 저장
		Person p1= new Person(name); //객체 생성
		System.out.print("2번째 선수 이름>>");
		name=scan.next(); //이름 입력받아 저장
		Person p2 = new Person(name); //객체 생성
		scan.nextLine(); //입력을 받고나서 엔터를 눌렀을때 엔터값이 입력 스트림 버퍼에 남아있기 때문에 공백도 입력받는 nextLine()을 이용하여 남아있는 엔터값 읽어들임
		
		while(true) { //무한루프
			System.out.print("["+p1.getName()+"]:<Enter>"); //객체의 getName()메소드 호출하여 이름 출력
			scan.nextLine(); //엔터값 읽어들임
			boolean result= p1.game(); //객체의 game()메소드 호출. game()메소드의 리턴타입이 boolean이므로 boolean 타입 변수에 저장
			if(result) break; //game()메소드의 리턴값이 true인 경우 break를 통해 루프 빠져나오기
			System.out.print("["+p2.getName()+"]:<Enter>"); //객체의 getName()메소드 호출하여 이름 출력
			scan.nextLine(); //엔터값 읽어들임
			result= p2.game(); //객체의 game()메소드 호출. game()메소드의 리턴타입이 boolean이므로 boolean 타입 변수에 저장
			if(result) break; //game()메소드의 리턴값이 true인 경우 break를 통해 루프 빠져나오기
		}
		
		scan.close();
	}

}
