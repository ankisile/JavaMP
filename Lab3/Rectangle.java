
public class Rectangle {
	private int x, y, width, height; //�簢���� �����ϴ� ���� ũ�� ����
	
	public Rectangle(int x, int y, int width, int height) {//x, y, width, height ���� �Ű������� �޾� �ʵ带 �ʱ�ȭ �ϴ� ������
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public int square(){//�簢���� ���� ����
		return width*height;
	}
	public void show() {//�簢���� ��ǥ�� ���̸� ȭ�鿡 ���
		System.out.println("("+x+","+y+")���� ũ�Ⱑ "+width+"x"+height+"�� �簢��");
	}
	public boolean contains(Rectangle r) { //�Ű������� ���� r�� �� �簢�� �ȿ� ������ true ���� �ƴϸ� false ����
		if((r.x>=x)&&(r.y>=y)&&((r.x+r.width)<=(x+width))&&((r.y+r.height)<=(y+height))) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10); //Rectangle ��ü ����
		
		r.show(); //show()�� ���� r�� ���� ���
		System.out.println("s�� ������ "+s.square()); //square()�� ���� s�� �簢���� ���̸� ������ ���ϵȰ� ���
		if(t.contains(r)) System.out.println("t�� r�� �����մϴ�."); //r�� t�� ���ԵǸ� ���
		if(t.contains(s)) System.out.println("t�� s�� �����մϴ�."); //s�� t�� ���ԵǸ� ���
		

	}

}
