import java.util.*;

public class CustomerManager {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in); //��ĳ�� ��ü ����
		
		HashMap <String, Integer> map = new HashMap <String, Integer>(); //�ؽø� ����
		
		System.out.println("** ����Ʈ ���� ���α׷��Դϴ� **");
		while(true) { //���� ����
			System.out.print("�̸��� ����Ʈ �Է�>> ");
			String s = scan.next(); //�̸� �Է� ����
			if(s.equals("�׸�")) break; //�̸��� "�׸�"�� ������ break
			int i = scan.nextInt(); //����Ʈ �Է� ����
			Integer exist = map.get(s); //s�� �ش��ϴ� value�� �޾ƿͼ� exist�� ����
			if(exist==null) //exist�� null�̸� �ش��ϴ� value���� ���ٴ� ��. �� �ش��ϴ� key�� ���ٴ� ��� ����.
				map.put(s, i);  //�ؽøʿ� ����
			else { //������
				i = exist+i; //i�� exist�� ���ؼ� ����
				map.put(s, i); //�ؽøʿ� ����. ���� key�� �� �����ϴ� ��� value���� ������
			}
			
			Set <String> keys = map.keySet(); //��� key�� ���� Set �÷��� ����
			Iterator<String> it = keys.iterator(); //Set�� �ִ� ��� key�� ������� �˻��ϴ� Iterator ����
			
			while(it.hasNext()) { //while���� ��� ����Ʈ ���� ���
				String name = it.next(); //���� Ű
				int point = map.get(name); //name�� �ش��ϴ� Ű�� value�޾ƿ�
				System.out.print("("+name+","+point+")"); //���
			}
			System.out.println(); //���� ���
		}
		scan.close();
	}

}
