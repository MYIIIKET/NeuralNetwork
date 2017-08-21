package Objects;

public interface Movable {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    void moveForward();

    void rotateClockwise();

    void rotateCounterClockwise();

    default void moveUpLeft() {
        moveUp();
        moveLeft();
    }

    default void moveUpRight() {
        moveUp();
        moveRight();
    }

    default void moveDownRight() {
        moveDown();
        moveRight();
    }

    default void moveDownLeft() {
        moveDown();
        moveLeft();
    }
}
