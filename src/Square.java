import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private TicTacToeViewer view;
    private final int BOARD_WIDTH = 600;
    private final int BOARD_HEIGHT = 600;
    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private Image Omarker;
    private Image Xmarker;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer view) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        Omarker = new ImageIcon("Resources/O.png").getImage();
        Xmarker = new ImageIcon("Resources/X.png").getImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g)
    {
        int x = 200 + (col + 1) * BOARD_WIDTH / 3;
        int y = 100 + (row + 1) * BOARD_HEIGHT / 3;
        if (isWinningSquare)
        {
            g.setColor(Color.green);
            g.fillRect(x, y, BOARD_WIDTH / 3,
                    BOARD_HEIGHT / 3);
        }
        g.setColor(Color.black);
        g.drawRect(x, y, BOARD_WIDTH / 3,
                BOARD_HEIGHT / 3);
        if (marker.equals(TicTacToe.O_MARKER))
        {
            g.drawImage(Omarker, x, y, BOARD_WIDTH / 3, BOARD_HEIGHT / 3, view);
        }
        else if (marker.equals(TicTacToe.X_MARKER))
        {
            g.drawImage(Xmarker, x, y, BOARD_WIDTH / 3, BOARD_HEIGHT / 3, view);
        }
    }
}
