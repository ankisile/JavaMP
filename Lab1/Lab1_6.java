import java.util.Scanner;

public class Lab1_6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Scanner 객체 생성
		System.out.print("1~99 사이의 정수를 입력하시오>>");
		int num = scan.nextInt();//정수 입력 받음
		
		int ten = num/10; //10의 자리수 저장
		int one = num%10; //1의 자리수 저장
		
		if(ten>0) { //두자리수 정수인 경우
			if((ten==3||ten==6||ten==9)&&(one==3||one==6||one==9))
				System.out.println("박수짝짝");
			else if((ten==3||ten==6||ten==9)||(one==3||one==6||one==9))
				System.out.println("박수짝");
			else
				System.out.println("박수없음"); //둘다 3의 배수가 아닐때
		}
		else { //한자리수 정수인 경우
			if(one==3||one==6||one==9) //일의 자리수가 3의 배수일 때. 
				System.out.println("박수짝");
			else System.out.println("박수없음"); //일의 자리가 3의 배수가 아닐때
		}

		scan.close();
	}
}
