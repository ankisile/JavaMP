
public class Student extends Human{ //Human Ŭ���� ���
	private String major; //������� ����
	private int sID;
	
	public Student(String name, int age, String major, int sID) {//�Ű������� �̸�, ����, ����, �й��� �޾ƿͼ� �ʱ�ȭ
		super(name, age); //�θ� Ŭ������ ������ ȣ��
		this.major = major; //�Ű������� �޾ƿ� ������ ��� ������ ������ �й��� �ʱ�ȭ
		this.sID = sID;
		
	}

	public String getMajor() { //������ ���� ������ �޼ҵ�. major�� ��ȯ
		return major;
	}

	public void setMajor(String major) { //������ ���� ������ �޼ҵ�
		this.major = major;
	}

	public String toString() { //toString() �޼ҵ� ������. 
		return "[�л� ����]"+super.toString()+", ����:" + major + ", �й�:" + sID+"]";
	//�θ��� toString()�� ȣ���Ͽ� �޾ƿ� ���ڿ� ���� �߰��� ���� ���� �����Ͽ� ���ڿ� ��ȯ
	}
	
}
