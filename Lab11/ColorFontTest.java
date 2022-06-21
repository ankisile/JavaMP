import javax.swing.*;
import java.awt.*;

public class ColorFontTest extends JFrame{
	private MyPanel panel = new MyPanel();
	public ColorFontTest() {
		setTitle("Color, Font 사용 예제"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		setContentPane(panel); //생성한 panel 패널을 컨텐트팬으로 사용
		
		setSize(700, 250); //프레임 크기 700x250
		setVisible(true); //프레임 화면 출력
	}

	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			g.setColor(Color.BLUE); //파란색 선택
			g.setFont(new Font("궁서",Font.BOLD,30)); //폰트는 궁서, 굵게, 사이즈는 30
			g.drawString("국적: 대한민국(폰트:궁서)", 50, 50); //(50,50)위치에 문자열 출력
			g.setColor(Color.RED); //빨간색 선택
			g.setFont(new Font("휴먼아미체", Font.BOLD, 25)); //폰트는 휴먼아미체, 굵게, 사이즈는 25
			g.drawString("주소 : 경기도 고양시 (폰트:휴먼아미체)", 50, 90); //(50,90)위치에 문자열 출력
			g.setColor(Color.ORANGE); //주황색 선택
			g.setFont(new Font("휴먼매직체", Font.PLAIN, 30)); //폰트는 휴먼매직체, 보통, 사이즈는 30
			g.drawString("성명 : 송민영 (폰트:휴먼매직체)", 50, 130); //(50,130)위치에 문자열 출력
			g.setColor(Color.darkGray); //진한회색 선택
			g.setFont(new Font("휴먼편지체", Font.PLAIN, 15)); //폰트는 휴먼편지체, 보통, 사이즈는 15
			g.drawString("학번: 1916737 (휴먼편지체)", 50, 150); //(50,150)위치에 문자열 출력
		}
		
	}
	public static void main(String[] args) {
		new ColorFontTest();

	}

}
