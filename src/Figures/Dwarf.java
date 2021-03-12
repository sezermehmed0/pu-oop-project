package Figures;

import Tile.Tile;
import java.awt.*;



public class Dwarf extends Figure{

 

	public Dwarf(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attackDamage = 6;
        this.armor = 2;
        this.healtPoints = 12;
        this.possibleSquresToAttack = 2;
        this.speed = 2;
       
    }

    @Override
    public void paint(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 20,60,60);
        g.setColor(Color.BLACK);
        g.drawString(" Dw ", x + 25, y + 50);
    }
}
