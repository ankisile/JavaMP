import java.util.Scanner;

public class Lab1_6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Scanner ��ü ����
		System.out.print("1~99 ������ ������ �Է��Ͻÿ�>>");
		int num = scan.nextInt();//���� �Է� ����
		
		int ten = num/10; //10�� �ڸ��� ����
		int one = num%10; //1�� �ڸ��� ����
		
		if(ten>0) { //���ڸ��� ������ ���
			if((ten==3||ten==6||ten==9)&&(one==3||one==6||one==9))
				System.out.println("�ڼ�¦¦");
			else if((ten==3||ten==6||ten==9)||(one==3||one==6||one==9))
				System.out.println("�ڼ�¦");
			else
				System.out.println("�ڼ�����"); //�Ѵ� 3�� ����� �ƴҶ�
		}
		else { //���ڸ��� ������ ���
			if(one==3||one==6||one==9) //���� �ڸ����� 3�� ����� ��. 
				System.out.println("�ڼ�¦");
			else System.out.println("�ڼ�����"); //���� �ڸ��� 3�� ����� �ƴҶ�
		}

		scan.close();
	}
}
