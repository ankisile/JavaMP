import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 생성
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //환산할돈의 종류
		System.out.print("금액을 입력하시오>>"); //사용자로부터 입력을 받기 위한 출력문
		int money = scan.nextInt(); //입력받은 값 저장
		for(int i=0;i<unit.length;i++) { //배열의 크기만큼 반복하면서
			if(money/unit[i]!=0) { //money/unit[i]값이 0이 아니면
				System.out.println(unit[i]+"원 짜리 : "+money/unit[i]+"개"); //출력
				money=money%unit[i]; //money에 나머지를 저장하기 위해서 money%unit[i]문을 이용하여 나머지를 저장한다.
			}
		}
		
		scan.close();

	}

}
