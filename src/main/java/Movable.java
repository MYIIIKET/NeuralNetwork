public interface Movable {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

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
