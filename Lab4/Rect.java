
public class Rect implements Shape{ //Shape�� ��� �߻�޼ҵ� ����
	private int width, height; //������� ����
	public Rect(int width, int height) { //�Ű������� ������� �� �ʱ�ȭ �ϴ� ������ ����
		this.width = width;
		this.height = height;
	}
	public void draw() { //�߻�޼ҵ� ����
		System.out.println("�ʺ�: "+width+", ����:"+height+"�� �簢���Դϴ�.");
	}
	public double getArea(){ //�߻�޼ҵ� ����
		return width*height;
	}
}
