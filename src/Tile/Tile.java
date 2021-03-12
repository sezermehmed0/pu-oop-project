package Tile;
import java.awt.*;

public abstract class Tile {

    protected int row;
    protected int col;
    public static final int TILE_SIZE = 90;
 

    /**
     * 
     * @param row row
     * @param col column
     */
     
     
    public Tile (int row, int col) {

        this.row = row;
        this.col = col;
    }
          
   public abstract void renderTile(Graphics g);
 
}
