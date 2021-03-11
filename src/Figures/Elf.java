package Figures;

import Tile.Tile;
import java.awt.*;

public class Elf extends Figure {
    public Elf(int row, int col, Color color) {
        super(row, col);
        this.attackDamage = 8;
        this.armor = 1;
        this.healthPoints = 10;
        this.attackingSquares = 3;
        this.movementSpeed = 3;


    }

    @Override
    public void paint(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 10,50,50);
        g.setColor(Color.BLACK);
        g.drawString(" E ", x + 30, y + 40);
    }

    }

