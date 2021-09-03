package assignments.A01_Hunt;

public class Rabbit extends Animal {

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }
    
    int decideMove() {
        boolean seenFox = false;
        int distanceToFox, dirToFox = 0;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.RABBIT) {
                distanceToFox = distance(i);
                dirToFox = i;
                seenFox = true;
            }
        }

        if (seenFox) {
            return Model.turn(dirToFox, 4);
        }



      return Model.STAY;
    }
}
