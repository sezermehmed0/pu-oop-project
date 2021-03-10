package Figures;

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
}
