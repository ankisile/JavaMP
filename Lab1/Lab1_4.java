import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 3개 입력>>");
		
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		
		int mid;
		
		if(a<b) {
			if(b<c) //a<b<c인경우
				mid = b;
			else {
				if(a<c) //a<c<=b인경우
					mid = c;
				else mid=a; //c<=a<b인 경우
			}
		}
		else{
			if(a<c) //b<=a<c인경우
				mid = a;
			else {
				if(b<c) //b<c<=a인 경우
					mid = c;
				else mid=b; //c<=b<=a인 경우
			}
		}
		System.out.println("중간 값은 "+mid);
		
		scan.close();
	}
}
