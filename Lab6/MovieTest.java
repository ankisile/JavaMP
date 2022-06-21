import java.util.*;

public class MovieTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		HashMap <String, Movie> map = new HashMap<String, Movie>(); //�ؽø� ����
		
		while(true) {
			System.out.println("===========��ȭ ���� ����===========");
			System.out.println("1. �Է�/2. ���/3. �˻�/4. ����/5. ����/6. ����");
			System.out.print("�޴��Է�>> ");
			int menu = scan.nextInt(); //�޴� �Է¹޾Ƽ� ����
			scan.nextLine(); //���Ͱ� �ԷµǾ��ֱ� ������ ó���ϱ� ���� �ڵ�
			if(menu==6) break; //menu==6�̸� break
			switch(menu) { //switch�� �̿�
				case 1: //menu==1
					System.out.print("����:");
					String title = scan.nextLine();
					System.out.print("����:");
					String director = scan.nextLine();
					System.out.print("�帣:");
					String genre = scan.nextLine();
					System.out.print("�⵵:");
					int year = scan.nextInt();
					//��ȭ�� ����, ����, �帣, �⵵�� �Է� ����
					
					Movie mov = new Movie(title,director,genre,year); //Movie ��ü ����
					
					map.put(title, mov); //title�� Movie ��ü�� ������ ����
					break;
					
				case 2: //menu==2
					Set <String> keys = map.keySet(); //��� key�� ���� Set �÷��� ����
					Iterator <String> it = keys.iterator(); //Set�� �ִ� ��� key�� ������� �˻��ϴ� Iterator ����
					while(it.hasNext()) { //while���� ��� ��ȭ ���� ���
						title = it.next(); //���� Ű
						System.out.println(map.get(title));
						//title Ű�� �ش��ϴ� value print. value�� ��ü �̹Ƿ� ��ü�� ����ϸ� toString()�� ���
					}
					break;
					
				case 3: //menu==3
					System.out.print("�˻��� ���� �Է�: ");
					String search = scan.nextLine(); //ã���� �ϴ� ���ڿ� �Է�
					if(map.get(search)==null) //�� ���ڿ��� key�� �ش��ϴ� value�� ���ٸ� key�� ���� ����
						System.out.println(search+"��� ��ȭ�� �����ϴ�.");
					else //������ �ش��ϴ� value�� ���
						System.out.println(map.get(search));

					break;
					
				case 4: //menu==4
					System.out.print("������ ���� �Է�: ");
					String revise = scan.nextLine(); //�����ϰ��� �ϴ� ���ڿ� �Է�
					mov = map.get(revise); //mov�� �� ���ڿ��� key�� �ش��ϴ� value ����. mov�� Movie ��ü
					if(mov==null) //mov�� null�̸� value�� ���ٴ� ������ key�� ���ٴ� ��
						System.out.println(revise+"��� ��ȭ�� �����ϴ�.");
					else { //mov�� null�� �ƴϸ�
						System.out.println(mov);
						System.out.print("����:");
						title = scan.nextLine();
						System.out.print("����:");
						director = scan.nextLine();
						System.out.print("�帣:");
						genre = scan.nextLine();
						System.out.print("�⵵:");
						year = scan.nextInt();
						//������ �Է� ����
						
						mov.setTitle(title);
						mov.setDirector(director);
						mov.setGenre(genre);
						mov.setYear(year);
						//�Է¹��� ������ setter �޼ҵ带 �̿��Ͽ� �ش��ϴ� ��������� ���� �ٲ���
						
						map.put(title, mov); //�ش��ϴ� key�� value���� ��������
					}
					
					break;
					
					
				case 5: //menu==2
					System.out.print("������ ���� �Է�: ");
					String delete = scan.nextLine(); //������ ���� �Է� ����
					if(map.get(delete)==null) //���ڿ�(Ű)�� ���� ���
						System.out.println(delete+"��� ��ȭ�� �����ϴ�.");
					else { //���ڿ�(Ű)�� �ִ� ���
						map.remove(delete); //�ش� Ű���� value ���� ����
						System.out.println(delete+"�� �����Ǿ����ϴ�.");
					}
					
					break;
			}
		}
		
		scan.close();

	}

}
