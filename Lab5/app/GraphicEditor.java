package app; //Ŭ������ �Ҽӵ� app ��Ű��
import base.Shape; //base ��Ű���� Shape Ŭ������ �̿��ϱ����� import�� ���
import derived.Circle2; //derived ��Ű���� Circle2 Ŭ������ �̿��ϱ����� import�� ���

public class GraphicEditor { //GraphicEditor Ŭ������ app��Ű���� ����

	public static void main(String[] args) {
		Shape shape = new Circle2(); //��ü ����
		shape.draw(); //�޼ҵ� ȣ��
	}

}
