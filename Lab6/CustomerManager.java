import java.util.*;

public class CustomerManager {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in); //스캐너 객체 생성
		
		HashMap <String, Integer> map = new HashMap <String, Integer>(); //해시맵 생성
		
		System.out.println("** 포인트 관리 프로그램입니다 **");
		while(true) { //무한 루프
			System.out.print("이름과 포인트 입력>> ");
			String s = scan.next(); //이름 입력 받음
			if(s.equals("그만")) break; //이름이 "그만"과 같으면 break
			int i = scan.nextInt(); //포인트 입력 받음
			Integer exist = map.get(s); //s에 해당하는 value를 받아와서 exist에 저장
			if(exist==null) //exist가 null이면 해당하는 value값이 없다는 뜻. 즉 해당하는 key가 없다는 뜻과 같다.
				map.put(s, i);  //해시맵에 저장
			else { //있으면
				i = exist+i; //i에 exist를 더해서 저장
				map.put(s, i); //해시맵에 저장. 같은 key를 또 저장하는 경우 value값이 수정됨
			}
			
			Set <String> keys = map.keySet(); //모든 key를 가진 Set 컬렉션 리턴
			Iterator<String> it = keys.iterator(); //Set에 있는 모든 key를 순서대로 검색하는 Iterator 리턴
			
			while(it.hasNext()) { //while문은 모든 포인트 정보 출력
				String name = it.next(); //다음 키
				int point = map.get(name); //name에 해당하는 키의 value받아옴
				System.out.print("("+name+","+point+")"); //출력
			}
			System.out.println(); //한줄 띄기
		}
		scan.close();
	}

}
