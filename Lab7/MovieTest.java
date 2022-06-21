import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Movie implements Serializable{ //��ü�� ����ȭ�� �����ͷ� ���Ǳ� ���ؼ��� ��ü�� �����ϴ� Ŭ������ Serializable �������̽��� �����ϰ� �־�� �Ѵ�
	private String title;
	private String director;
	private String genre;
	private int year; //�������
	
	public Movie(String title, String director, String genre, int year) { //�Ű������� ���� �޾ƿͼ� ������� �� �ʱ�ȭ�ϴ� ������ ����
		this.title= title;
		this.director = director;
		this.genre = genre;
		this.year= year;
	}
	
	public String getTitle() { //title�� getter �޼ҵ�
		return title;
	}

	public void setTitle(String title) { //title�� setter �޼ҵ�
		this.title = title;
	}

	public String getDirector() { //director�� getter �޼ҵ�
		return director;
	}

	public void setDirector(String director) { //director�� setter �޼ҵ�
		this.director = director;
	}

	public String getGenre() { //genre�� getter �޼ҵ�
		return genre;
	}

	public void setGenre(String genre) { //genre�� setter �޼ҵ�
		this.genre = genre;
	}

	public int getYear() { //year�� getter �޼ҵ�
		return year;
	}

	public void setYear(int year) { //year�� setter �޼ҵ�
		this.year = year;
	}

	public String toString() { //toString()�޼ҵ� ������
		return "[����:" + title + ", ����:" + director + ", �帣:" + genre + ", �����⵵:" + year + "]";
	}

}

public class MovieTest{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{ //���� ó��
		Scanner scan = new Scanner(System.in); //��ĳ�� ��ü ����
		HashMap <String, Movie> map = new HashMap<String, Movie>(); //�ؽø� ����
		
		while(true) {
			System.out.println("===========��ȭ ���� ����===========");
			System.out.println("1. ��ȭ �Է�/2. ��ȭ ���/3. ��ȭ �˻�/4. ���� ����/5. ���� ����/6. ����");
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
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat")); 
					//ObjectOutputStream ��ü ����. ObjectOutputStream�� FileOutputStream �����Ͽ� ��ü�� ������ ���̳ʸ� ���Ϸ� ����
					oos.writeObject(map); //��ü�� ����
					System.out.println("movie.dat�� ����Ǿ����ϴ�.");
					oos.close();
					break;
					
				case 5: //menu==5
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"));
					//ObjectInputStream ��ü ����. ObjectInputStream�� FileInputStream ���� ����
					map = (HashMap <String, Movie>) ois.readObject(); 
					//��ü�� �о map�� ����. �̶� readObject()������ ���ϵ� ���� (HashMap <String, Movie>)�� Ÿ�� ĳ���� �ؾ���.
					System.out.println("movie.dat�κ��� ������ �ҷ��Խ��ϴ�.");
					ois.close();
					break;
			}
		}
		
		scan.close();

	}

	

}
