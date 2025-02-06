import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe {
    int boardLength = 600 ; 
    int boardHeight  = 650  ; 
    //additional 50 for text 

    JFrame frame = new JFrame();
    TicTacToe(){
    frame.setVisible(true);
    frame.setSize(boardLength, boardHeight);
    }
}
