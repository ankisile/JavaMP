
public class Circle implements Shape{ //Shape�� ��� �߻�޼ҵ� ����
	private int radius; //��� ���� ����
	public Circle(int radius){ //�Ű������� ��� ���� �� �ʱ�ȭ �ϴ� ������ ����
		this.radius= radius;
	}
	public void draw() { //�߻� �޼ҵ� ����
		System.out.println("�������� "+radius+"�� ���Դϴ�.");
	}
	public double getArea() { //�߻� �޼ҵ� ����
		return radius*radius*PI;
	}
}
