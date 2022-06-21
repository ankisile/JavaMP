
public class Movie {
	private String title;
	private String director;
	private String genre;
	private int year;
	
	public Movie(String title, String director, String genre, int year) { //매개변수로 값을 받아와서 멤버변수 값 초기화하는 생성자 선언
		this.title= title;
		this.director = director;
		this.genre = genre;
		this.year= year;
	}
	
	public String getTitle() { //title의 getter 메소드
		return title;
	}

	public void setTitle(String title) { //title의 setter 메소드
		this.title = title;
	}

	public String getDirector() { //director의 getter 메소드
		return director;
	}

	public void setDirector(String director) { //director의 setter 메소드
		this.director = director;
	}

	public String getGenre() { //genre의 getter 메소드
		return genre;
	}

	public void setGenre(String genre) { //genre의 setter 메소드
		this.genre = genre;
	}

	public int getYear() { //year의 getter 메소드
		return year;
	}

	public void setYear(int year) { //year의 setter 메소드
		this.year = year;
	}

	public String toString() { //toString()메소드 재정의
		return "[제목:" + title + ", 감독:" + director + ", 장르:" + genre + ", 개봉년도:" + year + "]";
	}
	
}
