
public class Magazine extends Book1{ //Book1 Ŭ���� ���
	private String date; //��� ���� ����
	
	public Magazine(String title, int page, String writer, String date) { //�Ű����� �޾ƿ� �� ������ ���� �ʱ�ȭ �ϴ� ������ ����
		super(title, page, writer); //Book1 Ŭ������ Book1(title, page, writer) ȣ��(�θ�Ŭ������ ������ ȣ��)
		this.date = date;
	}
	public String getDate() { //date�� ��ȯ�ϴ� ������ �޼ҵ�
		return date;
	}

	public void setDate(String date) { //date�� �����ϴ� ������ �޼ҵ�
		this.date = date;
	}
}
