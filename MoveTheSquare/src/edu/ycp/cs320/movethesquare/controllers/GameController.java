package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		checkOutOfBounds(model, square);
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
	}
	
	public void checkOutOfBounds(Game model, Square square){
		double x = square.getX();
		double y = square.getY();
		double dx = model.getSquareDx();
		double dy = model.getSquareDy();
		
		if(x + dx > 0 && x + dx + square.getWidth() < model.getWidth()){
			if(y + dy > 0 && y + dy + square.getHeight() < model.getHeight()){
			}
			else{
				model.setSquareDy(-dy);
				
			}
		}
		else{
			model.setSquareDx(-dx);
		}
	}
}
