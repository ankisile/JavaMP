
public class CircleApp {
	public static void main(String[] args) {
		Circle a = new Circle(2,3,5); // �߽� (2,3)�� ������ 5�� ��
		Circle b = new Circle(2,3,30); // �߽� (2,3)�� ������ 30�� ��
		System.out.println("�� a : " + a);
		System.out.println("�� b : " + b);
		if(a.equals(b)) //�߽��� ������ equals �޼ҵ尡 true�� �����ϹǷ� "���� ��"���
			System.out.println("���� ��");
		else //�߽��� �ٸ���� false�� �����ϹǷ� "���� �ٸ� ��" ���
			System.out.println("���� �ٸ� ��");
	}

}
