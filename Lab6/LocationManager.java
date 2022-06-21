import java.util.*;

public class LocationManager {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in); //��ĳ�� ��ü ����
		
		HashMap<String, Location> cityMap = new HashMap<String, Location>(); //�ؽø� ����
		
		System.out.println("����,����,�浵�� �Է��ϼ���.");
		for(int i=0;i<4;i++) { //4�� ������ �ݺ�
			System.out.print(">> ");
			String s = scan.nextLine(); //������ �Է¹޾� s�� ����
			StringTokenizer st = new StringTokenizer(s, ","); //s�� ,�� �������� ���ڿ��� �и��ϴ� ��Ʈ�� ��ũ������ ����
			String city = st.nextToken().trim(); //��ū�� �޾ƿ��� trim()�޼ҵ带 �̿��Ͽ� ��������
			double latitude = Double.parseDouble(st.nextToken().trim());  
			double longitude = Double.parseDouble(st.nextToken().trim());
			//��ū�� �޾ƿ��� trim()�޼ҵ带 �̿��Ͽ� ��������. Wrapper Ŭ������ parseDouble()�� �̿��Ͽ� ���ڿ��� �Ǽ��� ��ȯ
			
			Location loc = new Location(city,latitude,longitude); //Location ��ü ����
			cityMap.put(city, loc); //�ؽøʿ� �����̸��� Location ��ü�� ������ ����
		}
		System.out.println("-----------------------------------");
		//��� ���� ���
		Set <String> keys = cityMap.keySet(); //��� key�� ���� Set �÷��� ����
		Iterator<String> it = keys.iterator(); //Set�� �ִ� ��� key�� ������� �˻��ϴ� Iterator ����
		
		while(it.hasNext()) { //while���� ��� �������� ���
			String name = it.next(); //���� Ű. ���� �̸�
			Location l = cityMap.get(name); // ���� �̸��� �ش��ϴ� value�޾ƿ�
			System.out.println(name+"\t"+l.getLatitude()+"\t"+l.getLongitude()); //getter�޼ҵ带 �̿��Ͽ� ���
		}
		System.out.println("-----------------------------------");
		//�˻�
		while(true) {
			System.out.print("���� �̸� >> "); 
			String search = scan.next(); //�˻��� �����̸� �޾Ƽ� ����
			if(search.equals("�׸�")) break; //���ڿ� "�׸�"�� ������ break
			Location l = cityMap.get(search); // search�� �ش��ϴ� Ű�� value �޾ƿ�
			if(l==null) //l�� null�̸� ��ü�� ���ٴ� ��. �� �˻��ϴ� ���� ���ٴ� ��
				System.out.println(search+"�� �����ϴ�.");
			else //������ getter �޼ҵ带 �̿��Ͽ� ���
				System.out.println(search+"\t"+l.getLatitude()+"\t"+l.getLongitude());
		}
		scan.close();
	}

}
