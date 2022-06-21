class Dice{
	private int value; //�ֻ��� ���� �ʵ�. value�� �ֻ��� ���� ��Ÿ��
	public Dice() { //������. value�� 0���� �ʱ�ȭ
		value = 0;
	}
	void roll() { 
		value = (int)(Math.random()*6)+1; //�����Լ��� ����Ͽ� 1~6������ ���� ����
	}
	int getValue() {
		return value; //�ֻ��� ���� ���� ��ȯ
	}
}
public class DiceTest {

	public static void main(String[] args) {
		Dice dice1=new Dice();
		Dice dice2=new Dice(); //�ֻ��� 2�� ��ü ����
		int count = 0; //�ֻ��� ���� Ƚ���� ���� ���� ���� �� �ʱ�ȭ
		do {
			dice1.roll(); 
			dice2.roll(); //�ֻ��� 2���� ���� ������ �޼ҵ� ȣ��
			System.out.println("�ֻ���1= "+dice1.getValue()+" �ֻ���2= "+dice2.getValue());// �������� ���� �ֻ��� �� ���� ���� getValue()�� �޾ƿͼ� ���
			count++; //����Ƚ�� ����
		}while(dice1.getValue()+dice2.getValue()!=2); //�ֻ��� �� ���� ���� 2�� �ƴҵ��� ��� �ݺ�
		System.out.println("(1,1)�� �����µ� �ɸ� Ƚ�� = "+count); //(1,1)�� ���ö������� Ƚ�� ���
	}

}
