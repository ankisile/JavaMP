import java.util.*;

public class LocationManager {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in); //스캐너 객체 생성
		
		HashMap<String, Location> cityMap = new HashMap<String, Location>(); //해시맵 생성
		
		System.out.println("도시,위도,경도를 입력하세요.");
		for(int i=0;i<4;i++) { //4번 다음을 반복
			System.out.print(">> ");
			String s = scan.nextLine(); //문장을 입력받아 s에 저장
			StringTokenizer st = new StringTokenizer(s, ","); //s를 ,를 기준으로 문자열을 분리하는 스트링 토크나이저 생성
			String city = st.nextToken().trim(); //토큰을 받아오고 trim()메소드를 이용하여 공백제거
			double latitude = Double.parseDouble(st.nextToken().trim());  
			double longitude = Double.parseDouble(st.nextToken().trim());
			//토큰을 받아오고 trim()메소드를 이용하여 공백제거. Wrapper 클래스의 parseDouble()을 이용하여 문자열을 실수로 변환
			
			Location loc = new Location(city,latitude,longitude); //Location 객체 생성
			cityMap.put(city, loc); //해시맵에 도시이름과 Location 객체를 쌍으로 저장
		}
		System.out.println("-----------------------------------");
		//모든 정보 출력
		Set <String> keys = cityMap.keySet(); //모든 key를 가진 Set 컬렉션 리턴
		Iterator<String> it = keys.iterator(); //Set에 있는 모든 key를 순서대로 검색하는 Iterator 리턴
		
		while(it.hasNext()) { //while문은 모든 도시정보 출력
			String name = it.next(); //다음 키. 도시 이름
			Location l = cityMap.get(name); // 도시 이름에 해당하는 value받아옴
			System.out.println(name+"\t"+l.getLatitude()+"\t"+l.getLongitude()); //getter메소드를 이용하여 출력
		}
		System.out.println("-----------------------------------");
		//검색
		while(true) {
			System.out.print("도시 이름 >> "); 
			String search = scan.next(); //검색할 도시이름 받아서 저장
			if(search.equals("그만")) break; //문자열 "그만"과 같으면 break
			Location l = cityMap.get(search); // search에 해당하는 키의 value 받아옴
			if(l==null) //l이 null이면 객체가 없다는 뜻. 즉 검색하는 것이 없다는 뜻
				System.out.println(search+"는 없습니다.");
			else //있으면 getter 메소드를 이용하여 출력
				System.out.println(search+"\t"+l.getLatitude()+"\t"+l.getLongitude());
		}
		scan.close();
	}

}
