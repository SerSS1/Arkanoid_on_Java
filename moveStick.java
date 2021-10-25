package test2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class moveStick implements MouseMotionListener {			//Движение доски
	
	BallDraw ball = new BallDraw();
	int x1 = 0;
	int y1 = BallDraw.panel.getHeight()-20;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		/*...Доска двигается за курсором...*/
		x1 = arg0.getX() - 10;
		BallDraw.stick.setLocation(x1, y1);
	}

}
