
public class Movie extends Item{ //Item Ŭ������ ��ӹ޴� Ŭ����
	public String director; //������� ����
	public Movie(String name, int price, String director) { //�̸�, ����, ������ �Ű������� �޾� ����
		setName(name); //setName�Լ� ȣ��� name����
		setPrice(price); //setPrice�Լ� ȣ��� price ����
		this.director = director; //�Ű������� �޾ƿ� director�� ��������� ����
	}
	
	public String toString() { //������
		return "[Movie]"+getName()+", ����:"+director;
	}
	
}
