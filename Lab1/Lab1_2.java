import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);// Scanner ��ü ����
		System.out.print("2�ڸ��� ���� �Է�(10~99)>>");
		int num = scan.nextInt(); //���ڸ� �Է¹޾� ���� 
		int ten = num/10; //10���ڸ��� ����
		int one = num%10; //1�� �ڸ��� ����
		if(ten==one) { //10�� �ڸ��� 1�� �ڸ� ������
			System.out.println("Yes! 10�� �ڸ��� 1�� �ڸ��� �����ϴ�");
		}
		else { //10�� �ڸ��� 1�� �ڸ� �ٸ���
			System.out.println("No! 10�� �ڸ��� 1�� �ڸ��� �ٸ��ϴ�");
		}
		scan.close();
	}

}
