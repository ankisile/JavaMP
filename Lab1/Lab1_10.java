import java.util.Scanner;

public class Lab1_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���� �߽� x1, y1, ������ radius1 >> ");
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		double r1 = scan.nextDouble();
		System.out.print("���� �߽� x2, y2, ������ radius2 >> ");
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		double r2 = scan.nextDouble();
		//�Ÿ� ���ϴ� ���İ� �������� ���� ���ؾߵǱ� ������ ������(r1, r2)�� ������ double Ÿ������ �����Ѵ�.
		
		double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1), 2));
		//�Ÿ� ���ϴ� ����
		
		if(r1+r2>=distance) //�������� ���� ���� ������ �Ÿ����� ũ�ų� ������ ��ģ��
			System.out.println("�� ���� ���� ��ģ��.");
		else //�������� ���� ���� ������ �Ÿ����� ������ ��ġ�� �ʴ´�.
			System.out.println("�� ���� ���� ��ġ�� �ʴ´�.");

		scan.close();
	}

}
