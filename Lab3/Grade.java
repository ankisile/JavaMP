import java.util.Scanner;

public class Grade {
	private int math, science, english; //������� ����
	
	public Grade(int math, int science, int english) { // ������ �ۼ�(����, ����, ���� ������ ���� �Ű����� 3���� �޾Ƽ� ��� ������ ����) 
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	public int average() { //�� ������ ����� �����ϴ� average() �޼ҵ� �ۼ�
		return (math+science+english)/3;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("����, ����, ���� ������ 3���� ���� �Է�>>");
		int math = scanner.nextInt(); //���� ���� �Է¹޾� ����
		int science = scanner.nextInt(); //���� ���� �Է¹޾� ����
		int english = scanner.nextInt(); //���� ���� �Է¹޾� ����
		Grade me = new Grade(math,science, english); //Grade ��ü ����
		System.out.println("����� "+me.average());//average()�� ����� ����Ͽ� ����
		scanner.close();
	}

}
