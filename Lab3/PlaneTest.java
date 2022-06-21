class Plane{
	private String model; //��� ���� ����
	private int seat; //��� ���� ����
	private static int planes=0; //static ���� ����
	
	public Plane() { //�Ű������� ���� ������
		this.model="������� - A380";
		this.seat=500; //������ ������ �ʱ�ȭ ��
		planes++; //��ü ������ �� ����Ⱑ �ϳ� �����Ǿ��ٴ� ������ planes�� 1����
	}
	public Plane(String model, int seat) { //�Ű������� �޾ƿ��� ������. �Ű������� �޾� ��� ���� �ʱ�ȭ
		this.model = model;
		this.seat = seat;
		planes++; //��ü ������ �� ����Ⱑ �ϳ� �����Ǿ��ٴ� ������ planes�� 1����
	}
	
	public String getModel() { //������� �̸��� ��ȯ�ϴ� ������ �޼ҵ�
		return model;
	}
	public void setModel(String model) { //������� �̸��� �Ű������� �ٲٴ� ������ �޼ҵ�
		this.model = model;
	}
	public int getSeat() { //�ִ� �°����� ��ȯ�ϴ� ������ �޼ҵ�
		return seat;
	}
	public void setSeat(int seat) { //�ִ� �°����� �Ű������� ������ �ٲٴ� ������ �޼ҵ�
		this.seat = seat;
	}
	public static int getPlanes() { //���������� �����Ҽ� �ִ� ������ �޼ҵ�
		return planes; //planes ��ȯ
	}
	public String toString() { //��ü�� ������ ���ڿ��� ��ȯ�ϴ� toString �޼ҵ�
		return "Plane [model="+model+", seats="+seat+"]";
	}
	
}
public class PlaneTest {

	public static void main(String[] args) {
		Plane plane1 = new Plane("���� 484", 200);
		Plane plane2 = new Plane();
		Plane plane3 = new Plane("���� 737", 300); //Plane ��ü ������ ����
		
		plane1.setModel("���� 777"); //setModel ������ �޼ҵ带 ȣ���Ͽ� plane1�� model �ٲ�
		plane3.setSeat(120); //setSeat ������ �޼ҵ带 ȣ���Ͽ� plane3�� seat �ٲ�
		
		System.out.println("��ü ���� ����� �� = "+Plane.getPlanes()); //��ü ���� ����� �� ���
		System.out.println("�� ����� ���� ���");
		System.out.println(plane1.toString()); 
		System.out.println(plane2.toString()); 
		System.out.println(plane3.toString());  //����� ���� ���

	}

}
