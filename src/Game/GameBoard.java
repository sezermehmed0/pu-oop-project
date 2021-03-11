package Game;

import javax.swing.*;

public class GameBoard extends JFrame {

    public GameBoard(){

        this.add(new Battlefield());
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
