import java.util.Scanner;

public class PrintAlphabet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		System.out.print("�ҹ��� ���ĺ� �ϳ��� �Է��Ͻÿ�>> "); //�Է��� �ޱ����� ��¹� ����
		String s = scan.next(); //���ڿ� �б�
		char c = s.charAt(0); //���ڿ��� ù��° ���� ����
		
		
		for(int i=0;i<=c-'a';i++) { //i�� 0���� c-'a'���� �����ϸ鼭 ������ �ݺ�
			for(char chr='a';chr<=c-i;chr++) { //'a'���� c-i���� ���. c-i�� �ϴ� ������ �� ������ ���� �������� ������ c-i�� ���� i���� Ŀ������ ��µǴ� ���ĺ��� �پ����.
				System.out.print(chr);
			}
			System.out.println();
		}
		
		scan.close();
	}
}
