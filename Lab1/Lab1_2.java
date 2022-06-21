import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);// Scanner 객체 생성
		System.out.print("2자리수 정수 입력(10~99)>>");
		int num = scan.nextInt(); //숫자를 입력받아 저장 
		int ten = num/10; //10의자리수 저장
		int one = num%10; //1의 자리수 저장
		if(ten==one) { //10의 자리와 1의 자리 같을때
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다");
		}
		else { //10의 자리와 1의 자리 다를때
			System.out.println("No! 10의 자리와 1의 자리가 다릅니다");
		}
		scan.close();
	}

}
