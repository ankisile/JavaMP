
public class Human {
	private String name; //������� ����
	private int age;
	
	public Human(String name, int age){ //�Ű������� �̸��� ���̸� �޾ƿͼ� ��� ���� �� �ʱ�ȭ
		this.name = name;
		this.age = age;
	}

	public String getName() { //name�� ��ȯ�ϴ� ������ �޼ҵ�
		return name;
	}

	public void setName(String name) { //name�� �����ϴ� ������ �޼ҵ�
		this.name = name;
	}

	public int getAge() { //age�� ��ȯ�ϴ� ������ �޼ҵ�
		return age;
	}

	public void setAge(int age) { //age�� �����ϴ� ������ �޼ҵ�
		this.age = age;
	}

	
	public String toString() { //��ü�� ���� ������ ���ڿ��� ��ȯ
		return "�̸�: " + name + ", ����: " + age ;
	}
	
}
