import java.util.Scanner;

class Phone{
	private String name, tel; //��� ���� ����
	public Phone(String name, String tel) { //������. ������� �Ű������� ������ �ʱ�ȭ
		this.name = name;
		this.tel = tel;
	}
	public String getName() { //name�� �����ϴ� �޼ҵ�
		return name; 
	}
		
	public void show() { //������ ȭ�鿡 ���
		System.out.println(name+"�� ��ȣ�� "+tel+" �Դϴ�.");
	}
}
public class PhoneBook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("�ο���>>");
		int n = scan.nextInt(); //�ο����� �о� n�� ����
		Phone c [] = new Phone[n]; // n���� Phone �迭 ����
		for(int i=0;i<n;i++) { // ������ n�� �ݺ�
			System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� �� ĭ���� �Է�)>>");
			String name = scan.next(); //�̸��� �о ����
			String tel = scan.next(); //��ȣ�� �о ����
			c[i] = new Phone(name, tel); //Phone ��ü ����
		}
		System.out.println("����Ǿ����ϴ�...");
		while(true) { //������ ���� �ݺ�
			System.out.print("�˻��� �̸�>>");
			String search = scan.next(); //�˻��� �̸��� �޾ƿͼ� search�� ����
			if(search.equals("�׸�")) break; //search�� "�׸�"�̸� while�� ��������
			int exist = 0; //search(�˻��ϴ� �̸�)�� ��ü �迭�� �ִ��� ������ Ȯ���ϴ� ����. ������ 1, �ƴϸ� 0
			for(int i=0;i<c.length;i++) { 
				if(search.equals(c[i].getName())){ //search�� c[i].getName()�� ������ ������ ����. getName()�� name�� ��ȯ 
					c[i].show();//show()�� �̿��Ͽ� ȭ�鿡 ���
					exist =1; //exist���� 1�� �ٲ�
					break; //for�� ��������
				}
			}
			if(exist == 0) //exist�� 0�̸� �̰��� search�� ���ٴ� ��. ���ٴ� ������ ȭ�鿡 ���
				System.out.println(search+" �� �����ϴ�.");
		}
		
		scan.close();

	}

}
