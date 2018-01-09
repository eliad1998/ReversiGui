package sample;

import Reversi.Board;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
public class ReversiBoard extends GridPane {
    private GridPane bb = new GridPane();
    private ReversiBoard reversiController = this;
    private Board board;
    private class GuiBoard extends Board {
        /**
         * The constructor of our class.
         * The constructor is private because inner class.
         * @param rows the number of rows
         * @param cols the number of cols
         */
        private GuiBoard(int rows, int cols) {
            super(rows,cols);
        }
        public void show(){
            reversiController.getChildren().clear();
            int height = (int)reversiController.getPrefHeight();
            int width = (int)reversiController.getPrefWidth();
            int cellHeight = height / this.rows;
            int cellWidth = width / this.cols;
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    if (this.get(i,j) == ' ')
                        reversiController.add(new Rectangle(cellWidth, cellHeight, Color.WHITE), j, i);
                    else
                        reversiController.add(new Rectangle(cellWidth, cellHeight, Color.BLACK), j, i);
                }
            }
        }
    }
    public ReversiBoard(int rows, int cols) {
        this.board = new GuiBoard(rows, cols);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiGame.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setController(this);
        try { fxmlLoader.load(); }
        catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    public void draw() {
        this.board.show();
    }
}