import java.util.Scanner;
//Person Ŭ������ ���� ������Ʈ�� �ֱ� ������ ������ �ʿ� x
public class GamblingGame2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("�׺� ���ӿ� ������ ���� ����>>");
		int n =scan.nextInt(); //������ ���� ���� �Է¹ް� ����
		Person p[] = new Person [n]; //��ü �迭 ����
		for(int i=0;i<n;i++) { //n�� ��ŭ ���� �ݺ�
			System.out.print(i+1+"��° ���� �̸�>>");
			String name= scan.next(); //�̸� �Է¹޾� ����
			p[i]= new Person(name); //��ü ����
		}
		scan.nextLine(); //�Է��� �ް��� ���͸� �������� ���Ͱ��� �Է� ��Ʈ�� ���ۿ� �����ֱ� ������ ���鵵 �Է¹޴� nextLine()�� �̿��Ͽ� �����ִ� ���Ͱ� �о����
		
		int i=0; //i��� ���� 0���� �ʱ�ȭ
		while(true) {
			System.out.print("["+p[i].getName()+"]:<Enter>"); //��ü�� getName()�޼ҵ� ȣ���Ͽ� �̸� ���
			scan.nextLine(); //���Ͱ� �о����
			boolean result= p[i].game(); //��ü�� game()�޼ҵ� ȣ��. game()�޼ҵ��� ����Ÿ���� boolean�̹Ƿ� boolean Ÿ�� ������ ����
			if(result) break;  //game()�޼ҵ��� ���ϰ��� true�� ��� break�� ���� ���� ����������
			else { //true�� �ƴ� ���
				if(i==p.length-1) i=0; //i���� p.length-1�� ������ i�� 0���� (�ε����� �������̱� ������ �ٽ� ó������ ���ư��� �ϹǷ�)
				else i++; //i���� p.length���� �ٸ� ��� i�� 1 ����
			}
		}
		
		scan.close();
	}
}
