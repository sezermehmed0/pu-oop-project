package Figures;

public abstract class Figure  {
    protected int row;
    protected int col;
    protected Color color;
    protected int attackDamage;
    protected int armor;
    protected int healthPoints;
    protected int attackingSquares;
    protected int movementSpeed;


    public Figure(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public abstract void drawFigure(Graphics g);

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
        return healthPoints;
    }

    public void setHealth(int health) {
        this.healthPoints = health;
    }

    public int getAttackingSquares() {
        return attackingSquares;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public Color getColor() {
        return color;
    }
}
