import lombok.Data;

@Data
abstract class Person implements Movable {
    private static String name;
}
