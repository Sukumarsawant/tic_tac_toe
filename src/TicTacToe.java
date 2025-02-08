//importing some things to make life gud :)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//nowl̥ife is gud
import javax.swing.border.Border;

import org.w3c.dom.Text;


public class TicTacToe {
    int boardWidth = 600 ;
    int boardHeight = 650 ; //  to display  your beutiful name 


        JFrame frame = new JFrame("Tic Tac Toe") ; //  to display  your beutiful name
        JLabel textLabel = new JLabel("Tic Tac Toe") ;  
        JPanel textPanel = new JPanel() ; // to display the panel
        JPanel boardPanel = new JPanel() ; // to display the board


        TicTacToe() {
        frame.setVisible(true); // to display the canva 
        frame.setSize(boardWidth, boardHeight); // to set size
        frame.setLocationRelativeTo(null); // `to set location
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.BLACK); 
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Arial", Font.BOLD, 40));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel , BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel, BorderLayout.CENTER);

    }
}
