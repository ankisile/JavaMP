import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ���� 
		String str[] = {"����","����","��"}; //���ڿ� �迭 ����
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		while(true) {
			System.out.print("���� ���� ��!>>"); 
			String result = scan.next(); //result�� �Է¹��� �� ����
			if(result.equals("�׸�")) { //result�� "�׸�"�̸� "������ �����մϴ�..."�� ����ϰ� break���� ���� ���� �������� ��������
				System.out.println("������ �����մϴ�...");
				break;
			}
			int n = (int)(Math.random()*3); //0, 1, 2�߿� �����ϰ� ����
			if(str[n].equals("����")) { //��ǻ�Ͱ� ������ �����϶�
				if(result.equals("����")) //����ڰ� �����̸� ���
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", �����ϴ�.");
				else if(result.equals("����")) //����ڰ� �����̸� ����ڰ� �̱�
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", ����ڰ� �̰���ϴ�.");
				else if(result.equals("��")) //����ڰ� ���̸� ��ǻ�Ͱ� �̱�
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", ��ǻ�Ͱ� �̰���ϴ�.");		
			}
			else if(str[n].equals("����")) { //��ǻ�Ͱ� ������ �����̰�
				if(result.equals("����")) //����ڰ� ������ �����̸� ��ǻ�Ͱ� �̱�
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", ��ǻ�Ͱ� �̰���ϴ�.");
				else if(result.equals("����")) //����ڰ� ������ �����̸� ���
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", �����ϴ�.");
				else if(result.equals("��")) //����ڰ� ������ ���̸� ����ڰ� �̱�
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", ����ڰ� �̰���ϴ�.");
			}
			else if(str[n].equals("��")) { //��ǻ�Ͱ� ������ ���̰�
				if(result.equals("����")) //����ڰ� ������ �����̸� ����ڰ� �̱�
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", ����ڰ� �̰���ϴ�.");
				else if(result.equals("����")) //����ڰ� ������ �����̸� ��ǻ�Ͱ� �̱�
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", ��ǻ�Ͱ� �̰���ϴ�.");
				else if(result.equals("��")) //����ڰ� ������ ���̸� ���
					System.out.println("����� = "+result+" , ��ǻ�� = "+str[n]+", �����ϴ�.");
				
			}
		}
		scan.close();
	}

}
