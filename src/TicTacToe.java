//importing some things to make life gud :)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//nowl̥ife is gud


public class TicTacToe {
    int boardWidth = 600 ;
    int boardHeight = 650 ; //  to display  your beutiful name 
    JFrame frame = new JFrame("Tic Tac Toe") ; //  to display  your beutiful name
    TicTacToe(){
        frame.setVisible(true); // to display the canva 
        frame.setSize(boardWidth, boardHeight); // to set size
        frame.setLocationRelativeTo(null); // `to set location
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

}