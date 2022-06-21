import javax.swing.*;
import java.awt.*;

public class DrawFillTest extends JFrame{

	public DrawFillTest() {
		setTitle("Draw Fill 사용 예제"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c =getContentPane();
		c.setLayout(new GridLayout(0,3)); //컨탠트팬의 배치관리자를 0x3짜리 GridLayout으로 지정
		c.add(new MyPanel1()); c.add(new MyPanel2()); c.add(new MyPanel3()); //컨탠트팬에 패널 3개 부착
		setSize(1000, 400); //프레임 크기 1000x400
		setVisible(true); //프레임 화면 출력
	}
	
	class MyPanel1 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			g.drawRoundRect(15, 15, 300, 300, 30, 30); //(15,15)위치에서 300x300짜리 둥근 사각형 그리기
			g.setColor(Color.red); 
			g.fillRect(55, 60, 40, 230); //(55,60)위치에서 40x230 빨간색 사각형 칠하기
			g.setColor(Color.blue);
			g.fillRect(115, 100, 40, 190); //(115,100)위치에서 40x190 파란색 사각형 칠하기
			g.setColor(Color.orange);
			g.fillRect(175, 160, 40, 130); //(175,160)위치에서 40x130 주황색 사각형 칠하기
			g.setColor(Color.green);
			g.fillRect(235, 100, 40, 190); //(235,100)위치에서 40x190 초록색 사각형 칠하기
		}
	
	}
	class MyPanel2 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			g.drawRoundRect(15, 15, 300, 300, 30, 30); //(15,15)위치에서 300x300짜리 둥근 사각형 그리기
			g.setColor(Color.green);
			g.fillArc(40,40,250,250,-30, 110); //(40,40)위치에서 250x250 사각형에 내접하는 원호 -30도에서 110도 만큼 초록색으로 칠하기
			g.setColor(Color.red);
			g.fillArc(40,40,250,250,80, 120); //(40,40)위치에서 250x250 사각형에 내접하는 원호 80도에서 120도 만큼 빨간색으로 칠하기
			g.setColor(Color.blue);
			g.fillArc(40,40,250,250,200, 40); //(40,40)위치에서 250x250 사각형에 내접하는 원호 200도에서 40도 만큼 파란색으로 칠하기
			g.setColor(Color.yellow);
			g.fillArc(40,40,250,250,240, 90); //(40,40)위치에서 250x250 사각형에 내접하는 원호 240도에서 90도 만큼 노란색으로 칠하기
			

		}
	}
	class MyPanel3 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			g.drawRoundRect(15, 15, 300, 300, 30, 30); //(15,15)위치에서 300x300짜리 둥근 사각형 그리기
			g.setColor(Color.MAGENTA); //마젠타 색 선택
			int x[]= {165,140,55,123,100,165,230,210,270,190,165 };
			int y[]= {40,120,120,170,260,200,260,170,120,120,40};
			g.fillPolygon(x,y,x.length); //x[]와 y[]의 점으로 구성된 마젠타색 다각형 칠하기

		}
	}
	public static void main(String[] args) {
		new DrawFillTest();
	}

}
