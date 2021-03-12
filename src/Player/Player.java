package Player;

public class Player {

    int id;
    public boolean isActive;
    int figuresLost;

    public Player(int id,boolean isActive, int figuresLost) {
    	 this.id = id;
        this.isActive = isActive;
        this.figuresLost = figuresLost;
    }


    public int getFiguresLost() {
        return figuresLost;
    }

    public void setFiguresLost(int figuresLost) {
        this.figuresLost = figuresLost;
    }
}