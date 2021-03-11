package Figures;

import Tile.Tile;
import java.awt.*;

public class Dwarf extends Figure {
    public Dwarf(int row, int col,Color color) {
        super(row, col);
        this.attackDamage = 6;
        this.armor = 2;
        this.healthPoints = 12;
        this.attackingSquares = 2;
        this.movementSpeed = 2;
    }

    @Override
    public void paint(Graphics g){
    int x = this.col * Tile.TILE_SIZE;
    int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" Dw ", x + 30, y + 40);
}
}
