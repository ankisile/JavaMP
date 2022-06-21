import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MyReviseDialog extends JDialog{
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
	JTextArea infoTA[] = new JTextArea[2];
	MyButtonListener mbl = new MyButtonListener();
	ItemCollections ic;
	JPanel files = new JPanel();
	
	int index;
	public MyReviseDialog(JFrame frame, String title, int idx) {
		super(frame, title,true); //true는 모달 타입을 만들도록 지시
		setLayout(new BorderLayout()); //BorderLayout으로 지정
		ic = new ItemCollections();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //X버튼 활성화 X
		
		JPanel up = new JPanel(); //패널 생성(폰트)
		ButtonGroup group = new ButtonGroup(); //버튼 그룹 객체 생성		
		
		index = idx;//선택한 리스트의 인덱스를 가져와야 함
		
		//files 패널부터 먼저 구성
		filepath.setEditable(false);
		open.addActionListener(mbl);
		files.add(filepath); files.add(open);
		
		if(ic.getType(index)!=null) {
		if(ic.getType(index).equals("Movie")) { //수정하는게 영화일경우. 양식은 추가할때와 같음
			Movie mov = (Movie)ic.getItem(index); //객체 받아옴
			rbMovie = new JRadioButton("Movie", true);
			rbBook = new JRadioButton("Book");
			rbBook.setEnabled(false); //책버튼 선택 못함
		
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
		//입력된 값 받아옴
		infoTF[0].setText(mov.getTitle()); 
		infoTF[1].setText(mov.getWriter());
		infoTF[2].setText(mov.getActor());
		//콤보박스도 선택된 값 받아옴
		int genreIdx = 0, rateIdx = 0, yearIdx = 0;
		genre = new JComboBox<String>(strGenre);
		for(int i=0;i<strGenre.length;i++) {
			if(mov.getGenre().equals(strGenre[i])) {
				genreIdx = i;
				break;
			}
		}
		genre.setSelectedIndex(genreIdx);
		
		rate = new JComboBox<String>(strRate);
		for(int i=0;i<strRate.length;i++) {
			if(mov.getGrade().equals(strRate[i])) {
				rateIdx = i;
				break;
			}
		}
		rate.setSelectedIndex(rateIdx);
		
		year = new JComboBox<String>(strYear);
		for(int i=0;i<strYear.length;i++) {
			if(mov.getYear().equals(strYear[i])) {
				yearIdx = i;
				break;
			}
		}
		year.setSelectedIndex(yearIdx);
		//이미지 경로 받아옴
		filepath.setText(mov.getImg());
		//슬라이더도 선택된 값 받아옴
		sl=new JSlider(JSlider.HORIZONTAL, 1, 10, Integer.parseInt(mov.getStar())); //슬라이더 생성. 
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
		JPanel downRight = new JPanel();
		downRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i]=new JTextArea(5, 20);
			downRight.add(new JScrollPane(infoTA[i]));
			infoTA[i].setLineWrap(true);
			}
		//입력된 값 받아옴
		infoTA[0].setText(mov.getPlot());
		infoTA[1].setText(mov.getReview());
		infodown.add(downLeft, BorderLayout.WEST);
		infodown.add(downRight, BorderLayout.CENTER);
		
		infoInput.add(infoup,BorderLayout.CENTER);
		infoInput.add(infodown, BorderLayout.SOUTH);
		info.add(infoInput,BorderLayout.CENTER);	
		}
		
		
		if(ic.getType(index).equals("Book")) { //수정하는게 책일 경우
			Book book = (Book)ic.getItem(index); //객체 받아옴
			rbMovie = new JRadioButton("Movie");
			rbBook = new JRadioButton("Book", true);
			rbMovie.setEnabled(false); //영화 선택 못함
		
		group.add(rbMovie); group.add(rbBook);
		up.add(rbMovie);up.add(rbBook);
		
		infoBorder = BorderFactory.createTitledBorder("도서정보"); //제목이 붙여진 경계 생성
		info.setBorder(infoBorder); //경계 등록
		info.setLayout(new BorderLayout());
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
		//입력된 값 받아옴
		infoTF[0].setText(book.getTitle());
		infoTF[1].setText(book.getWriter());
		infoTF[2].setText(book.getPublisher());
		//콤보박스 선택된 값 받아옴
		int yearIdx = 0;
		year = new JComboBox<String>(strYear);
		for(int i=0;i<strYear.length;i++) {
			if(book.getYear().equals(strYear[i])) {
				yearIdx = i;
				break;
			}
		}
		year.setSelectedIndex(yearIdx);
		//이미지 경로 받아옴
		filepath.setText(book.getImg());

		//슬라이더 값 받아옴
		sl=new JSlider(JSlider.HORIZONTAL, 1, 10,Integer.parseInt(book.getStar())); //슬라이더 생성. 수평이고 1~10 범위를 가지며 5 초기값
		sl.setPaintLabels(true); //슬라이더의 라벨이 보임
		sl.setPaintTicks(true); //슬라이더 눈끔이 보임
		sl.setPaintTrack(true); //슬라이더 트랙이 보임
		sl.setMajorTickSpacing(1); //슬라이더 큰 눈끔 간격 1
		infoRight.add(year);infoRight.add(files);infoRight.add(sl);

		infoup.add(infoLeft, BorderLayout.WEST);
		infoup.add(infoRight, BorderLayout.CENTER);

		JPanel infodown = new JPanel();
		JPanel downLeft = new JPanel();
		downLeft.setLayout(new GridLayout(0,1,15,60));
		downLeft.add(new JLabel("책소개"));
		downLeft.add(new JLabel("감상평"));
		JPanel downRight = new JPanel();
		downRight.setLayout(new GridLayout(0,1,15,5));
		for(int i=0;i<infoTA.length;i++) {
			infoTA[i]=new JTextArea(5, 20);
			downRight.add(new JScrollPane(infoTA[i]));
			infoTA[i].setLineWrap(true);
			}
		//입력된 값 받아옴
		infoTA[0].setText(book.getPlot());
		infoTA[1].setText(book.getReview());
		infodown.add(downLeft, BorderLayout.WEST);
		infodown.add(downRight, BorderLayout.CENTER);
		
		infoInput.add(infoup,BorderLayout.CENTER);
		infoInput.add(infodown, BorderLayout.SOUTH);
		
		info.add(infoInput,BorderLayout.CENTER);
		}
		}
		
		//ok버튼
		JPanel but = new JPanel();
		ok.addActionListener(mbl);
		but.add(ok);
		info.add(infoInput,BorderLayout.CENTER);info.add(but,BorderLayout.SOUTH);
		
		add(up, BorderLayout.NORTH);add(info, BorderLayout.CENTER);
		setSize(300,750); 
	}
	
	
	class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==open) { //불러오기
				JFileChooser chooser = new JFileChooser(".//");
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String pathName = chooser.getSelectedFile().getPath();
				filepath.setText(pathName);
			}
			else if(obj==ok) { //ok
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
				if(rbMovie.isSelected()) { //영화를 선택했을 경우
					Item i = new Movie(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),strGenre[genre.getSelectedIndex()],
							strRate[rate.getSelectedIndex()],Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.revise(index,i); //수정
				}
				else if(rbBook.isSelected()) { //책을 선택했을 경우
					Item i = new Book(infoTF[0].getText(),infoTF[1].getText(),infoTF[2].getText(),
							Integer.parseInt(strYear[year.getSelectedIndex()]),
							filepath.getText(),sl.getValue(),infoTA[0].getText(),infoTA[1].getText());
					ic.revise(index,i); //수정
				}
			
				setVisible(false);
			}
			System.gc();	
		}
	}
}
