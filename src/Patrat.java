
/**
 * Reprezintă un pătrat.
 * Moștenește clasa Dreptunghi și folosește aceeași
 * valoare pentru lungime și lățime.
 */
public class Patrat extends Dreptunghi {

    // Construiește pătratul folosind lungimea laturii.
    public Patrat(double latura) {
        super(latura, latura);
    }

    // Suprascrie numele moștenit de la dreptunghi.
    @Override
    public String nume() {
        return "Pătrat";
    }

    // Returnează lungimea laturii pătratului.
    @Override
    public String dimensiuni() {
        return String.format(
            java.util.Locale.US,
            "latură = %.2f",
            lungime
        );
    }
}
