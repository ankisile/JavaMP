import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalcFrame extends JFrame{
	private JTextField num1, num2, result;
	private JButton equal;
	public CalcFrame() {
		setTitle("계산기");//프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new FlowLayout()); //컨텐트 팬에 FlowLayout 배치관리자 설정
		
		num1= new JTextField(5); //text field 생성
		num2= new JTextField(5); //text field 생성
		result= new JTextField(5); //text field 생성
		equal = new JButton("="); //버튼 생성
		equal.addActionListener(new MyActionListener()); //버튼에 리스너 등록
		c.add(num1);c.add(new JLabel("X"));c.add(num2);c.add(equal);c.add(result); //컨텐트 팬에 부착

		setSize(300,100); //프레임 크기 300x300
		setVisible(true); //프레임 화면 출력
	}
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //이벤트 소스 컴포넌트의 레퍼런스를 리턴받아 받음
			if(obj == equal) { //레퍼런스가 equal과 같으면 같은 버튼이라는 뜻. 같은 버튼을 눌렀다는 뜻
				result.setText(Integer.parseInt(num1.getText())*Integer.parseInt(num2.getText())+"");
				//result라는 text field의 값을 num1*num2 한값으로 바꿔줌. num1과num2의 값을 받아올때 문자열로 받아와 지기 때문에 Warraper 객체 이용하여 문자열 숫자로 바꿔줌.
				//setText를 할때 문자열로 등록되어야 되기 때문에 숫자끼리 계산후 ""를 붙여서 문자열로 만들어줌
			}
		}
		
	}
	public static void main(String[] args) {
		new CalcFrame();

	}

}
