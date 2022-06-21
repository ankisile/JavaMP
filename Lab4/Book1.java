
public class Book1 {
	private String title;
	private int page;
	private String writer; //멤버변수 선언
	static int count = 0; //static 변수 선언
	
	public Book1(String title, int page, String writer) { //매개변수 받아와 그 값으로 변수 초기화 하는 생성자 선언
		this.title = title;
		this.page = page;
		this.writer = writer;
		count++; //객체 생성 될때마다 count(책의 수)가 증가
	}
	public String getTitle() { //title(제목)을 반환하는 접근자 메소드 
		return title;
	}
	public void setTitle(String title) { //title을 설정하는 설정자 메소드
		this.title = title;
	}
	public int getPage() { //page(페이지수)를 반환하는 접근자 메소드
		return page;
	}
	public void setPage(int page) { //page를 설정하는 설정자 메소드
		this.page = page;
	}
	public String getWriter() { //writer(저자)를 반환하는 접근자 메소드
		return writer;
	}
	public void setWriter(String writer) { //writer를 설정하는 설정자 메소드 
		this.writer = writer;
	}
	public static int getCount() { //count(책의 수)를 반환하는 static 메소드. 이것은 접근자 메소드
		return count;
	}
	
}
