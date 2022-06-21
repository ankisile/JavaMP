import java.util.Scanner;

public class Lab1_8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("x1, y1 입력>>");
		int x1=scan.nextInt();
		int y1=scan.nextInt();
		System.out.print("x2, y2 입력>>");
		int x2=scan.nextInt();
		int y2=scan.nextInt();
		
		if((x1<100&&x2<100)||(x1>200&&x2>200)||(y1>200&&y2>200)||(y1<100&&y2<100))
			System.out.println("충돌 없음");
		else System.out.println("충돌 발생");
		/*x1과 x2가 100미만일때 또는 200초과할때 y값에 상관없이 무조건 충돌이 없다. 
		 * y1과 y2가 100미만일때 또는 200초과할때 또한 x값에 상관없이 충돌이 무조건 없다.
		 * 이 경우들을 제외하면 충돌이 발생하기 때문에 if와 else문을 이용하여 충돌없음과 충돌발생을 띄워준다.
		 * (선이 접하는 경우도 충돌한다고 생각하여 이 경우도 충돌 발생에 포함하였다.)
		*/
		scan.close();
	}

}
