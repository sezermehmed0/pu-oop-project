package Figures;

import Tile.Tile;
import java.awt.Color;
import java.awt.Graphics;


public class Elf extends Figure{

    public Elf(int row, int col, Color color) {
        super(row, col);
        this.color = color;
        this.attackDamage = 5;
        this.armor = 1;
        this.healtPoints = 10;
        this.possibleSquresToAttack = 3;
        this.speed = 3;
      
    }

    @Override
    public void paint(Graphics g) {
        int x = this.col * Tile.TILE_SIZE;
        int y = this.row * Tile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 10,y + 20,60,60);
        g.setColor(Color.BLACK);
        g.drawString(" E ", x + 30, y + 50);
    }

		
	}

