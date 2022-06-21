
public class Customer extends Person{ //Person Ŭ���� ���
	private int no, mileage; //������� ����

	public Customer(int no, int mileage) { //�Ű������� �� �ʱ�ȭ�ϴ� ������. �Ű������� ����ȣ�� ���ϸ����� �޾ƿ�
		super(); //Person Ŭ������ Person()������ ȣ��
		this.no = no; 
		this.mileage = mileage;
	}
	public Customer(String name, String address, String tel, int no, int mileage) { //�Ű������� �� �ʱ�ȭ�ϴ� ������
		super(name, address, tel); //PersonŬ������ Person(name, address, tel) ȣ��. 
		this.no = no; 
		this.mileage =mileage;
	}
	
	public int getNo() { //����ȣ�� ��ȯ�ϴ� ������ �޼ҵ�
		return no;
	}

	public void setNo(int no) { //����ȣ�� �����ϴ� ������ �޼ҵ�
		this.no = no;
	}

	public int getMileage() { //���ϸ����� ��ȯ�ϴ� ������ �޼ҵ�
		return mileage;
	}

	public void setMileage(int mileage) { //���ϸ����� �����ϴ� ������ �޼ҵ�
		this.mileage = mileage;
	}
	
}
