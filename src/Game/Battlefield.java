package Game;



import java.awt.*;

import Tile.Tile;

public class Battlefield extends Tile {

    public Color color;

    public Battlefield(int row, int col) {
        super(row, col);
        
    }

    @Override
    public void renderTile(Graphics g) {

        int tileX = this.col * Tile.TILE_SIZE;
        int tileY = this.row * Tile.TILE_SIZE;

        if (this.row == 2 || this.row == 3 || this.row == 4) {
            g.setColor(Color.lightGray);
            g.fillRect(tileX,tileY,TILE_SIZE,TILE_SIZE);
            
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
