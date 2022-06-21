import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficTest extends JFrame{
	JButton btn = new JButton("traffic light turn on"); //버튼 생성
	int light =0; //어디가 칠해져야 되는지를 나타내는 변수
	public TrafficTest() {
		setTitle("신호등"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c =getContentPane(); 
		c.setLayout(new BorderLayout()); //컨텐트팬의 배치관리자를 BorderLayout으로 설정
		btn.addActionListener(new MyListener()); //버튼에 리스너 등록
		c.add(new MyPanel(), BorderLayout.CENTER); //패널을 가운데에 부착
		c.add(btn, BorderLayout.SOUTH); //패널을 남쪽에 부착
		setSize(400, 500); //프레임 크기 400x500
		setVisible(true); //프레임 화면 출력
	}
	class MyPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			g.drawOval(150, 100, 100, 100); //(150,100)에 100x100사각형에 내접하는 원 그리기
			g.drawOval(150, 200, 100, 100); //(150,200)에 100x100사각형에 내접하는 원 그리기
			g.drawOval(150, 300, 100, 100); //(150,300)에 100x100사각형에 내접하는 원 그리기
			if(light==0) { //light가 0이면
				g.setColor(Color.RED);
				g.fillOval(150, 100, 100, 100); //(150,100)에 100x100사각형에 내접하는 원을 빨간색으로 채우기 
			}
			else if(light==1) { //light가 1이면 
				g.setColor(Color.GREEN);
				g.fillOval(150, 200, 100, 100); //(150,200)에 100x100사각형에 내접하는 원을 초록색으로 채우기 
			}
			else { //light가 3이면
				g.setColor(Color.YELLOW);
				g.fillOval(150, 300, 100, 100); //(150,300)에 100x100사각형에 내접하는 원을 노란색으로 채우기 
			}
		}
		
	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource(); //이벤트 발생한 객체 받아오기
			if(obj==btn) { //객체가 버튼이면
				light++; //light 1증가
				light = light%3; //light에 3으로 나누었을때 나머지 넣기
				
				repaint(); //다시 그리기 요청
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TrafficTest();
	}

}
