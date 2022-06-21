import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.println("문자열을 입력하세요. 빈 칸이나 있어도 되고 영어 한글 모두 됩니다.");
		String str = scan.nextLine(); //문장을 입력을 받아야 되기 때문에 nextLine()메소드 이용
		for(int i=1;i<=str.length();i++) { 
			//1번 인덱스 부터 substring이 진행이 되므로 i는 1부터 시작. 그리고 맨마지막에 원래 문자열이 출력되어야 하므로 i는 str.length()까지 포함
			System.out.print(str.substring(i)); //substring(i)는 i 인덱스부터 시작하는 서브 스트링 리턴 후 출력. i==str.length()일때는 리턴되는 서브스트링 없음
			System.out.println(str.substring(0,i)); //substring(0,i)는 0~i-1 인덱스 까지의 서브스트링 리턴 후 출력. i==str.length()일때는 리턴되는 서브스트링이 원래 문자열	
		}
		scan.close();
		
	}

}
