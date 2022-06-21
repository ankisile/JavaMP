
public class Location {
	private String city;
	private double latitude;
	private double longitude; //��� ���� ����
	
	public Location(String city, double latitude, double longitude) { //�Ű������� ���� �޾ƿͼ� ������� �� �ʱ�ȭ�ϴ� ������ ����
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getCity() { //city�� getter�޼ҵ�
		return city;
	}
	public void setCity(String city) { //city�� setter�޼ҵ�
		this.city = city;
	}
	public double getLatitude() { //latitude�� getter�޼ҵ�
		return latitude;
	}
	public void setLatitude(double latitude) { //latitude�� setter�޼ҵ�
		this.latitude = latitude;
	}
	public double getLongitude() { //longitude�� getter�޼ҵ�
		return longitude;
	}
	public void setLongitude(double longitude) { //longitude�� setter�޼ҵ�
		this.longitude = longitude;
	}
	
}
