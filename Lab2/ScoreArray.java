import java.util.Scanner;

public class ScoreArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		
		String course[] = {"Java", "C++", "HTML5", "��ǻ�ͱ���", "�ȵ���̵�"}; //course �迭 ����
		int score[] = {95, 88, 76, 62, 55}; //score �迭 ����
		
		while(true) {
			System.out.print("���� �̸�>>");
			String name = scan.next(); //����ڰ� �Է��� ���� ����
			if(name.equals("�׸�")) break; //name�� "�׸�"�̸� break�� ���� while�� ����������
			int i; //i��� ���� ����
			for(i=0;i<course.length;i++) { //i�� 0���� (course�迭�� ũ��-1)���� �ݺ��ϸ鼭
				if(course[i].equals(name)) { //name���� course[i]�� ������
					System.out.println(name+"�� ������ "+score[i]); //����ϰ� break�� ���� for�� ����������
					break;
				}
			}
			if(i==course.length) //i�� course.length�� ������ �̰��� course �迭�ȿ� name�� ���� ���� ���ٴ� ������ "���� �����Դϴ�"�� ���
				System.out.println("���� �����Դϴ�.");
			
		}
		
		scan.close();
	}

}
