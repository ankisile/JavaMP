import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� 3�� �Է�>>");
		
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		
		int mid;
		
		if(a<b) {
			if(b<c) //a<b<c�ΰ��
				mid = b;
			else {
				if(a<c) //a<c<=b�ΰ��
					mid = c;
				else mid=a; //c<=a<b�� ���
			}
		}
		else{
			if(a<c) //b<=a<c�ΰ��
				mid = a;
			else {
				if(b<c) //b<c<=a�� ���
					mid = c;
				else mid=b; //c<=b<=a�� ���
			}
		}
		System.out.println("�߰� ���� "+mid);
		
		scan.close();
	}
}
