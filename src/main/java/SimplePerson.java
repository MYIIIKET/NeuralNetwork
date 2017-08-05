import lombok.Getter;

@Getter
public class SimplePerson extends Person {
    private int xPos;
    private int yPos;

    public void moveTo(int x, int y) {
        //TODO: implement moving algorithm
        throw new UnsupportedOperationException();
    }

    public void setPosition(int x, int y) {
        xPos = x;
        yPos = y;
    }
}
