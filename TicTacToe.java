import javax.swing.*;
import java.awt.*;

public class TicTacToe
{

JButton B1 = new JButton();
JButton B2 = new JButton();
JButton B3 = new JButton();
JButton B4 = new JButton();
JButton B5 = new JButton();
JButton B6 = new JButton();
JButton B7 = new JButton();
JButton B8 = new JButton();
JButton B9 = new JButton();


public static void main(String[] args)
{
 TicTacToe tictactoe = new TicTacToe();
}

public TicTacToe()
{
    JFrame myFrame = new JFrame("Tic-Tac-Toe");
    myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JPanel mainPanel = (JPanel) myFrame.getContentPane();
    mainPanel.setLayout(new GridLayout(3,3,10,10));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    
    B1.setPreferredSize(new Dimension(150,150));
    myFrame.add(B1);
    myFrame.add(B2);
    myFrame.add(B3);
    myFrame.add(B4);
    myFrame.add(B5);
    myFrame.add(B6);
    myFrame.add(B7);
    myFrame.add(B8);
    myFrame.add(B9);

    myFrame.setSize(new Dimension(500, 500));
    myFrame.pack();
    myFrame.setLocationRelativeTo(null);
    myFrame.setVisible(true);
}

}