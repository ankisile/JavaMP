import java.util.Scanner;
import java.util.Vector;

public class VectorRainfall {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ü ����
		Vector <Integer>v= new Vector<Integer>(); //�������� �ٷ�� ���� ����
		
		while(true) { //���� ����
			System.out.print("������ �Է� (0 �Է½� ����)>> ");
			int n = scan.nextInt(); //�� �޾Ƽ� ������ ����
			if(n==0) break; //n==0�̸� ���� ��������
			v.add(n); //���Ϳ� n ����
			int sum=0; //���� ��Ÿ���� ����
			for(int i=0;i<v.size();i++) { //i=0���� i=v.size()-1����
				System.out.print(v.get(i)+" "); //�ε��� i�� ��Ҹ� �޾ƿͼ� ���
				sum=sum+v.get(i); //�ε��� i�� ��Ҹ� �޾ƿͼ� sum�� ���ؼ� ����
			}
			System.out.println(); //�� �� ���
			System.out.println("���� ��� "+sum/v.size()); //sum�� ���Ͱ� �����ϴ� ����� ������ �����ְ� ���	
		}
		scan.close();
	}

}
