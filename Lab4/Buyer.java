
public class Buyer {
	private int money; //������� ����
	public Buyer(int money) { //money�� �Ű������� �޾Ƽ� ������� ����
		this.money = money;
	}
	public void buy(Item t, int n) {
		System.out.println(t.toString()+"=>"+n+"�� ����"); 
		if(money>=t.getPrice()*n) { //money�� t.getPrice()*n �̻��̸� ���� ���� �ϹǷ�
			money = money - t.getPrice()*n; //money���� t.getPrice()*n ����
			System.out.println("���� �Ϸ� �� �ܾ� : "+money); //�ܾ� ���
		}
		else { //���Ű������� ������
			System.out.println("�ܾ� ����: "+money); //�ܾ� ���� ��� �� �ܾ� ���
		}
	}

}
