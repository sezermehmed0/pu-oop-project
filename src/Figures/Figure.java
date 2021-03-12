package Figures;
import java.awt.*;

public abstract class Figure {

    protected int row;
    protected int col;
    protected Color color;
    protected int attackDamage;
    protected int armor;
    protected int healtPoints;
    protected int possibleSquresToAttack;
    protected int speed;
 

    public Figure(int row, int col) {
        this.row = row;
        this.col = col;
    }

  
    public abstract void paint(Graphics g);

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getAttack() {
        return attackDamage;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return healtPoints;
    }

    public void setHealth(int health) {
        this.healtPoints = health;
    }

    public int getPossibleAttackSquares() {
        return possibleSquresToAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }
