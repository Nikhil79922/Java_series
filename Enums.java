
public class Enums {

    public static void main(String[] args) {
        Direction mySide = Direction.EAST;
        Direction otherSide = Direction.NORTH;
        System.out.println(mySide.getDegree() + " " + otherSide.getDegree());
        mySide.move();
    }
}

enum Direction {
    NORTH(0) {
        @Override
        void move() {
            System.out.println("Move y + 1");
        }
    },
    SOUTH(90) {
        @Override
        void move() {
            System.out.println("Move y - 1");
        }
    },
    EAST(180) {
        @Override
        void move() {
            System.out.println("Move x + 1");
        }
    },
    WEST(270) {
        @Override
        void move() {
            System.out.println("Move x - 1");
        }
    };

    private int degree;

    Direction(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    abstract void move();
};
