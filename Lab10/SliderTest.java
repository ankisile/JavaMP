import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;

public class SliderTest extends JFrame{
	JTextArea ta;
	JSlider sl;
	public SliderTest() {
		setTitle("TextArea Practice Frame"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new BorderLayout(10, 10)); //컨탠트팬에 BorderLayout 배치관리자 설정.
		
		ta=new JTextArea(5, 10); //5줄 10칸 짜리 text area 생성
		ta.addKeyListener(new MyKeyListener()); //text area에 리스너 등록
		sl=new JSlider(JSlider.HORIZONTAL, 0, 100, 0); //슬라이더 생성. 수평이고 0~100까지 범위를 가지며 0이 초기값
		sl.setPaintLabels(true); //슬라이더의 라벨이 보임
		sl.setPaintTicks(true); //슬라이더 눈끔이 보임
		sl.setPaintTrack(true); //슬라이더 트랙이 보임
		sl.setMinorTickSpacing(5); //슬라이더 작은 눈끔 간격 5
		sl.setMajorTickSpacing(20); //슬라이더 큰 눈끔 간격 20
		sl.addChangeListener(new MyChangeListener()); //슬라이더에 리스너 등록
		c.add(new JScrollPane(ta), BorderLayout.CENTER); //text area를 스크롤팬에 부착
		c.add(sl, BorderLayout.SOUTH); //컴포넌트 팬에 부착
		
		setSize(300,200); //프레임 크기 300x200
		setVisible(true); //프레임 화면 출력
	}
	class MyChangeListener implements ChangeListener{ //슬라이더에 해당하는 리스너
		@Override
		public void stateChanged(ChangeEvent e) {
			if(ta.getText().length()>sl.getValue()) { //text area에 입력된 길이가 sl이 나타내는 값보다 크다면
				try {
					ta.setText(ta.getText(0,sl.getValue())); //text area에서 0~sl이 나타내는 값까지 받아와서 다시 set함
				} catch (BadLocationException e1) {	}
			}
			else { //text area에 입력된 길이가 s1이 나타내는 값보다 작다면
				sl.setValue(ta.getText().length()); //슬라이더의 값을 text area에 입력된 길이로 바꿔줌
			}
		}
		
	}
	class MyKeyListener extends KeyAdapter{//text area에 해당하는 리스너
		public void keyTyped(KeyEvent e) {
			int size = ta.getText().length(); //text area에 입력된 길이를 받아와서 변수에 저장
			if(size>=100) { //size가 100이상이면
				try {
					ta.setText(ta.getText(0, 100)); //text area에서 0~100까지까지 받아와서 다시 set함
				} catch (BadLocationException e1) {	}
			}
			sl.setValue(size); //슬라이더의 값을 size로 설정
		}
	}
	public static void main(String[] args) {
		new SliderTest();
	}

}
