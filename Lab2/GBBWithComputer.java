import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 객체 생성 
		String str[] = {"가위","바위","보"}; //문자열 배열 생성
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		while(true) {
			System.out.print("가위 바위 보!>>"); 
			String result = scan.next(); //result에 입력받은 값 저장
			if(result.equals("그만")) { //result가 "그만"이면 "게임을 종료합니다..."를 출력하고 break문을 통해 무한 루프에서 빠져나옴
				System.out.println("게임을 종료합니다...");
				break;
			}
			int n = (int)(Math.random()*3); //0, 1, 2중에 랜덤하게 결정
			if(str[n].equals("가위")) { //컴퓨터가 낸것이 가위일때
				if(result.equals("가위")) //사용자가 가위이면 비김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 비겼습니다.");
				else if(result.equals("바위")) //사용자가 바위이면 사용자가 이김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 사용자가 이겼습니다.");
				else if(result.equals("보")) //사용자가 보이면 컴퓨터가 이김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 컴퓨터가 이겼습니다.");		
			}
			else if(str[n].equals("바위")) { //컴퓨터가 낸것이 바위이고
				if(result.equals("가위")) //사용자가 낸것이 가위이면 컴퓨터가 이김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 컴퓨터가 이겼습니다.");
				else if(result.equals("바위")) //사용자가 낸것이 바위이면 비김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 비겼습니다.");
				else if(result.equals("보")) //사용자가 낸것이 보이면 사용자가 이김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 사용자가 이겼습니다.");
			}
			else if(str[n].equals("보")) { //컴퓨터가 낸것이 보이고
				if(result.equals("가위")) //사용자가 낸것이 가위이면 사용자가 이김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 사용자가 이겼습니다.");
				else if(result.equals("바위")) //사용자가 낸것이 바위이면 컴퓨터가 이김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 컴퓨터가 이겼습니다.");
				else if(result.equals("보")) //사용자가 낸것이 보이면 비김
					System.out.println("사용자 = "+result+" , 컴퓨터 = "+str[n]+", 비겼습니다.");
				
			}
		}
		scan.close();
	}

}
