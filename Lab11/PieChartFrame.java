import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PieChartFrame extends JFrame{
	JTextField tf [] = new JTextField [4]; //입력할 text field 배열
	int angle [] =new int[4]; //각 과일마다의 각도를 넣을 배열
	int data[]= new int [4]; //각 과일이 몇개있는지를 넣을 배열
	String str [] = {"apple", "cherry", "strawberry", "prune"}; //과일들 명이 있는 배열
	Color col [] = {Color.red,Color.blue,Color.magenta,Color.orange}; //색깔들이 있는 배열
	
	public PieChartFrame() {
		setTitle("파이 차트 그리기"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c =getContentPane();
		c.setLayout(new BorderLayout()); //컨텐트팬의 배치관리자 BorderLayout
		JPanel panel = new JPanel(); //패널 생성
		panel.setLayout(new FlowLayout()); //패널의 배치관리자 FlowLayout
		panel.setBackground(Color.LIGHT_GRAY); //패널의 바탕색 밝은 회색
		for(int i=0;i<tf.length;i++) { //tf.length만큼 다음을 반복
			tf[i]=new JTextField("0",7); //textField 7칸으로 생성. "0"으로 초기화
			tf[i].addActionListener(new MyListener());  //text field에 리스너 등록
			panel.add(new JLabel(str[i]));	panel.add(tf[i]); //패널에 과일명 부착 하고 text field 부착
		}	
		c.add(panel, BorderLayout.NORTH); //panel을 북쪽에 부착
		c.add(new MyPanel(), BorderLayout.CENTER); //MyPanel() 객체를 가운데에 부착
		setSize(600, 500); //프레임 크기 600x500
		setVisible(true); //프레임 화면 출력
	}
	

	class MyPanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			int startAngle =0; //시작 각도는 0
			g.setFont(new Font(getFont().getName(),Font.BOLD,getFont().getSize())); //폰트 굵기 굵게 바꿔줌
			for(int i=0;i<tf.length;i++) {
				g.setColor(col[i]); //col[i]로 color지정
				g.drawString(str[i]+" "+(int)Math.round((double)angle[i]/360*100)+"%",100*(i+1),40);
				//(100*(i+1),40)위치에 문자열 출력. 
				//str[i]를 먼저 출력한후 퍼 (double)angle[i]/360*100이 퍼센트이기 때문에 이렇게 계산한 후 반올림을 해주고 정수형으로 바꿔줌. 그리고 출력 
				//나눌때 double을 붙이는 이유는 정수끼리는 몫이 정수이기 때문에 나눌때 몫이 소수가 나오면 0이 되어버림. 그래서 double을 붙여서 소수가 나오게 만들어줌
				g.fillArc(150, 80, 300, 300, startAngle, angle[i]); 
				//col[i]로 부채꼴 채우기. (150,80)에서 300x300에 내접하는 원에서 startAngle에서부터 angle[i] 만큼 부채꼴 그리기
				startAngle+=angle[i]; //startAngle에 angle[i]을 더해줘서 startAngle을 업데이트. 그다음 과일의 부채꼴을 그릴때 사용
			}

		}
		
	}
	class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int sum=0; //sum은 모든 과일 개수의 총합
			for(int i=0;i<data.length;i++) { //다음을 data.length만큼 반복
				data[i]=Integer.parseInt(tf[i].getText()); //text field에서 값을 얻어온 다음 정수형을 바꿔주고 data[i]에 저장
				sum = sum+data[i]; //sum에 data[i]를 더해줌
			}
				
			for(int i=0;i<data.length;i++) //다음을 data.length 만큼 반복
				angle[i]=(int) Math.round((double) data[i] / (double) sum * 360);
				//angle[i]에 각도를 계산한 값을 저장
			    //(double) data[i] / (double) sum * 360은 과일 개수에 따른 각도. 
			    //정수끼리는 몫이 정수이기 때문에 나눌때 몫이 소수가 나오면 0이 되어버림. 그래서 double을 붙여서 소수가 나오게 만들어줌
			
			repaint(); //다시그리기 요청
	
		}
		

	}
	public static void main(String[] args) {
		new PieChartFrame();

	}

}
