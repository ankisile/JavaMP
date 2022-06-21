import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawGraphic extends JFrame{
	Container c;
	JButton line, rect, circle, tri, color;
	int x1, y1, x2, y2;
	int menu; //버튼이 무엇이 눌렸는지를 정수로 저장하는 변수. menu라는 변수를 통해 어떤 버튼이 눌렸는지 알 수 있음
	Color col;
	public DrawGraphic() {
		setTitle("그래픽 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		c =getContentPane();
		createToolBar(); // 툴바 생성, 프레임에 삽입
		c.add(new MyPanel(), BorderLayout.CENTER); //패널 생성후 컨텐트팬에 부착
		setSize(500,500); //프레임 크기 500x500
		setVisible(true);
	}
	
	class MyPanel extends JPanel{ //그림 그리는 패널
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) { //마우스가 눌렸을때
					x1=e.getX(); //마우스 좌표값 받아오기
					y1=e.getY();
				}
				@Override
				public void mouseReleased(MouseEvent e) { //마우스가 떨어졌을때
					x2=e.getX(); //마우스 좌표값 받아오기
					y2=e.getY();
					repaint(); //다시그리기 요청
				}
			});
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) { //마우스를 누르고 움직일때
					x2=e.getX(); //마우스 좌표값 받아오기
					y2=e.getY();
					repaint(); //다시그리기 요청
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			g.setColor(col); //col로 색 설정
			int x = Math.min(x1, x2); //x는 x1과 x2중 작은 값
			int y = Math.min(y1, y2); //y는 y1과 y2중 작은 값
			int w = Math.abs(x1-x2); //w는 x1-x2의 절대값
			int h=Math.abs(y1-y2); //h는 y1-y2의 절대값
			if(menu==1) //menu가 1 이면
				g.drawLine(x1, y1, x2, y2); //선 그리기
			else if (menu==2) //menu가 2이면
				g.drawRect(x,y,w,h); //사각형 그리기
			else if (menu==3) //menu가 3이면
				g.drawOval(x, y, w, h); //원(타원)그리기
			else if (menu==4) { //menu가 4이면
				int xArr[]= {x1+(x2-x1)/2,x1,x2};
				int yArr[]= {y1,y2,y2};
				g.drawPolygon(xArr, yArr, xArr.length); //삼각형 그리기
			}
				
		}
	
	}
	//툴바를 생성하여 컨텐츠팬에 부착
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("Menu"); //툴바 생성
		toolBar.setBackground(Color.LIGHT_GRAY); //툴바 배경색 밝은 회색
		
		toolBar.setLayout(new GridLayout(1,0)); //툴바 GridLayout으로 설벙
		//툴바에 메뉴로 사용할 컴포넌트 삽입
		toolBar.add(new JLabel("도형")); //툴바에 라벨 삽입
		MyListener ml = new MyListener(); //리스너 생성
		line = new JButton(" ＼ "); //버튼 생성
		line.addActionListener(ml); //버튼에 리스너 등록
		rect = new JButton(" □ "); //버튼 생성 
		rect.addActionListener(ml); //버튼에 리스너 등록
		circle = new JButton(" ○ "); //버튼 생성
		circle.addActionListener(ml);  //버튼에 리스너 등록
		tri = new JButton(" △ "); //버튼 생성
		tri.addActionListener(ml); //버튼에 리스너 등록
		toolBar.add(line);toolBar.add(rect);toolBar.add(circle);toolBar.add(tri); //툴바에 버튼 삽입
		toolBar.add(new JLabel("색 선택")); //툴바에 라벨 삽입
		color = new JButton("색"); //버튼 생성
		color.addActionListener(ml); //버튼에 리스너 등록
		toolBar.add(color);  //툴바에 버튼 삽입
		c.add(toolBar,BorderLayout.NORTH); //툴바를 컨탠트 팬에 삽입
	}
	class MyListener implements ActionListener{ //버튼 눌렀을때 리스너

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //작동된 객체 받아오기
			if(obj==line) { //작동된 객체가 line이면
				menu=1;
			}
			else if(obj==rect) { //작동된 객체가 rect이면
				menu=2;
			}
			else if(obj==circle) { //작동된 객체가 circle이면
				menu=3;
			}
			else if(obj==tri) { //작동된 객체가 tri이면
				menu=4;
			}
			else if(obj==color) { //작동된 객체가 color이면
				Color selectedColor = JColorChooser.showDialog(null, "색상 선택", Color.YELLOW); //컬러 다이얼로그를 출력하고 사용자가 선택한 색을 알아온다 
				if(selectedColor !=null) //사용자가 색을 선택하고 "확인"버튼을 누른경우
					col=selectedColor; //사용자가 선태한 색으로 문자열 색 변경
			}
		}
		
	}

	public static void main(String[] args) {
		new DrawGraphic();
	}

}
