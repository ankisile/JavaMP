import java.util.Scanner;

public class PrintAlphabet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		System.out.print("소문자 알파벳 하나를 입력하시오>> "); //입력을 받기위한 출력문 생성
		String s = scan.next(); //문자열 읽기
		char c = s.charAt(0); //문자열의 첫번째 문자 저장
		
		
		for(int i=0;i<=c-'a';i++) { //i가 0부터 c-'a'까지 증가하면서 다음을 반복
			for(char chr='a';chr<=c-i;chr++) { //'a'부터 c-i까지 출력. c-i를 하는 이유는 맨 오른쪽 부터 없어지기 때문에 c-i를 통해 i값이 커질수록 출력되는 알파벳이 줄어들음.
				System.out.print(chr);
			}
			System.out.println();
		}
		
		scan.close();
	}
}
