import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//��ĳ�� ��ü ����
		Human h[] = new Human[3]; //ũ�� 3�� Human ��ü �迭 ����
		Student s [] = new Student[3]; //ũ�� 3�� Student ��ü �迭 ����
		for(int i=0;i<h.length;i++) { //h�� ũ�⵿�� ������ �ݺ�
			System.out.print("["+(i+1)+"] Human �Է�:");
			String name = scan.next(); //�̸� �Է¹޾� ������ ����
			int age = scan.nextInt(); //���� �Է¹޾� ������ ����
			h[i] = new Human(name, age); //Human ��ü ����
		}
		for(int i=0;i<s.length;i++) { //s�� ũ�⵿�� ������ �ݺ�
			System.out.print("["+(i+1)+"] Student �Է�:");
			String name = scan.next(); //�̸��� �Է¹޾� ������ ����
			int age = scan.nextInt(); //���̸� �Է¹޾� ������ ����
			String major = scan.next(); //������ �Է¹޾� ������ ����
			int sID = scan.nextInt(); //�й��� �Է¹޾� ������ ����
			s[i] = new Student(name, age, major, sID); //Student ��ü ����
		}
		for(int i=0;i<h.length;i++) { //��ü�������� �̸����� ��¹� �ۼ�
			System.out.println(h[i]);
		}
		for(int i=0;i<s.length;i++) { //��ü�������� �̸����� ��¹� �ۼ�
			System.out.println(s[i]);
		}
		scan.close();
	}

}
