import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ����
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //ȯ���ҵ��� ����
		System.out.print("�ݾ��� �Է��Ͻÿ�>>"); //����ڷκ��� �Է��� �ޱ� ���� ��¹�
		int money = scan.nextInt(); //�Է¹��� �� ����
		for(int i=0;i<unit.length;i++) { //�迭�� ũ�⸸ŭ �ݺ��ϸ鼭
			if(money/unit[i]!=0) { //money/unit[i]���� 0�� �ƴϸ�
				System.out.println(unit[i]+"�� ¥�� : "+money/unit[i]+"��"); //���
				money=money%unit[i]; //money�� �������� �����ϱ� ���ؼ� money%unit[i]���� �̿��Ͽ� �������� �����Ѵ�.
			}
		}
		
		scan.close();

	}

}
