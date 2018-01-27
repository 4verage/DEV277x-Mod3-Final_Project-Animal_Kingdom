import java.awt.*;

public class Giant extends Critter {
    private double moves = 0;

    public Giant() {

    }
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) { return Action.INFECT; }
        else if (info.getFront() == Neighbor.EMPTY) { return Action.HOP; }
        else { return Action.RIGHT; }
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        incMove();
        if ((this.moves / 6) <= 1) { return "fee"; }
        else if (((this.moves / 6) > 1) && ((this.moves / 6) <= 2)) { return "fie"; }
        else if (((this.moves / 6) > 2) && ((this.moves / 6) <= 3)) { return "foe"; }
        else if (((this.moves / 6) > 3) && ((this.moves / 6) <= 4)) { return "fum"; }
        else { throw new IllegalArgumentException(); }
    }

    public void incMove() {
        if ((this.moves / 6) >= 4) { this.moves = 1; }
        else { this.moves++; }
    }
}
