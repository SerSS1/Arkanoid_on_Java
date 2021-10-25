package test2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class closeWindow implements MouseListener {			//Кнопка закрытия окна

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
/*...Завершение приложения...*/
		System.exit(0);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {

	}
	@Override
	public void mouseExited(MouseEvent arg0) {

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
