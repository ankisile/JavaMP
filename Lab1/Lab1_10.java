import java.util.Scanner;

public class Lab1_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("원의 중심 x1, y1, 반지름 radius1 >> ");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		double r1 = scan.nextDouble();
		System.out.print("원의 중심 x2, y2, 반지름 radius2 >> ");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		double r2 = scan.nextDouble();
		//거리 구하는 공식과 반지름의 합을 비교해야되기 때문에 반지름(r1, r2)은 변수를 double 타입으로 선언한다.
		
		double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1), 2));
		//거리 구하는 공식
		
		if(r1+r2>=distance) //반지름의 합이 두점 사이의 거리보다 크거나 같으면 겹친다
			System.out.println("두 원은 서로 겹친다.");
		else //반지름의 합이 두점 사이의 거리보다 작으면 겹치지 않는다.
			System.out.println("두 원은 서로 겹치지 않는다.");

		scan.close();
	}

}
