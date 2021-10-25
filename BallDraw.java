package test2;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class BallDraw {			//Основной класс с методом - main()
		static int x1 = 10;
		static int y1 = 10;
		static int x2 = 100;
		static int y2 = 100;
		public static JPanel panel = new JPanel();
		public static JPanel stick = new JPanel();
		public static JPanel ballImg = new JPanel();
		static BallMove ballMove = new BallMove();
		static Graphics2D gr;
		static int blockWidth;
		static int blockHeight;
		static int blocksInLine = 10;
		static int blocksInColumn = 10;
		static JPanel[][] blockArray = new JPanel[blocksInLine+1][blocksInColumn+1];
		static int[][] blockCoord = new int[blocksInLine*blocksInColumn+5][2];
		
	public static void main(String[] args) throws InterruptedException {
		
		onCreate();
		
		gr = (Graphics2D)panel.getGraphics();
		gr.setXORMode(Color.BLACK);
		blockWidth = (int)(panel.getWidth()/15);
		blockHeight = (int)(panel.getHeight()/30);
		
		/*...Создаем и добавляем кирпичики...*/
		for(int i=0;i<blocksInColumn;i++){
			for(int j=0;j<blocksInLine;j++){
				blockArray[i][j] = new JPanel();
				blockArray[i][j].setSize(blockWidth, blockHeight);
				blockArray[i][j].setLocation((30 + j*(blockWidth+10)), (10 + (blockHeight+5)*i));
				blockArray[i][j].setBackground(Color.GREEN);
				blockArray[i][j].setVisible(true);
				panel.add(blockArray[i][j]);
			}
		}
		panel.repaint();
		/*...Запускаем мяч...*/
		ballMove.move();
	}
	public static void onCreate() {		//создаёт все элементы игры
/*...Главное окно приложения...*/
		JWindow window = new JWindow();
		window.setSize(500, 400);
		window.setLocation(100, 150);
		window.setBackground(Color.black);
		window.setVisible(true);
		window.setAlwaysOnTop(true);
		
/*...Панель со всеми основными элементами...*/
		panel.setSize((window.getWidth()-20), (window.getHeight()-60));
		panel.setLocation(10, 50);
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		window.add(panel);
		panel.addMouseMotionListener(new moveStick());
		
/*...Кнопка закрытия программы...*/
		JButton closeB = new JButton();
		closeB.setSize(40, 40);
		closeB.setLocation((window.getWidth()-closeB.getWidth()), 0);
		closeB.setBackground(Color.red);
		closeB.setText("x");
		closeB.setFont(new Font("cl", Font.BOLD, 10));
		closeB.setVisible(true);
		window.add(closeB);
		closeB.addMouseListener(new closeWindow());
		
/*...Меню...*/
		JButton menuB = new JButton();
		menuB.setSize(60, 30);
		menuB.setLocation(0, 0);
		menuB.setBackground(Color.BLUE);
		menuB.setVisible(true);
		window.add(menuB);
		
/*...Доска от которой отбивается мяч...*/
		stick.setSize(70, 10);
		stick.setLocation((panel.getWidth()/2), (panel.getHeight()-20));
		stick.setBackground(Color.BLACK);
		stick.setVisible(true);
		panel.add(stick);
/*...Мячик...*/
		ballImg.setSize(20, 20);
		ballImg.setLocation(50, 50);
		ballImg.setBackground(Color.BLACK);
		ballImg.setVisible(true);
		panel.add(ballImg);
	}
}
