import java.util.Scanner;

public class Lab1_8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("x1, y1 �Է�>>");
		int x1=scan.nextInt();
		int y1=scan.nextInt();
		System.out.print("x2, y2 �Է�>>");
		int x2=scan.nextInt();
		int y2=scan.nextInt();
		
		if((x1<100&&x2<100)||(x1>200&&x2>200)||(y1>200&&y2>200)||(y1<100&&y2<100))
			System.out.println("�浹 ����");
		else System.out.println("�浹 �߻�");
		/*x1�� x2�� 100�̸��϶� �Ǵ� 200�ʰ��Ҷ� y���� ������� ������ �浹�� ����. 
		 * y1�� y2�� 100�̸��϶� �Ǵ� 200�ʰ��Ҷ� ���� x���� ������� �浹�� ������ ����.
		 * �� ������ �����ϸ� �浹�� �߻��ϱ� ������ if�� else���� �̿��Ͽ� �浹������ �浹�߻��� ����ش�.
		 * (���� ���ϴ� ��쵵 �浹�Ѵٰ� �����Ͽ� �� ��쵵 �浹 �߻��� �����Ͽ���.)
		*/
		scan.close();
	}

}
