import java.util.Scanner;

public class RandomArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("���� �? "); //����ڷκ��� �Է��� �ޱ� ���� ��¹�
		int n = scan.nextInt(); // ��ĳ�ʸ� ���� �Է°� ����
		
		int arr[] = new int[n]; //�Է¹��� ���� ũ�⸸ŭ ���� �迭 ����
		for(int i=0;i<arr.length;i++) { //�迭�� ũ�⸸ŭ �ݺ��ϸ鼭
			int r = (int)(Math.random()*100 + 1); // 1~100������ ���� ���� r ����
			
			int chk=0; //�迭�� �ߺ��Ǵ� ���� �ִ��� Ȯ���ϴ� ����. ������ 1 �ƴϸ� 0. 0���� �ʱ�ȭ.
			for(int j=0;j<i;j++) //0���� i-1���� Ȯ���ϸ鼭
				if(r==arr[j]) { //�迭�� ������ r�� ������
					i--; //�ߺ��Ǵ� ���� ������ i���� �����ϸ� �ȵȴ�. �׷��� �ٱ� for������ �̿� ������� i���� �����ϹǷ�  �̸� �����ϱ� ���� i���� 1 �ٿ���
					chk=1; //chk�� 1 ���� �� break�� ���� for�� ����������
					break;
				}
			if(chk==0)  //chk�� 0�̸� �迭�� �ߺ��Ǵ� ���� �����Ƿ� �迭�� r�� ����
				arr[i]=r;
		}	
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" "); //�迭�� ȭ�鿡 ���
			if(i%10==9) System.out.println(); //�� �࿡ 10���� ��µǵ��� �������
		}
		scan.close();
	}
}
