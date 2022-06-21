import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Movie implements Serializable{ //객체가 직렬화된 데이터로 사용되기 위해서는 객체를 생성하는 클래스가 Serializable 인터페이스를 포함하고 있어야 한다
	private String title;
	private String director;
	private String genre;
	private int year; //멤버변수
	
	public Movie(String title, String director, String genre, int year) { //매개변수로 값을 받아와서 멤버변수 값 초기화하는 생성자 선언
		this.title= title;
		this.director = director;
		this.genre = genre;
		this.year= year;
	}
	
	public String getTitle() { //title의 getter 메소드
		return title;
	}

	public void setTitle(String title) { //title의 setter 메소드
		this.title = title;
	}

	public String getDirector() { //director의 getter 메소드
		return director;
	}

	public void setDirector(String director) { //director의 setter 메소드
		this.director = director;
	}

	public String getGenre() { //genre의 getter 메소드
		return genre;
	}

	public void setGenre(String genre) { //genre의 setter 메소드
		this.genre = genre;
	}

	public int getYear() { //year의 getter 메소드
		return year;
	}

	public void setYear(int year) { //year의 setter 메소드
		this.year = year;
	}

	public String toString() { //toString()메소드 재정의
		return "[제목:" + title + ", 감독:" + director + ", 장르:" + genre + ", 개봉년도:" + year + "]";
	}

}

public class MovieTest{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{ //예외 처리
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		HashMap <String, Movie> map = new HashMap<String, Movie>(); //해시맵 생성
		
		while(true) {
			System.out.println("===========영화 정보 관리===========");
			System.out.println("1. 영화 입력/2. 영화 출력/3. 영화 검색/4. 파일 저장/5. 파일 열기/6. 종료");
			System.out.print("메뉴입력>> ");
			int menu = scan.nextInt(); //메뉴 입력받아서 저장
			scan.nextLine(); //엔터가 입력되어있기 때문에 처리하기 위한 코드
			if(menu==6) break; //menu==6이면 break
			switch(menu) { //switch문 이용
				case 1: //menu==1
					System.out.print("제목:");
					String title = scan.nextLine();
					System.out.print("감독:");
					String director = scan.nextLine();
					System.out.print("장르:");
					String genre = scan.nextLine();
					System.out.print("년도:");
					int year = scan.nextInt();
					//영화의 제목, 감독, 장르, 년도를 입력 받음
					
					Movie mov = new Movie(title,director,genre,year); //Movie 객체 생성
					
					map.put(title, mov); //title과 Movie 객체를 쌍으로 저장
					break;
					
				case 2: //menu==2
					Set <String> keys = map.keySet(); //모든 key를 가진 Set 컬렉션 리턴
					Iterator <String> it = keys.iterator(); //Set에 있는 모든 key를 순서대로 검색하는 Iterator 리턴
					while(it.hasNext()) { //while문은 모든 영화 정보 출력
						title = it.next(); //다음 키
						System.out.println(map.get(title));
						//title 키에 해당하는 value print. value는 객체 이므로 객체를 출력하면 toString()가 출력
					}
					break;
					
				case 3: //menu==3
					System.out.print("검색할 제목 입력: ");
					String search = scan.nextLine(); //찾고자 하는 문자열 입력
					if(map.get(search)==null) //그 문자열의 key에 해당하는 value가 없다면 key가 없는 것임
						System.out.println(search+"라는 영화가 없습니다.");
					else //있으면 해당하는 value를 출력
						System.out.println(map.get(search));

					break;
					
				case 4: //menu==4
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.dat")); 
					//ObjectOutputStream 객체 생성. ObjectOutputStream과 FileOutputStream 연결하여 객체의 정보를 바이너리 파일로 저장
					oos.writeObject(map); //객체를 저장
					System.out.println("movie.dat에 저장되었습니다.");
					oos.close();
					break;
					
				case 5: //menu==5
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.dat"));
					//ObjectInputStream 객체 생성. ObjectInputStream과 FileInputStream 파일 읽음
					map = (HashMap <String, Movie>) ois.readObject(); 
					//객체를 읽어서 map에 저장. 이때 readObject()에서의 리턴된 값을 (HashMap <String, Movie>)로 타입 캐스팅 해야함.
					System.out.println("movie.dat로부터 정보를 불러왔습니다.");
					ois.close();
					break;
			}
		}
		
		scan.close();

	}

	

}
