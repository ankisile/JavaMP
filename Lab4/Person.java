
public class Person {
	private String name, address, tel; //��� ���� ����

	public Person() { //�Ű����� ���� ������ ����
		this.name = "����";
		this.address = "����";
		this.tel = "010-1234-5678";
	}
	public Person(String name, String address, String tel) { //�Ű����� �ִ� ������ ����. �Ű������� ������ ������ �ʱ�ȭ
		this.name = name;
		this.address = address;
		this.tel = tel;
	}
	public String getName() { //�̸��� ��ȯ�ϴ� ������ �޼ҵ�
		return name;
	}

	public void setName(String name) { //�̸��� �����ϴ� ������ �޼ҵ�
		this.name = name;
	}

	public String getAddress() { //�ּҸ� ��ȯ�ϴ� ������ �޼ҵ�
		return address;
	}

	public void setAddress(String address) { //�ּҸ� �����ϴ� ������ �޼ҵ�
		this.address = address;
	}

	public String getTel() { //��ȭ��ȣ�� ��ȯ�ϴ� ������ �޼ҵ�
		return tel;
	}

	public void setTel(String tel) { //��ȭ��ȣ�� �����ϴ� ������ �޼ҵ�
		this.tel = tel;
	}
	
}
