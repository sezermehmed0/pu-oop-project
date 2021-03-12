package Figures;


import java.awt.*;

import Tile.Tile;

public class Knight extends Figure{

    public Knight(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attackDamage = 8;
        this.armor = 3;
        this.healtPoints = 15;
        this.possibleSquresToAttack = 1;
        this.speed = 1;
    
    }

    @Override
    public void paint(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,60,60);
        g.setColor(Color.BLACK);
        g.drawString(" Kn ", x + 25, y + 40);
    }
}
