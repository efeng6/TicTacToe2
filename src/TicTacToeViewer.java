import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class

    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    private Square[][] board;

    private TicTacToe t;
    private Image[] markers;
    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        board = t.getBoard();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);

    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j].draw(g);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 50));
        g.drawString("0", 300, 80);
        g.drawString("1", 500, 80);
        g.drawString("2", 700, 80);

        g.drawString("0", 150, 200);
        g.drawString("1", 150, 400);
        g.drawString("2", 150, 600);

        if (t.getGameOver())
        {
            if (t.checkTie())
            {
                g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 100));
                g.drawString("Tie!", 400, 800);
            }
            else if (t.getWinner().equals(t.O_MARKER))
            {
                g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 100));
                g.drawString("O Wins!", 300, 800);
            }
            else if (t.getWinner().equals(t.X_MARKER))
            {
                g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 100));
                g.drawString("X Wins!", 300, 800);
            }
        }

    }

}
