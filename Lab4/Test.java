
public class Test {

	public static void main(String[] args) {
		Buyer m = new Buyer(40000); //�ʱ� �ڱ� 40000���� ���� Buyer ����
		m.buy((new Food("�����", 5000)), 3); //Food ��ü ���� �ϰ� buy�޼ҵ� ȣ��
		m.buy((new Food("���", 3000)), 2); //Food ��ü ���� �ϰ� buy�޼ҵ� ȣ��
		m.buy((new Book("Java Programming", 7000,"�ڹ�")), 1); //Book ��ü ���� �ϰ� buy�޼ҵ� ȣ��
		m.buy((new Movie("�λ���", 8000, "����ȣ")), 1); //Movie ��ü ���� �ϰ� buy�޼ҵ� ȣ��
		m.buy((new Food("���", 2000)), 3); //Food ��ü ���� �ϰ� buy�޼ҵ� ȣ��

	}

}
