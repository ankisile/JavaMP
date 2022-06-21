import java.util.Scanner;

class Circle{
	private double x,y;
	private int radius;
	public Circle(double x, double y, int radius) { //x,y,radius �ʱ�ȭ
		this.x=x;
		this.y=y;
		this.radius = radius;
	}
	public void show() {
		System.out.println("("+x+","+y+")"+radius); //ȭ�鿡 ���
	}
	public double getArea() { //PI ���� Math Ŭ������ PI ��� Ȱ��. Math.PI
		return radius*radius*Math.PI; //���� ����Ͽ� ��ȯ
	}
}
public class CircleManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü ����
		Circle c [] = new Circle [3]; //3���� Circle�迭 ����
		for(int i=0;i<c.length;i++) { //�迭�� ũ�⸸ŭ ������ �ݺ�
			System.out.print("x, y, radius >>");
			double x = scanner.nextDouble(); //x�� �б�
			double y = scanner.nextDouble(); //y�� �б�
			int radius = scanner.nextInt(); //������ �б�
			c[i] = new Circle(x,y,radius); //Circle ��ü ����
		}
		for(int i=0;i<c.length;i++) 
			c[i].show(); //��� Circle ��ü ��� (�ش� �޼ҵ� ���)
		int biggestIndex = 0; //���� ū ������ ���� ��ü�� index�� �����ϴ� ����
		for(int i=1;i<c.length;i++) {
			if(c[biggestIndex].getArea()<c[i].getArea()) //�����Լ��� ���� ��
				biggestIndex = i; //���� ū ������ ���� index ����
		}
		System.out.print("���� ������ ū ���� ");
		c[biggestIndex].show(); //���� ū ������ ���� index�� �ش��ϴ� ��ü ���
		scanner.close();

	}

}
