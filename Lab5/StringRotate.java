import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.println("���ڿ��� �Է��ϼ���. �� ĭ�̳� �־ �ǰ� ���� �ѱ� ��� �˴ϴ�.");
		String str = scan.nextLine(); //������ �Է��� �޾ƾ� �Ǳ� ������ nextLine()�޼ҵ� �̿�
		for(int i=1;i<=str.length();i++) { 
			//1�� �ε��� ���� substring�� ������ �ǹǷ� i�� 1���� ����. �׸��� �Ǹ������� ���� ���ڿ��� ��µǾ�� �ϹǷ� i�� str.length()���� ����
			System.out.print(str.substring(i)); //substring(i)�� i �ε������� �����ϴ� ���� ��Ʈ�� ���� �� ���. i==str.length()�϶��� ���ϵǴ� ���꽺Ʈ�� ����
			System.out.println(str.substring(0,i)); //substring(0,i)�� 0~i-1 �ε��� ������ ���꽺Ʈ�� ���� �� ���. i==str.length()�϶��� ���ϵǴ� ���꽺Ʈ���� ���� ���ڿ�	
		}
		scan.close();
		
	}

}
