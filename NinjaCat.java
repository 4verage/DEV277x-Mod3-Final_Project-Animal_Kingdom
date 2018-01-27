import java.awt.*;
import java.util.Random;

public class NinjaCat extends Critter {
    public NinjaCat() {

    }
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) { return Action.INFECT; }
        else if ((info.getFront() == Neighbor.WALL) || (info.getFront() == Neighbor.SAME)) {
            Random r = new Random();
            int scan = r.nextInt(2);
            if (scan == 0) {
                return Action.LEFT;
            } else {
                return Action.RIGHT;
            }
        }
         else { return Action.HOP; }
        }

    public Color getColor() {
        return Color.BLACK;
    }

    public String toString() {
     return "^.^";
    }
}
