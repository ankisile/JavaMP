
public class Food extends Item{ //Item Ŭ������ ��ӹ���
	public Food(String name, int price) { //�̸��� ������ �Ű������� �޾Ƽ� ����
		setName(name); //setName�Լ� ȣ���� ���� �̸� ����
		setPrice(price); //setPrice�Լ� ȣ���� ���� ���� ����
	}
	public String toString() { //toString()�޼ҵ� ������
		return "[Food]"+getName();
	}
}
