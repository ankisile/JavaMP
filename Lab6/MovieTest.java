import java.util.*;

public class MovieTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성
		HashMap <String, Movie> map = new HashMap<String, Movie>(); //해시맵 생성
		
		while(true) {
			System.out.println("===========영화 정보 관리===========");
			System.out.println("1. 입력/2. 출력/3. 검색/4. 수정/5. 삭제/6. 종료");
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
					System.out.print("수정할 제목 입력: ");
					String revise = scan.nextLine(); //수정하고자 하는 문자열 입력
					mov = map.get(revise); //mov에 그 문자열의 key에 해당하는 value 저장. mov는 Movie 객체
					if(mov==null) //mov가 null이면 value가 없다는 뜻으로 key가 없다는 뜻
						System.out.println(revise+"라는 영화가 없습니다.");
					else { //mov가 null이 아니면
						System.out.println(mov);
						System.out.print("제목:");
						title = scan.nextLine();
						System.out.print("감독:");
						director = scan.nextLine();
						System.out.print("장르:");
						genre = scan.nextLine();
						System.out.print("년도:");
						year = scan.nextInt();
						//정보를 입력 받음
						
						mov.setTitle(title);
						mov.setDirector(director);
						mov.setGenre(genre);
						mov.setYear(year);
						//입력받은 정보를 setter 메소드를 이용하여 해당하는 멤버변수의 값을 바꿔줌
						
						map.put(title, mov); //해당하는 key의 value값을 수정해줌
					}
					
					break;
					
					
				case 5: //menu==2
					System.out.print("삭제할 제목 입력: ");
					String delete = scan.nextLine(); //삭제할 제목 입력 받음
					if(map.get(delete)==null) //문자열(키)이 없는 경우
						System.out.println(delete+"라는 영화가 없습니다.");
					else { //문자열(키)이 있는 경우
						map.remove(delete); //해당 키값과 value 값을 삭제
						System.out.println(delete+"가 삭제되었습니다.");
					}
					
					break;
			}
		}
		
		scan.close();

	}

}
