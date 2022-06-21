
public class Location {
	private String city;
	private double latitude;
	private double longitude; //멤버 변수 선언
	
	public Location(String city, double latitude, double longitude) { //매개변수로 값을 받아와서 멤버변수 값 초기화하는 생성자 선언
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getCity() { //city의 getter메소드
		return city;
	}
	public void setCity(String city) { //city의 setter메소드
		this.city = city;
	}
	public double getLatitude() { //latitude의 getter메소드
		return latitude;
	}
	public void setLatitude(double latitude) { //latitude의 setter메소드
		this.latitude = latitude;
	}
	public double getLongitude() { //longitude의 getter메소드
		return longitude;
	}
	public void setLongitude(double longitude) { //longitude의 setter메소드
		this.longitude = longitude;
	}
	
}
