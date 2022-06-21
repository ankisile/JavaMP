
public class Book1 {
	private String title;
	private int page;
	private String writer; //������� ����
	static int count = 0; //static ���� ����
	
	public Book1(String title, int page, String writer) { //�Ű����� �޾ƿ� �� ������ ���� �ʱ�ȭ �ϴ� ������ ����
		this.title = title;
		this.page = page;
		this.writer = writer;
		count++; //��ü ���� �ɶ����� count(å�� ��)�� ����
	}
	public String getTitle() { //title(����)�� ��ȯ�ϴ� ������ �޼ҵ� 
		return title;
	}
	public void setTitle(String title) { //title�� �����ϴ� ������ �޼ҵ�
		this.title = title;
	}
	public int getPage() { //page(��������)�� ��ȯ�ϴ� ������ �޼ҵ�
		return page;
	}
	public void setPage(int page) { //page�� �����ϴ� ������ �޼ҵ�
		this.page = page;
	}
	public String getWriter() { //writer(����)�� ��ȯ�ϴ� ������ �޼ҵ�
		return writer;
	}
	public void setWriter(String writer) { //writer�� �����ϴ� ������ �޼ҵ� 
		this.writer = writer;
	}
	public static int getCount() { //count(å�� ��)�� ��ȯ�ϴ� static �޼ҵ�. �̰��� ������ �޼ҵ�
		return count;
	}
	
}
