import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
	public static void printVector(Vector<Integer> v) { //�÷����� �Ű������� �޴� �޼ҵ� ����
		System.out.print("[");
		for(int i=0;i<v.size()-1;i++) { //i=0���� i�� v.size()-2������ �ε��� i��� ���
			System.out.print(v.get(i)+", ");
		}
		System.out.println(v.get(v.size()-1)+"]"); //�ε��� i=v.size()-1��� ���
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		
		Vector <Integer>v = new Vector<Integer>(); //�������� �ٷ�� ���� ����
		System.out.print("����(-1�� �Էµ� ������)>> ");
		while(true) { 
			int num= scan.nextInt(); //�� �Է¹޾� ������ ����
			if(num==-1) break; //num�� -1�̸� ���� ���� ��������
			v.add(num); //���Ϳ� �� ����
		}
		System.out.print("������ :");
		printVector(v); //printVector()�޼ҵ� ȣ��
		
		int max=0; //���� ū ���� ��Ÿ���� index�� �����ϴ� max���� ����. 0���� �ʱ�ȭ
		for(int i=0;i<v.size();i++) { //i�� 0���� i�� v.size()(���Ͱ� �����ϴ� ��� ����)������ ������ �ݺ�
			if(v.get(max)<v.get(i)) { //�ε��� i��° ������ ���ؼ� i��° ������ ũ�ٸ�
				max=i; //max�� i ����
			}
		}
		System.out.println("���� ū �� "+v.get(max)+" ����");
		v.remove(max);  //���Ϳ��� �ε��� max�� ��� ����
		printVector(v); //printVector()�޼ҵ� ȣ��
		
		int min=0; //���� ���� ���� ��Ÿ���� index�� �����ϴ� min���� ����. 0���� �ʱ�ȭ
		for(int i=0;i<v.size();i++) { //i�� 0���� i�� v.size()(���Ͱ� �����ϴ� ��� ����)������ ������ �ݺ�
			if(v.get(min)>v.get(i)) { //�ε��� i��° ������ ���ؼ� i��° ������ �۴ٸ�
				min=i; //min�� i ����
			}
		}
		System.out.println("���� ���� �� "+v.get(min)+" ����");
		v.remove(min); //���Ϳ��� �ε��� min�� ��� ����
		printVector(v);	//printVector()�޼ҵ� ȣ��	
		
		scan.close();
	}

}
