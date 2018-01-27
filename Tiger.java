import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int colorMove = 0;
    private Color currColor = Color.RED;
    public Tiger() {

    }

    // always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left,
    // otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) { colorMove++; return Action.INFECT; }
        else if ((info.getFront() == Neighbor.WALL) || (info.getRight() == Neighbor.WALL)) { colorMove++; return Action.LEFT; }
        else if (info.getFront() == Neighbor.SAME) { colorMove++; return Action.RIGHT; }
        else { colorMove++; return Action.HOP; }
    }

    // Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves,
    // then randomly picks one of those colors again for the next three moves, then randomly picks another one of
    // those colors for the next three moves, and so on.
    public Color getColor() {
        if (this.colorMove == 3) {
            // Pick random color from: 0 - Color.RED, 1 - Color.GREEN, 2 - Color.BLUE
            Random clrPick = new Random();
            int clrInt = clrPick.nextInt(3);
            if (clrInt == 0) { currColor = Color.RED; }
            else if (clrInt == 1) { currColor = Color.GREEN; }
            else { currColor = Color.BLUE; }
            this.colorMove = 0;
            return currColor;
        } else {
            return currColor;
        }
    }

    // "TGR"
    public String toString() {
        return "TGR";
    }
}
