import java.util.Scanner;

class Phone{
	private String name, tel; //멤버 변수 선언
	public Phone(String name, String tel) { //생성자. 멤버변수 매개변수의 값으로 초기화
		this.name = name;
		this.tel = tel;
	}
	public String getName() { //name을 반한하는 메소드
		return name; 
	}
		
	public void show() { //정보를 화면에 출력
		System.out.println(name+"의 번호는 "+tel+" 입니다.");
	}
}
public class PhoneBook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("인원수>>");
		int n = scan.nextInt(); //인원수를 읽어 n에 저장
		Phone c [] = new Phone[n]; // n개의 Phone 배열 생성
		for(int i=0;i<n;i++) { // 다음을 n번 반복
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String name = scan.next(); //이름을 읽어서 저장
			String tel = scan.next(); //번호를 읽어서 저장
			c[i] = new Phone(name, tel); //Phone 객체 생성
		}
		System.out.println("저장되었습니다...");
		while(true) { //다음을 무한 반복
			System.out.print("검색할 이름>>");
			String search = scan.next(); //검색할 이름을 받아와서 search에 저장
			if(search.equals("그만")) break; //search가 "그만"이면 while문 빠져나옴
			int exist = 0; //search(검색하는 이름)가 객체 배열에 있는지 없는지 확인하는 변수. 있으면 1, 아니면 0
			for(int i=0;i<c.length;i++) { 
				if(search.equals(c[i].getName())){ //search와 c[i].getName()이 같으면 다음을 실행. getName()은 name을 반환 
					c[i].show();//show()를 이용하여 화면에 출력
					exist =1; //exist값을 1로 바꿈
					break; //for문 빠져나옴
				}
			}
			if(exist == 0) //exist가 0이면 이것은 search가 없다는 뜻. 없다는 문구를 화면에 출력
				System.out.println(search+" 이 없습니다.");
		}
		
		scan.close();

	}

}
