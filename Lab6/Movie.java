
public class Movie {
	private String title;
	private String director;
	private String genre;
	private int year;
	
	public Movie(String title, String director, String genre, int year) { //�Ű������� ���� �޾ƿͼ� ������� �� �ʱ�ȭ�ϴ� ������ ����
		this.title= title;
		this.director = director;
		this.genre = genre;
		this.year= year;
	}
	
	public String getTitle() { //title�� getter �޼ҵ�
		return title;
	}

	public void setTitle(String title) { //title�� setter �޼ҵ�
		this.title = title;
	}

	public String getDirector() { //director�� getter �޼ҵ�
		return director;
	}

	public void setDirector(String director) { //director�� setter �޼ҵ�
		this.director = director;
	}

	public String getGenre() { //genre�� getter �޼ҵ�
		return genre;
	}

	public void setGenre(String genre) { //genre�� setter �޼ҵ�
		this.genre = genre;
	}

	public int getYear() { //year�� getter �޼ҵ�
		return year;
	}

	public void setYear(int year) { //year�� setter �޼ҵ�
		this.year = year;
	}

	public String toString() { //toString()�޼ҵ� ������
		return "[����:" + title + ", ����:" + director + ", �帣:" + genre + ", �����⵵:" + year + "]";
	}
	
}
