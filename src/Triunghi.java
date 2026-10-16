
/**
 * Reprezintă un triunghi definit prin cele trei laturi.
 */
public class Triunghi extends FormaGeometrica {

    // Lungimile celor trei laturi.
    private final double a;
    private final double b;
    private final double c;

    // Construiește triunghiul și validează lungimile laturilor.
    public Triunghi(double a, double b, double c) {
        super("Triunghi");

        if (a <= 0 || b <= 0 || c <= 0
                || a + b <= c
                || a + c <= b
                || b + c <= a) {
            throw new IllegalArgumentException(
                "Laturile nu formează un triunghi valid."
            );
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Calculează perimetrul ca sumă a celor trei laturi.
    @Override
    public double perimetru() {
        return a + b + c;
    }

    // Calculează aria folosind formula lui Heron.
    @Override
    public double aria() {
        double semiperimetru = perimetru() / 2;

        return Math.sqrt(
            semiperimetru
            * (semiperimetru - a)
            * (semiperimetru - b)
            * (semiperimetru - c)
        );
    }

    // Returnează lungimile celor trei laturi.
    @Override
    public String dimensiuni() {
        return String.format(
            java.util.Locale.US,
            "laturi = %.2f, %.2f, %.2f",
            a, b, c
        );
    }
}
