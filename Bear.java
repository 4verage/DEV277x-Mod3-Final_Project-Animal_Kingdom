import java.awt.*;

public class Bear extends Critter {
    private boolean polar = false;
    private String move = "/";

    public Bear(boolean polar) {
        this.polar = polar;
    }

    // always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) { return Action.INFECT; }
        else if (info.getFront() == Neighbor.EMPTY) { return Action.HOP; }
        else { return Action.LEFT; }
    }

    // Color.WHITE for a polar bear (when polar is true), Color.BLACK otherwise (when polar is false)
    public Color getColor() {
        if (this.polar) { return Color.WHITE; }
        else { return Color.BLACK; }
    }

    // Should alternate on each different move between a slash character (/) and a backslash character () starting
    // with a slash.
    public String toString() {
        String myChar = this.move;
        if (this.move.equals("/")) { this.move = "\\"; }
        else { this.move = "/"; }
        return myChar;
    }
}
