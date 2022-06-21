import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class FontTest extends JFrame{
	JRadioButton rbfont1, rbfont2, rbfont3;
	JCheckBox ckbold, ckitalic;
	JTextField tfsize, tftext;
	JLabel result;

	public FontTest() {
		setTitle("Font 설정"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new BorderLayout(10, 10)); //컨탠트팬에 BorderLayout 배치관리자 설정. 수평간격 10, 수직간격 10로 설정
	
		JPanel left = new JPanel(); //패널 생성
		left.setLayout(new GridLayout(0,1,10,10)); //패널에 GridLayout 배치관리자 설정.열을 1로 고정이고 행은 자동으로 추가되는 만큼 확장됨. 수평, 수직간격 10
		//패널에 부착
		left.add(new JLabel("Font 설정")); 
		left.add(new JLabel("Style 설정"));
		left.add(new JLabel("Size 설정"));
		left.add(new JLabel("Text 내용"));

		
		MyRadioListener mrl = new MyRadioListener(); //라디오버튼에 대한 리스너 객체 생성
		MyCheckListener mcl = new MyCheckListener(); //체크박스에 대한 리스너 객체 생성

		JPanel center = new JPanel(); //패널 생성
		center.setLayout(new GridLayout(0,1,10,10)); //패널에 GridLayout 배치관리자 설정.열을 1로 고정이고 행은 자동으로 추가되는 만큼 확장됨. 수평, 수직간격 10
		
		JPanel panelFont = new JPanel(); //패널 생성(폰트)
		ButtonGroup font = new ButtonGroup(); //버튼 그룹 객체 생성
		rbfont1 = new JRadioButton("굴림"); //라디오 버튼 생성
		rbfont1.addItemListener(mrl); //라디오버튼에 리스너 등록
		rbfont2 = new JRadioButton("돋움", true); //라디오 버튼 생성. 초기로 선택되게 함
		rbfont2.addItemListener(mrl); //라디오버튼에 리스너 등록
		rbfont3 = new JRadioButton("궁서"); //라디오 버튼 생성
		rbfont3.addItemListener(mrl); //라디오버튼에 리스너 등록

		font.add(rbfont1);font.add(rbfont2);font.add(rbfont3); //버튼 그룹에 부착
		panelFont.add(rbfont1);	panelFont.add(rbfont2);	panelFont.add(rbfont3); //패널에 부착

		JPanel panelStyle = new JPanel(); //패널 생성(스타일)
		ckbold = new JCheckBox("BOLD"); //체크박스 생성
		ckbold.addItemListener(mcl); //체크박스에 리스너 등록
		ckitalic = new JCheckBox("ITALIC"); //체크박스 생성
		ckitalic.addItemListener(mcl); //체크박스에 리스너 등록
		panelStyle.add(ckbold);	panelStyle.add(ckitalic); //패널에 부착

		tfsize= new JTextField("20"); //텍스트필드 생성. 초기값 20
		tfsize.addActionListener(new ActionListener(){//익명클래스로 텍스트필드에 리스너 등록
			public void actionPerformed(ActionEvent e) {
				Font f = result.getFont(); //font를 받아옴
				result.setFont(new Font(f.getFontName(), f.getStyle(), Integer.parseInt(tfsize.getText()))); //글씨의 size를 바꿔줌
			}
		});

		tftext = new JTextField("Hello Java"); //텍스트필드 생성. 초기값 "Hello Java"
		tftext.addActionListener(new ActionListener(){ //익명클래스로 텍스트 필드에 리스너 등록
			public void actionPerformed(ActionEvent e) {
				result.setText(tftext.getText()); //입력한 text를 받아와서 결과를 보여주는 Label에 set함
			}
		});

		center.add(panelFont);	center.add(panelStyle);	center.add(tfsize);	center.add(tftext); //패널 부착

		
		JPanel bottom = new JPanel(); //패널 생성
		Border resultBorder = BorderFactory.createTitledBorder("Font 설정 결과"); //제목이 붙여진 경계 생성
		bottom.setBorder(resultBorder); //경계 등록
		result = new JLabel(); //라벨 생성. 결과값을 보여줌
 		result.setText(tftext.getText()); //입력한 text를 받아와서 결과를 보여주는 Label에 set함
		result.setFont(new Font("돋움", Font.PLAIN, Integer.parseInt(tfsize.getText()))); //초기값들 받아와서 result(결과)의 글씨 설정
		bottom.add(result); //패널에 부착
		
		c.add(left, BorderLayout.WEST); c.add(center, BorderLayout.CENTER); c.add(bottom, BorderLayout.SOUTH);//컨텐트팬에 부착
		
		setSize(300,250); //프레임 크기 300x250
		setVisible(true); //프레임 화면 출력
	}
	
	class MyRadioListener implements ItemListener{ //라디오 버튼에 대한 리스너
		@Override
		public void itemStateChanged(ItemEvent e) {
			Font f= result.getFont(); //font받아옴
			
			if(rbfont1.isSelected()) { //굴림이 선택되었으면
				result.setFont(new Font("굴림",f.getStyle(), f.getSize())); //굴림으로 폰트바꿔줌	
			}
			else if(rbfont2.isSelected()) { //돋움이 선택되었으면
				result.setFont(new Font("돋움",f.getStyle(),f.getSize())); //돋움으로 폰트바꿔줌	
			}
			else if(rbfont3.isSelected()) { //궁서가 선택되었으면
				result.setFont(new Font("궁서",f.getStyle(),f.getSize()));	//궁서로 폰트바꿔줌
			}
		
		}
		
	}
	class MyCheckListener implements ItemListener{ //체크박스에 대한 리스너
		@Override
		public void itemStateChanged(ItemEvent e) {
			Font f= result.getFont(); //font를 받아옴
			
			if(ckbold.isSelected() &&ckitalic.isSelected()) { //BOLD와 ITALIC이 체크되어있으면
				result.setFont(new Font(f.getFontName(),Font.BOLD+Font.ITALIC, f.getSize())); //BOLD와 ITALIC으로 폰트 스타일 바꿔줌
			}
			else if(ckbold.isSelected()) { //BOLD가 체크되어있으면
				result.setFont(new Font(f.getFontName(),Font.BOLD, f.getSize())); //BOLD로 스타일 바꿔줌
			}
			else if(ckitalic.isSelected()){ //ITALIC이 체크되어있으면
				result.setFont(new Font(f.getFontName(),Font.ITALIC, f.getSize())); //ITALIC으로 스타일 바꿔줌
			}
			else { //체크가 없으면
				result.setFont(new Font(f.getFontName(),Font.PLAIN, f.getSize())); //기본 스타일로 바꿔줌
			}
		}	
	}
	
	
	public static void main(String[] args) {
		new FontTest();
	}

}
