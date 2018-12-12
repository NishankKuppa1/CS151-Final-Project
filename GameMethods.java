package master;

import java.awt.Graphics;

public interface GameMethods
{
	 void initializeBoard();
	 void loadImages();
	 void initGame();
	 void paintComponent(Graphics g);
	 void doDrawing(Graphics g);
	 void gameOver(Graphics g);
	 void winGame(Graphics g);
	 void move();
	 void checkCollision();
	
}
