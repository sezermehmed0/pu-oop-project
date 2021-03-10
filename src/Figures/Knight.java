package Figures;


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
}
