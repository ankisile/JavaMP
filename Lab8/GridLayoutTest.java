import java.awt.*;
import javax.swing.*;

public class GridLayoutTest extends JFrame{
	
	public GridLayoutTest() {
		setTitle("Ten Color Buttons Frame"); //������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //������ ������ ������ ���α׷��� �����ϵ��� ����
		
		GridLayout grid = new GridLayout(1,10); //1x10 ������ GridLayout ��ġ������ ����
		Container c =getContentPane(); //����Ʈ ���� �˾Ƴ���.
		
		c.setLayout(grid); //grid�� ����Ʈ���� ��ġ�����ڷ� ����
		
		Color[] col= {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY};
		//col�̶�� �̸��� �迭�� �����Ͽ� �� �迭�ȿ� ������ �־� �ʱ�ȭ
		
		for(int i=0;i<10;i++) { //10�� �ݺ�
			JButton b = new JButton(Integer.toString(i)); //��ư ����. ���ڷ� ���ڿ��� �����ؾ� �Ǳ� ������ Integer.toString(i)�� �̿��Ͽ� ���ڸ� ���ڿ��� �ٲ���
			b.setBackground(col[i]); //��ư�� ������ �迭�� �̿��Ͽ� ����
			b.setOpaque(true);   //������ �ٲ۰��� ȭ�鿡 ���̵��� ����
			c.add(b); //��ư�� ����Ʈ�ҿ� ����
		}
		
		setSize(600,300); //������ũ�� 600x300 ����
		setVisible(true); //ȭ�鿡 ������ ���
		
	}
	public static void main(String[] args) {
		new GridLayoutTest();

	}

}
