import java.io.Serializable;

class Item implements Serializable{ 
	private String title; //干滚函荐 积己
	private String writer;
	private int year; 
	private String img;
	private int star;
	private String plot;
	private String review;
	
	public Item(String title, String writer, int year, String img, int star, String plot, String review) { //积己磊 积己
		this.title = title;
		this.writer = writer;
		this.year = year;
		this.img = img;
		this.star = star;
		this.plot = plot;
		this.review = review;
	}
	//干滚函荐俊 措茄 set/get 皋家靛 积己
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return Integer.toString(year);
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStar() {
		return Integer.toString(star);
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}

class Movie extends Item{
	private String actor; //干滚函荐 积己
	private String genre;
	private String grade;
	
	//积己磊 积己
	public Movie(String title, String writer, String actor, String genre, String grade,int year, String img, int star, String plot, String review) {
		super(title, writer, year, img, star, plot, review);
		this.actor = actor;
		this.genre = genre;
		this.grade = grade;
	}
	//干滚函荐俊 措茄 set/get 皋家靛 积己
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}

class Book extends Item{
	private String publisher; //干滚函荐 积己
	//积己磊 积己
	public Book(String title, String writer, String publisher,int year, String img, int star, String plot, String review) {
		super(title, writer, year, img, star, plot, review);
		this.publisher = publisher;
	}
	//干滚函荐俊 措茄 set/get 皋家靛 积己
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}