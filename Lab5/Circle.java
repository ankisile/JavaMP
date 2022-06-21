
public class Circle {
	private int x, y, radius; //��� ���� ����
	public Circle(int x, int y, int radius) { //�Ű����� ���� �޾ƿ� ��� ������ �ʱ�ȭ �ϴ� ������ ����
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	public String toString() { //Object Ŭ������ toString() �޼ҵ� ������
		return "Circle("+x+","+y+")������"+radius;
	}

	
	public boolean equals(Object obj) { //Object Ŭ������ equals() �޼ҵ� ������
		Circle p = (Circle)obj; //��ü obj�� ���� Ŭ������ �������� ���ϱ� ������ ��ü obj�� Circle Ÿ������ �ٿ� ĳ���� �ؾߵ�
		if (x==p.x&& y==p.y) //�߽��� ������ true�� ����
			return true;
		else return false; //�߽��� �ٸ��� false�� ����
	}
	
	
}
