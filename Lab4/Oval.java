
public class Oval implements Shape{ //Shape�� ��� �߻�޼ҵ� ����
	private int width, height; //������� ����
	public Oval(int width, int height) { //�Ű������� �� �ʱ�ȭ �ϴ� ������ ����
		this.width = width;
		this.height = height;
	}
	public void draw() { //�߻� �޼ҵ� ����
		System.out.println("�ʺ�: "+width+", ����:"+height+"�� �����ϴ� Ÿ���Դϴ�.");
	}
	public double getArea(){ //�߻� �޼ҵ� ����
		return (width/2)*(height/2)*PI; 
	}
}
