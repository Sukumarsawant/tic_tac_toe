//importing some things to make life gud :)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//nowl̥ife is gud





public class TicTacToe {
    
    JLabel xLabel = new JLabel("X : 0");
    JLabel oLabel = new JLabel("O : 0");
    int boardWidth = 600 ;
    int boardHeight = 650 ; //  to display  your beutiful name 


        JFrame frame = new JFrame("Tic Tac Toe") ; //  to display  your beutiful name
        JLabel textLabel = new JLabel("Tic Tac Toe") ;  
        JPanel textPanel = new JPanel() ; // to display the panel
        JPanel boardPanel = new JPanel() ; // to display the board
        JPanel controlPanel = new JPanel() ; // to display rest.


        //buttons 
        JButton restartButton = new JButton("Restart GAME");
        JButton resetCount = new JButton("Reset Count");
        JButton[][] board = new JButton[3][3];
        String playerX = "X";
        String playerO = "O";
        String currentPlayer = playerX; //initial 

        boolean gameOver =false;
        int turns =0 ;
        int x =0 ; 
        int o =0;


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
        frame.add(boardPanel, BorderLayout.CENTER) ;
        
        
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(restartButton);
        controlPanel.add(xLabel);
        controlPanel.add(oLabel);
        controlPanel.add(resetCount);
        controlPanel.setBackground(Color.gray);
        xLabel.setForeground(Color.yellow);
        oLabel.setForeground(Color.yellow);
        xLabel.setFont(new Font("Arial", Font.BOLD, 20));
        oLabel.setFont(new Font("Arial", Font.BOLD, 20));
        oLabel.setBackground(Color.black);
        xLabel.setBackground(Color.black);
        xLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        oLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame.add(controlPanel, BorderLayout.SOUTH);

        
        
        for(int  i =0 ; i<3;++i){
            for(int j=0 ; j<3;++j){
                JButton tile = new JButton();
                board[i][j] = tile ;
                boardPanel.add(tile);

               tile.setForeground(Color.white);
               tile.setBackground(Color.black);
               tile.setFont(new Font("Arial", Font.BOLD, 120));
               tile.setFocusable(false);

               //tile.setText(currentPlayer);
               tile.addActionListener(new ActionListener()
               {
                public void actionPerformed(ActionEvent e){
                    if(gameOver){
                       return;
                    }
                    JButton tile = (JButton) e.getSource();
                    if(tile.getText().equals("")){
                        tile.setText(currentPlayer);
                    turns++;
                    checkWinner();
                    if(!gameOver){
                    tile.setText(currentPlayer);
                    currentPlayer = currentPlayer ==playerX? playerO : playerX;
                    textLabel.setText("PLAYER : "+currentPlayer+"'s TURN");
                    }
                }
                }
               });
               restartButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resetGame();
                }
            });
            resetCount.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  resetCount();
                }
            });
            }
        }

    }
    void checkWinner(){
        
    //horizontal check
        for(int i = 0 ; i<3;++i){
            if(board[i][0].getText() =="") continue;
            if(board [i][0].getText()==board[i][1].getText()&&board[i][1].getText()==board[i][2].getText()){
                for(int k=0 ;k<3 ; ++k){
                   setWinner(board[i][k]);
                }
                for(int k =0  ;k<3;++k){
                    for(int j=0;j<3;++j){
                     if(board[k][j].getText()!=board[i][0].getText()){
                         setLoser(board[k][j]);
                     }
                    }
                 }
                gameOver = true;
                updateWins();
                return;
            }
            
        } 
         //vertical check
         for(int i = 0 ; i<3;++i){
            if(board[0][i].getText() =="") continue;
            if(board [0][i].getText()==board[1][i].getText()&&board[2][i].getText()==board[1][i].getText()){
                for(int k=0 ;k<3 ; ++k){
                   setWinner(board[k][i]);
                }
                for(int k =0  ;k<3;++k){
                    for(int j=0;j<3;++j){
                     if(board[k][j].getText()!=board[0][i].getText()){
                         setLoser(board[k][j]);
                     }
                    }
                 }
                gameOver = true;
                updateWins();
                return;
            }
            
        } 
        //diagonal main
            if(board[0][0].getText()==board[1][1].getText() && board[1][1].getText()==board[2][2].getText() && board[0][0].getText()!=""){
                for(int i=0 ; i<3;++i){
                    setWinner(board[i][i]);
                }
                for(int i =0  ;i<3;++i){
                    for(int j=0;j<3;++j){
                     if(board[i][j].getText()!=board[0][0].getText()){
                         setLoser(board[i][j]);
                     }
                    }
                 }
                gameOver = true;
                updateWins();
                return;
            }
            //anti
            if(board[0][2].getText()==board[1][1].getText() && board[2][0].getText()==board[1][1].getText() && board[0][2].getText()!=""){
                for(int i=0 ; i<3;++i){
                    setWinner(board[i][3-i-1]);
                }
                
                for(int i =0  ;i<3;++i){
                   for(int j=0;j<3;++j){
                    if(board[i][j].getText()!=board[0][2].getText()){
                        setLoser(board[i][j]);
                    }
                   }
                }
                gameOver = true;
                updateWins();
                return;
            }
            if(turns ==9){
               for(int i =0  ;i<3;++i){
                for(int j =0  ;j<3;++j){
                    setTie(board[i][j]);    
                }
               }
               gameOver = true;
               updateWins();
                return;
            }
        
    }
   

    void setWinner(JButton tile){
        tile.setBackground(Color.green);
        tile.setForeground(Color.white);
        textLabel.setText(currentPlayer+" is the Winner");
        
    }
    void setLoser(JButton tile){
        tile.setBackground(Color.black);
        tile.setForeground(Color.red);
        
    }
    void setTie(JButton tile){
        tile.setBackground(Color.black);
        tile.setForeground(Color.red);
        textLabel.setText("It's a Tie");
    }
    void updateWins(){
        if(currentPlayer == playerX){
            x++;
            xLabel.setText("X : "+x);
        }
        else if (currentPlayer == playerO){ 
            o++;
            oLabel.setText("O : "+o);
        }
        
    }
    void resetGame() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j].setText("");
                board[i][j].setBackground(Color.black);
                board[i][j].setForeground(Color.white);
            }
        }
        currentPlayer = playerX;
        gameOver = false;
        turns = 0;
        textLabel.setText("Tic Tac Toe");
    }
    void resetCount(){
        x=0;
        o=0;
        xLabel.setText("X : "+x);
        oLabel.setText("O : "+o);
    }
   
}
