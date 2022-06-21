import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

class MyAppendDialog extends JDialog{
	JRadioButton rbMovie, rbBook;
	JPanel info = new JPanel(); //패널 생성
	JPanel infoInput= new JPanel();
	Border infoBorder;
	String strMovie [] = {"제목","감독","배우","장르","등급","개봉년도","포스터","별점"};
	String strBook [] = {"제목","저자","출판사","출판년도","책이미지","별점"};
	JTextField infoTF [] =new JTextField [3];
	JTextField filepath = new JTextField(10);
	JButton ok = new JButton("OK");
	JButton open = new JButton("불러오기");
	JComboBox <String> genre, rate, year;
	String strGenre [] = {"드라마","로멘스","액션","미스터리","공포"};
	String strRate [] = {"전체","12세 이상","15세 이상","청소년 관람 불가"};
	String strYear [] = {"2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
	JSlider sl;
	JPanel files = new JPanel();
	JPanel downRight = new JPanel();
	JTextArea infoTA[] = new JTextArea[2];
	MyButtonListener mbl = new MyButtonListener();
	ItemCollections ic;
	
	public MyAppendDialog(JFrame frame, String title) {
	
		super(frame, title,true); //true는 모달 타입을 만들도록 지시
		setLayout(new BorderLayout()); //BorderLayout으로 지정
		ic = new ItemCollections();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //X버튼 활성화 X
		
		JPanel up = new JPanel(); //패널 생성(폰트)
		ButtonGroup group = new ButtonGroup(); //버튼 그룹 객체 생성
		//라디오 버튼 생성
		rbMovie = new JRadioButton("Movie", true);
		rbMovie.addItemListener(new MyRadioListener());
		rbBook = new JRadioButton("Book");
		rbBook.addItemListener(new MyRadioListener());
		group.add(rbMovie); group.add(rbBook);
		up.add(rbMovie);up.add(rbBook);
		
		infoBorder = BorderFactory.createTitledBorder("영화정보"); //제목이 붙여진 경계 생성
		info.setBorder(infoBorder); //경계 등록
		info.setLayout(new BorderLayout());
		JPanel infoup = new JPanel();
		JPanel infoLeft = new JPanel();
		infoLeft.setLayout(new GridLayout(0,1,15,30));
		for(int i=0;i<strMovie.length;i++) {
			infoLeft.add(new JLabel(strMovie[i]));
		}
		JPanel infoRight = new JPanel();
		infoRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTF.length;i++) {
			infoTF[i]=new JTextField(20);
			infoRight.add(infoTF[i]);
		}
		//콤보박스 등록
		genre = new JComboBox<String>(strGenre);
		rate = new JComboBox<String>(strRate);
		year = new JComboBox<String>(strYear);
		//이미지 파일경로 
		filepath.setEditable(false);
		filepath.setText("");
		open.addActionListener(mbl);
		files.add(filepath); files.add(open);
		//슬라이드 생성
		sl=new JSlider(JSlider.HORIZONTAL, 1, 10, 5); //슬라이더 생성. 수평이고 1~10 범위를 가지며 5 초기값
		sl.setPaintLabels(true); //슬라이더의 라벨이 보임
		sl.setPaintTicks(true); //슬라이더 눈끔이 보임
		sl.setPaintTrack(true); //슬라이더 트랙이 보임
		sl.setMajorTickSpacing(1); //슬라이더 큰 눈끔 간격 1
		infoRight.add(genre);infoRight.add(rate);infoRight.add(year);infoRight.add(files);infoRight.add(sl);
		
		infoup.add(infoLeft, BorderLayout.WEST);
		infoup.add(infoRight, BorderLayout.CENTER);

		JPanel infodown = new JPanel();

		JPanel downLeft = new JPanel();
		downLeft.setLayout(new GridLayout(0,1,15,60));
		downLeft.add(new JLabel("줄거리"));
		downLeft.add(new JLabel("감상평"));
		//텍스트 에리어
		downRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i]=new JTextArea(5, 20);
			downRight.add(new JScrollPane(infoTA[i]));
			infoTA[i].setLineWrap(true);
			}
		infodown.add(downLeft, BorderLayout.WEST);
		infodown.add(downRight, BorderLayout.CENTER);
		
		infoInput.add(infoup,BorderLayout.CENTER);
		infoInput.add(infodown, BorderLayout.SOUTH);
		info.add(infoInput,BorderLayout.CENTER);	
		//ok 버튼
		JPanel but = new JPanel();
		ok.addActionListener(mbl);
		but.add(ok);
		info.add(infoInput,BorderLayout.CENTER);info.add(but,BorderLayout.SOUTH);
		
		add(up, BorderLayout.NORTH);add(info, BorderLayout.CENTER);
		setSize(300,750); 
		
	}
	class MyRadioListener implements ItemListener{ //라디오에 대한 리스너
		@Override
		public void itemStateChanged(ItemEvent e) {
			infoInput.removeAll();
			infoInput.repaint();
			if(rbMovie.isSelected()) { //영화 선택
				infoBorder = BorderFactory.createTitledBorder("영화정보"); //제목이 붙여진 경계 생성
				info.setBorder(infoBorder); //경계 등록
				JPanel infoup = new JPanel();
				JPanel infoLeft = new JPanel();
				infoLeft.setLayout(new GridLayout(0,1,15,30));
				for(int i=0;i<strMovie.length;i++) {
					infoLeft.add(new JLabel(strMovie[i]));
				}
				JPanel infoRight = new JPanel();
				infoRight.setLayout(new GridLayout(0,1,15,5));
				for(int i=0;i<infoTF.length;i++) {
					infoTF[i]=new JTextField(20);
					infoRight.add(infoTF[i]);
				}
			
				filepath.setText(""); //텍스트 필드 초기화
			
				sl.setValue(5); //슬라이드값 초기화
			
				genre.setSelectedIndex(0);rate.setSelectedIndex(0);year.setSelectedIndex(0); //콤보박스 값 초기화
				infoRight.add(genre);infoRight.add(rate);infoRight.add(year);infoRight.add(files);infoRight.add(sl);
				
				infoup.add(infoLeft, BorderLayout.WEST);
				infoup.add(infoRight, BorderLayout.CENTER);

				JPanel infodown = new JPanel();

				JPanel downLeft = new JPanel();
				downLeft.setLayout(new GridLayout(0,1,15,60));
				downLeft.add(new JLabel("줄거리"));
				downLeft.add(new JLabel("감상평"));
				//텍스트 에리어 초기화
				infoTA[0].setText("");
				infoTA[1].setText(""); 
				infodown.add(downLeft, BorderLayout.WEST);
				infodown.add(downRight, BorderLayout.CENTER);
				
				infoInput.add(infoup,BorderLayout.CENTER);
				infoInput.add(infodown, BorderLayout.SOUTH);
				
				info.add(infoInput,BorderLayout.CENTER);				
			}
			if(rbBook.isSelected()) { //book 선택

				infoBorder = BorderFactory.createTitledBorder("도서정보"); //제목이 붙여진 경계 생성
				info.setBorder(infoBorder); //경계 등록
				JPanel infoup = new JPanel();
				JPanel infoLeft = new JPanel();
				infoLeft.setLayout(new GridLayout(0,1,15,30));
				for(int i=0;i<strBook.length;i++) {
					infoLeft.add(new JLabel(strBook[i]));
				}
				JPanel infoRight = new JPanel();
				infoRight.setLayout(new GridLayout(0,1,15,5));
				for(int i=0;i<infoTF.length;i++) {
					infoTF[i]=new JTextField(20);
					infoRight.add(infoTF[i]);
				}
			
				year.setSelectedIndex(0); //콤보박스 값 초기화
		
				filepath.setText(""); //이미지 경로 초기화
				sl.setValue(5); //슬라이드 값 초기화

				infoRight.add(year);infoRight.add(files);infoRight.add(sl);

				infoup.add(infoLeft, BorderLayout.WEST);
				infoup.add(infoRight, BorderLayout.CENTER);

				JPanel infodown = new JPanel();

				JPanel downLeft = new JPanel();
				downLeft.setLayout(new GridLayout(0,1,15,60));
				downLeft.add(new JLabel("책소개"));
				downLeft.add(new JLabel("감상평"));
				//텍스트 에리어 초기화
				infoTA[0].setText("");
				infoTA[1].setText("");
				infodown.add(downLeft, BorderLayout.WEST);
				infodown.add(downRight, BorderLayout.CENTER);
				
				infoInput.add(infoup,BorderLayout.CENTER);
				infoInput.add(infodown, BorderLayout.SOUTH);
				
				info.add(infoInput,BorderLayout.CENTER);
			}
			info.validate();
		}	
	}
	public void setInitialize() { //다이얼로그가 닫히고 나서 호출됨. 입력된 값들을 없애줌
		rbMovie.setSelected(true);
		for(int i=0;i<infoTF.length;i++) {
			infoTF[i].setText("");
		}
		genre.setSelectedIndex(0);
		rate.setSelectedIndex(0);
		year.setSelectedIndex(0);
		filepath.setText("");
		sl.setValue(5);
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i].setText("");
		}
	}
	class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			JButton bobj = (JButton)obj;
			if(bobj.getText().equals("불러오기")) { //불러오기 버튼
				JFileChooser chooser = new JFileChooser(".//");
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String pathName = chooser.getSelectedFile().getPath();
				filepath.setText(pathName);
			}
			else if(obj==ok) { //ok버튼
				//입력된 곳이 하나라도 없을 경우
				for(int i=0;i<infoTF.length;i++) {
					if(infoTF[i].getText().length()==0) {
						JOptionPane.showMessageDialog(null, "입력하지 않은 곳이 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				for(int i=0;i<infoTA.length;i++) {
					if(infoTA[i].getText().length()==0) {
						JOptionPane.showMessageDialog(null, "입력하지 않은 곳이 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(rbMovie.isSelected()) { //영화 버튼이 눌러져 있을때
					Item i = new Movie(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),strGenre[genre.getSelectedIndex()],
							strRate[rate.getSelectedIndex()],Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.create(i); //벡터에 넣기
				}
				else if(rbBook.isSelected()) { //책 버튼이 눌러져 있을때
					Item i = new Book(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),
							Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.create(i); //책 넣기
				}
			
				setVisible(false);
			}
			System.gc();	
		}
	}
}
