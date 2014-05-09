package asteroids.estrategies;


/**
 * This class is stateless, so i made it singleton.
 */
public class JustExplode implements ExplodeStrategy {

    private static JustExplode ourInstance = new JustExplode();

    public static JustExplode getInstance() {
        return ourInstance;
    }

    private JustExplode() {
    }

    @Override
    public void explode(Exploitable exploitable) {
        // Do nothing :)
    }
}
