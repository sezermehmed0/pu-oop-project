package Figures;


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
}
