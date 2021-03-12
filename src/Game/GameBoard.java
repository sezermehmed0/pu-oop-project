package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import Figure.Dwarf;
import Figure.Elf;
import Figure.Figure;
import Figure.Knight;
import Player.Player;
import Player.TerritoryA;
import Player.TerritoryB;
import Tile.Tile;



@SuppressWarnings("serial")
public class GameBoard extends JFrame implements MouseListener {

    public static Player playerA = new Player(1, true,0);
    public static Player PlayerB = new Player(2, false,0);

    public static int randNumX;
    public static int randNumY;
    public static Random rand = new Random();
    public Object[][] tileContainer;
    public Object[][] figureContainer;
    public Object chosenFigure;
    public static int oldRowCoordinate;
    public static int oldColCoordinate;
    

    

    public GameBoard() {
        
        this.setSize(1000, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addMouseListener(this);
        this.tileContainer = new Object[7][9];
        this.figureContainer = new Object[7][9];
        fillPlayerATile();
        fillPlayerBTile();
        fillBattleField();
        renderPlayerAKnight();
        renderPlayerAElf();
        renderPlayerADwarf();
        renderPlayerBKnight();
        renderPlayerBElf();
        renderPlayerBDwarf();
        
       
        
      

    }

          
     /**
      * Method,for mouse controller
      */
    @Override
    public void mouseClicked(MouseEvent e) {
    	
        int rowY = this.getDimensionCoordinates(e.getY());
        int colX = this.getDimensionCoordinates(e.getX());
       

        if (this.isThereRenderedFigure(rowY, colX) && this.chosenFigure == null) {
            Figure figure = (Figure) figureContainer[rowY][colX];
            if (PlayerB.isActive) {
                if (figure.getColor() == Color.red) {
                    this.chosenFigure = this.getFigure(rowY, colX);
                    oldRowCoordinate = rowY;
                    oldColCoordinate = colX;
                    JOptionPane.showMessageDialog(null, "Figure is succesfully selected!");
                    playerA.isActive = false;
                    PlayerB.isActive = true;
                  
                } else {
                    JOptionPane.showMessageDialog(null, "It's red figures turn ");
                    chosenFigure = null;
                }
            } else if (playerA.isActive) {
                if (figure.getColor() == Color.green) {
                    this.chosenFigure = this.getFigure(rowY, colX);
                    oldRowCoordinate = rowY;
                    oldColCoordinate = colX;
                    JOptionPane.showMessageDialog(null, "Figure is succesfully selected");
                    playerA.isActive = false;
                    PlayerB.isActive = true;
                } else {
                    JOptionPane.showMessageDialog(null, "It's green figures turn ");
                          
                    chosenFigure = null; 
                }
            }
        } else  (this.chosenFigure != null && !isThereRenderedFigure(rowY, colX)) {
            menu(rowY, colX);

        } 

        } 
       
           
  

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


   
    /**
     * Method,which paints game board
     */
    
    @Override
    public void paint(Graphics g) {

        for(int row = 0; row < 7; row++) {
            for(int col = 0; col < 9; col++) {

                this.renderTiles(g,row,col);
                this.renderFigures(g, row, col);
               
            }
        }
    }

    /**
     * Method,which gets figure from type object
     * @param row row
     * @param col column
     * @return figureContainer
     */
     
    public Object getFigure(int row, int col) {
        return this.figureContainer[row][col];
    }

    /**
     * Method,which checks for rendered figure on the board
     * @param row row
     * @param col column
     * @return figure
     */
   
    public boolean isThereRenderedFigure(int row, int col) {
        return this.getFigure(row, col) != null;
    }

   /**
    * Method, which gets tile from type object
    * @param row row
    * @param col column
    * @return tileContainer
    */
    public Object getTile(int row, int col) {
        return this.tileContainer[row][col];
    }

 /**
  * Method,which checks for occupied tile
  * @param row row
  * @param col column
  * @return tileContainer
  */
    public boolean isThereTile(int row, int col) {
        return this.tileContainer[row][col] != null;
    }

    /**
     * Method,which fills playerA's territory
     */
    public void fillPlayerATile() {

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 9; col++) {
                this.tileContainer[row][col] = (new TerritoryA(row,col));
            }
        }
    }
    
    /**
     * Method, which fills battlefield tile
     */
    public void fillBattleField() {

        for (int row = 2; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                this.tileContainer[row][col] = (new Battlefield(row,col));
            }
        }
    }
    
    /**
     * Method, which fills playerB's territory
     */
    public void fillPlayerBTile() {
        for (int row = 5; row <= 6; row++) {
            for (int col = 0; col < 9; col++) {
                this.tileContainer[row][col] = (new TerritoryB(row,col));
            }
        }
}
        



    
    /**
     *  Method,which renders playerA's knight figures
     */
    public void renderPlayerAKnight() {

        for(int i = 0; i < 2; i++) {
        	 randNumX = rand.nextInt(2);
             randNumY = rand.nextInt(9);
            if(!this.isThereRenderedFigure(randNumX, randNumY)) {
                this.figureContainer[randNumX][randNumY] =
                        (new Knight(randNumX, randNumY, Color.red));
            } else i--;
        }
    }
    
    /**
     * Method,which renders playerA's elf figures
     */
    public void renderPlayerAElf() {

        for(int i = 0; i < 2; i++) {
        	 randNumX = rand.nextInt(2);
             randNumY = rand.nextInt(9);
            if(!this.isThereRenderedFigure(randNumX, randNumY)) {
                this.figureContainer[randNumX][randNumY] =
                        (new Elf(randNumX, randNumY, Color.red));
            } else i--;
        }
    }
    
    /**
     * Method,which renders playerA's dwarf figures
     */
     public void renderPlayerADwarf() {
        for(int i = 0; i < 2; i++) {
        	 randNumX = rand.nextInt(2);
             randNumY = rand.nextInt(9);
            if(!this.isThereRenderedFigure(randNumX, randNumY)) {
                this.figureContainer[randNumX][randNumY] =
                        (new Dwarf(randNumX, randNumY, Color.red));
            } else i--;
        }
     }
   

    /**
     * Method,which renders playerB's knight figures
     */
    public void renderPlayerBKnight() {

        for(int i = 0; i < 2; i++) {
        	 randNumX = rand.nextInt(7);
             randNumY = rand.nextInt(9);
             while (randNumX != 5 && randNumX != 6 ) {
                 randNumX = rand.nextInt(7);
                 randNumY = rand.nextInt(9);
             }
            if(!this.isThereRenderedFigure(randNumX, randNumY)) {
                this.figureContainer[randNumX][randNumY] =
                        (new Knight(randNumX, randNumY, Color.green));
            } else i--;
        }
    }
    
    /**
     * Method, which renders playerB's elf figures
     */
     public void renderPlayerBElf() {
        for(int i = 0; i < 2; i++) {
        	 randNumX = rand.nextInt(7);
             randNumY = rand.nextInt(9);
             while (randNumX != 5 && randNumX != 6 ) {
                 randNumX = rand.nextInt(7);
                 randNumY = rand.nextInt(9);
             }
            if(!this.isThereRenderedFigure(randNumX, randNumY)) {
                this.figureContainer[randNumX][randNumY] =
                        (new Elf(randNumX, randNumY, Color.green));
            } else i--;
        }
     }
     /*
      * Method,which renders playerB's dwarf figures
      */
     
     public void renderPlayerBDwarf() {

        for(int i = 0; i < 2; i++) {
        	 randNumX = rand.nextInt(7);
             randNumY = rand.nextInt(9);
             while (randNumX != 5 && randNumX != 6 ) {
                 randNumX = rand.nextInt(7);
                 randNumY = rand.nextInt(9);
             }
            if(!this.isThereRenderedFigure(randNumX, randNumY)) {
                this.figureContainer[randNumX][randNumY] =
                        (new Dwarf(randNumX, randNumY, Color.green));
            } else i--;
        }
    }
     
   

    /**
     * Method,which creates action menu
     */
     public void menu(int row, int col) {
    	    
         JFrame frame = new JFrame("Choose Action");
         JLabel jlabel = new JLabel("ACTIONS");
         jlabel.setBounds(150,10,100,60);
         JButton attackBtn = new JButton("Attack");
         attackBtn.setBounds(35,100,95,30);
         attackBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
             
         });
        JButton moveBtn = new JButton("Move");
        moveBtn.setBounds(120,100,95,30);
        moveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (figureContainer[row][col] instanceof Figure ) {
                    JOptionPane.showMessageDialog(null, "Move denied!");
                    frame.dispose();
                } 
                else {
                    moveFigure(row, col);
                    frame.dispose();
                }
            }
        }
        );
      
        frame.add(moveBtn);
        frame.getContentPane().add(jlabel);
        frame.setSize(350,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    /**
     * Method,which moves the figures
     */
    public void moveFigure(int row, int col) {
        if (this.chosenFigure instanceof Knight) {
            knightMovements(row, col);
        } else if (this.chosenFigure instanceof Dwarf) {
            dwarfMovemnets(row, col);
        } else if (this.chosenFigure instanceof Elf) {
            elfMovements(row, col);
        }
    }
    /**
     * Method, which moves knight
     * @param row row 
     * @param col column
     */

    public void knightMovements(int row, int col) {
        if (row == oldRowCoordinate + 1 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate + 1 ||
        row == oldRowCoordinate - 1 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate - 1) {
            Figure fiugre = (Figure) this.chosenFigure;
            fiugre.move(row, col);
            refreshBoard(row, col);
        } else {
            JOptionPane.showMessageDialog(null, "Unavailable move","EROR", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * Method,which moves dwarf
     * @param row row
     * @param col column
     */

    public void dwarfMovemnets(int row, int col) {
        if (row == oldRowCoordinate + 1 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate + 1 ||
        row == oldRowCoordinate - 1 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate - 1 ||
        row == oldRowCoordinate + 2 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate + 2 ||
        row == oldRowCoordinate - 2 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate - 2 ||
        row == oldRowCoordinate + 1 && col == oldColCoordinate + 1 || row == oldRowCoordinate - 1 && col == oldColCoordinate - 1 ||
        row == oldRowCoordinate + 1 && col == oldColCoordinate - 1 || row == oldRowCoordinate - 1 && col == oldColCoordinate + 1)  {
            Figure figure = (Figure) this.chosenFigure;
            figure.move(row, col);
            refreshBoard(row, col);
        }  else {
            JOptionPane.showMessageDialog(null, "Unavailable move","EROR", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Method, which moves elf
     * @param row
     * @param col
     */

    public void elfMovements(int row, int col) {
        if (row == oldRowCoordinate + 1 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate + 1 ||
        row == oldRowCoordinate - 1 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate - 1 ||
        row == oldRowCoordinate + 2 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate + 2 ||
        row == oldRowCoordinate - 2 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate - 2 ||
        row == oldRowCoordinate + 1 && col == oldColCoordinate + 1 || row == oldRowCoordinate - 1 && col == oldColCoordinate - 1 ||
        row == oldRowCoordinate + 1 && col == oldColCoordinate - 1 || row == oldRowCoordinate - 1 && col == oldColCoordinate + 1 ||
        row == oldRowCoordinate + 3 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate + 3 ||
        row == oldRowCoordinate - 3 && col == oldColCoordinate || row == oldRowCoordinate && col == oldColCoordinate - 3 ||
        row == oldRowCoordinate + 2 && col == oldColCoordinate + 1 || row == oldRowCoordinate - 2 && col == oldColCoordinate - 1 ||
        row == oldRowCoordinate + 2 && col == oldColCoordinate - 1 || row == oldRowCoordinate - 2 && col == oldColCoordinate + 1 ||
        row == oldRowCoordinate + 1 && col == oldColCoordinate + 2 || row == oldRowCoordinate - 1 && col == oldColCoordinate - 2 ||
        row == oldRowCoordinate + 1 && col == oldColCoordinate - 2 || row == oldRowCoordinate - 1 && col == oldColCoordinate + 2)  {
            Figure figure = (Figure) this.chosenFigure;
            figure.move(row, col);
            refreshBoard(row, col);
        }  else {
            JOptionPane.showMessageDialog(null, "Unavailable move","EROR", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Method, which refreshes the board
     */
    public void refreshBoard(int row, int col) {
        this.figureContainer[row][col] = this.chosenFigure;
        this.figureContainer[oldRowCoordinate][oldColCoordinate] = null;
        this.chosenFigure = null;
        this.repaint();
    }

    public void refreshBoardAfterAttack() {
        this.chosenFigure = null;
        this.repaint();
    }
    
    /**
     * Method,witch gets dimension coordinates
     * @param coordinates dimension coordinates
     * @return coordinates
     */

     private int getDimensionCoordinates(int coordinates) {
         return coordinates / Tile.TILE_SIZE;
     }
    
    
    /**
     * Method,which visualize tiles on the board
     * @param g Object of graphics
     * @param row row
     * @param col column
     */
    
    private void renderTiles(Graphics g, int row, int col) {
        if (this.isThereTile(row, col)) {
            Tile t = (Tile)this.getTile(row, col);
            t.renderTile(g);
        }
    }

    /**
     * Method,which visualize figures on the board
     * @param g Object of graphics
     * @param row row
     * @param col column
     */
     
    private void renderFigures(Graphics g, int row, int col) {

        if(this.isThereRenderedFigure(row,col)) {
            Figure figure = (Figure)this.getFigure(row,col);
            figure.paint(g);
        }
    }

  }


