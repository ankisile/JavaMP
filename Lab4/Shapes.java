
public class Shapes {

	public static void main(String[] args) {
		Shape [] list = new Shape[3]; //��ü�� ���۷��� �迭
		
		list[0] = new Circle(10); //�������� 10�� �� ��ü
		list[1] = new Oval(20, 30); //20x30 �簢���� �����ϴ� Ÿ��
		list[2] = new Rect(10, 40); //10x40 ũ���� �簢��
		
		for(int i=0;i<list.length;i++) {
			list[i].redraw(); //redraw �޼ҵ� ȣ��
		}
		for(int i=0;i<list.length;i++) {
			System.out.println("������ "+list[i].getArea()); //getArea�޼ҵ� ȣ��
		}
	}

}