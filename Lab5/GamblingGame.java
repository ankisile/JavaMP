import java.util.Scanner;

class Person{
	private String name; //��� ���� ����
	public Person(String name) { //�Ű� ���� ������ ��� ���� �ʱ�ȭ �ϴ� ������ ����
		this.name = name;
	}
	
	public String getName() { //name ���� �����ϴ� ������ �޼ҵ�
		return name;
	}

	public boolean game() {
		int n1=(int)(Math.random()*3+1); //1~3������ ������ ������ ����
		int n2=(int)(Math.random()*3+1);
		int n3=(int)(Math.random()*3+1);
		System.out.print("\t\t"+n1+"\t"+n2+"\t"+n3+"\t"); //3���� ������ ���
		if(n1==n2&&n2==n3) { //�������� 3�� �� ������ ���� ��� �� true�� ����
			System.out.println(name+"���� �̰���ϴ�!");
			return true;
		}
		else { //�������� �ϳ��� �ٸ� ��� ���� ��� �� false ����
			System.out.println("�ƽ�����!");
			return false;
		}
	}
}

public class GamblingGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("1��° ���� �̸�>>");
		String name= scan.next(); //�̸� �Է¹޾� ����
		Person p1= new Person(name); //��ü ����
		System.out.print("2��° ���� �̸�>>");
		name=scan.next(); //�̸� �Է¹޾� ����
		Person p2 = new Person(name); //��ü ����
		scan.nextLine(); //�Է��� �ް��� ���͸� �������� ���Ͱ��� �Է� ��Ʈ�� ���ۿ� �����ֱ� ������ ���鵵 �Է¹޴� nextLine()�� �̿��Ͽ� �����ִ� ���Ͱ� �о����
		
		while(true) { //���ѷ���
			System.out.print("["+p1.getName()+"]:<Enter>"); //��ü�� getName()�޼ҵ� ȣ���Ͽ� �̸� ���
			scan.nextLine(); //���Ͱ� �о����
			boolean result= p1.game(); //��ü�� game()�޼ҵ� ȣ��. game()�޼ҵ��� ����Ÿ���� boolean�̹Ƿ� boolean Ÿ�� ������ ����
			if(result) break; //game()�޼ҵ��� ���ϰ��� true�� ��� break�� ���� ���� ����������
			System.out.print("["+p2.getName()+"]:<Enter>"); //��ü�� getName()�޼ҵ� ȣ���Ͽ� �̸� ���
			scan.nextLine(); //���Ͱ� �о����
			result= p2.game(); //��ü�� game()�޼ҵ� ȣ��. game()�޼ҵ��� ����Ÿ���� boolean�̹Ƿ� boolean Ÿ�� ������ ����
			if(result) break; //game()�޼ҵ��� ���ϰ��� true�� ��� break�� ���� ���� ����������
		}
		
		scan.close();
	}

}
