
public class Book extends Item{ //Item Ŭ���� ��ӹ޴� Ŭ����
	private String writer; //������� ����
	public Book(String name, int price, String writer) { //�̸�, ����, ���ڸ� �Ű������� �޾Ƽ� ����
		setName(name); //setName�Լ��� ȣ���Ͽ� �̸� ����
		setPrice(price); //setPrice �Լ��� ȣ���Ͽ� ���� ����
		this.writer= writer; //�Ű������� �޾ƿ� writer�� ��������� ����
	}
	
	public String toString() { //������
		return "[Book]"+getName()+", ����:"+ writer;
	}
	
}
