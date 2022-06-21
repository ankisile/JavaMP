import javax.swing.*;
import java.awt.*;

public class ImageTest extends JFrame{

	public ImageTest() {
		setTitle("그래픽 이미지 연습"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		setContentPane(new MyPanel()); //생성한 패널을 컨텐트팬으로 사용
		
		setSize(500, 500); //프레임 크기 500x500
		setVisible(true); //프레임 화면 출력
	}
	class MyPanel extends JPanel{
		private ImageIcon icon =new ImageIcon("Back.jpg"); //이미지 파일 읽기
		private Image img = icon.getImage(); //이미지 정보 추출
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); //JPanel의 paintComponent() 호출
			int w = getWidth(); //패널의 폭을 변수에 저장
			int h= getHeight(); //패널의 높이를 변수에 저장
			int iw = img.getWidth(this); //이미지의 폭을 변수에 저장
			int ih = img.getHeight(this); //이미지의 높이를 변수에 저장
			g.drawImage(img,0,0,(w/2)-5,(h/2)-5,0,0,iw/2,ih/2,this); //4등분 했을때 왼쪽 위의 사진을 패널에서 (0,0)에서 (패널의 폭/2-5,패널의 높이/2-5)로 조절
			g.drawImage(img,(w/2)+5,0,w,(h/2)-5,iw/2,0,iw,ih/2,this); //4등분 했을때 오른쪽 위의 사진을 패널에서 (패널의 폭/2+5,0)에서 (패널의 폭,패널의 높이/2-5)로 조절
			g.drawImage(img,0,h/2+5,(w/2)-5,h,0,ih/2,iw/2,ih,this); //4등분 했을때 왼쪽 아래의 사진을 패널에서 (0,패널의 높이/2+5)에서 (패널의 폭/2-5,패널의 높이)로 조절
			g.drawImage(img,w/2+5,h/2+5,w,h,iw/2,ih/2,iw,ih,this); //4등분 했을때 오른쪽 아래의 사진을 (패널의 폭/2+5,패널의 높이/2+5)에서 (패널의 폭,패널의 높이)로 조절

		}
		
	}
	public static void main(String[] args) {
		new ImageTest();
	}

}
