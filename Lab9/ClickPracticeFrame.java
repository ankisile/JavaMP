import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame{
	private JLabel la = new JLabel("C"); //라벨 생성

	public ClickPracticeFrame() {
		setTitle("클릭 연습용 응용프로그램"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정

		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(null); //배치관리자 삭제
		
		la.setSize(50,50); //라벨의 사이즈 50x50으로 설정
		la.setLocation(100,100); //라벨의 위치 (100,100)으로 설정
		
		la.addMouseListener(new MyMouseAdapter()); //라벨에 리스너 등록
		c.add(la); //컴포넌트에 라벨 부착
		
		
		setSize(500, 500); //프레임크기 500x500
		setVisible(true); //프레임 화면 출력
	}
	private class MyMouseAdapter extends MouseAdapter{ //MouseAdapter 상속받아 리스너 구현

		@Override
		public void mouseClicked(MouseEvent e) { //클릭될 경우
			int x = (int)(Math.random()*450); //x좌표의 random값
			int y = (int)(Math.random()*400); //y좌표의 random값
			//내부 패널의 크기는 프레임크기보다 작기 때문에 x, y의 랜덤값의 범위를 500보다 작게 만들어주었다.
			la.setLocation(x,y); //라벨의 위치 x,y로 바꿔줌.
		}
		
	}
	public static void main(String[] args) {
		new ClickPracticeFrame();

	}

}
