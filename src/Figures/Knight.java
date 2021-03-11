package Figures;


import Tile.Tile;

import java.awt.*;

public class Knight extends Figure {
    public Knight(int row, int col,Color color) {
        super(row, col);
        this.attackDamage = 8;
        this.armor = 3 ;
        this.healthPoints = 15;
        this.attackingSquares = 1;
        this.movementSpeed = 1;
    }

    @Override
    public void paint(Graphics g) {

        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" Kn ", x + 30, y + 40);
    }

    }

