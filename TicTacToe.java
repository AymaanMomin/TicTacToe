import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


class TicTacToe implements ActionListener 
{  
    JFrame myFrame = new JFrame();
    JPanel textPanel = new JPanel();
    JButton[] button = new JButton[9];
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    int spacesFilled = 0;
    Random rand = new Random();
    boolean p1Chance;
    
    // Creating class constructor for creating grid
    TicTacToe() 
    {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 500);
        myFrame.getContentPane();
        myFrame.setTitle("Tic Tac Toe");
        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true);

        
        textfield.setFont(new Font("Roboto", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        

        textPanel.setLayout(new BorderLayout());
        textPanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) 
        {
            button[i] = new JButton();
            buttonPanel.add(button[i]);
            button[i].setFont(new Font("Roboto", Font.BOLD, 120));
            button[i].addActionListener(this);
        }
        
        textPanel.add(textfield);
        myFrame.add(textPanel, BorderLayout.NORTH);
        myFrame.add(buttonPanel);

        startGame();
    }
    

    public void startGame() 
    {
        int chance=rand.nextInt(100);

        if (chance%2 == 0) 
        {
            p1Chance = true;
            textfield.setText("Player X turn");
        } 
        else 
        {
            p1Chance = false;
            textfield.setText("Player O turn");
        }
    }
    
    public void gameOver(String s)
    {
        spacesFilled = 0;
        Object[] option={"Play Again","Exit"};
        int k =JOptionPane.showOptionDialog(myFrame, "Game Over\n"+s,"Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if(k==0)
        {
            myFrame.dispose();
            new TicTacToe();
        }
        else
        {
            myFrame.dispose();
        }
    
    }

    // Creating method for checking winning conditions 
    public void matchCheck() 
    {
        if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) 
        {
            xWins(0, 1, 2);
        }
        else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) 
        {
            xWins(0, 4, 8);
        }
        else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) 
        {
            xWins(0, 3, 6);
        }
        else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) 
        {
            xWins(1, 4, 7);
        }
        else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) 
        {
            xWins(2, 4, 6);
        }
        else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) 
        {
            xWins(2, 5, 8);
        }
       else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) 
       {
            xWins(3, 4, 5);
        }
       else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) 
       {
            xWins(6, 7, 8);
        }
      
        else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) 
        {
            oWins(0, 1, 2);
        }
        else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) 
        {
            oWins(0, 3, 6);
        }
        else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) 
        {
            oWins(0, 4, 8);
        }
        else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) 
        {
            oWins(1, 4, 7);
        }
        else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) 
        {
            oWins(2, 4, 6);
        }
        else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) 
        {
            oWins(2, 5, 8);
        }
        else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) 
        {
            oWins(3, 4, 5);
        } else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) 
        {
            oWins(6, 7, 8);
        }
        else if(spacesFilled == 9) 
        {
            textfield.setText("Draw");
             gameOver("Draw Game");
        }
    }

    public void xWins(int x1, int x2, int x3) 
    {

        for (int i = 0; i < 9; i++) 
        {
            button[i].setEnabled(false);
        }
        textfield.setText("Player X wins");
        gameOver("Player X Wins");
    }


    public void oWins(int x1, int x2, int x3) 
    {

        for (int i = 0; i < 9; i++) 
        {
            button[i].setEnabled(false);
        }
        textfield.setText("Player O Wins");
        gameOver("Player O Wins");
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == button[i]) 
            {
                if (p1Chance) 
                {
                    if (button[i].getText() == "") 
                    {
                        button[i].setText("X");
                        p1Chance = false;
                        textfield.setText("O turn");
                        spacesFilled++;
                        matchCheck();
                    }
                } 
                else 
                {
                    if (button[i].getText() == "") 
                    {
                        button[i].setText("O");
                        p1Chance = true;
                        textfield.setText("X turn");
                        spacesFilled++;
                        matchCheck();
                    }
                }
            }
        }
    }
}