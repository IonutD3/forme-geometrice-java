
/**
 * Reprezintă un dreptunghi definit prin lungime și lățime.
 */
public class Dreptunghi extends FormaGeometrica {

    // Dimensiunile dreptunghiului.
    protected final double lungime;
    protected final double latime;

    // Construiește dreptunghiul și verifică dimensiunile.
    public Dreptunghi(double lungime, double latime) {
        super("Dreptunghi");

        if (lungime <= 0 || latime <= 0) {
            throw new IllegalArgumentException(
                "Dimensiunile trebuie să fie pozitive."
            );
        }

        this.lungime = lungime;
        this.latime = latime;
    }

    // Calculează aria dreptunghiului: lungime * lățime.
    @Override
    public double aria() {
        return lungime * latime;
    }

    // Calculează perimetrul dreptunghiului.
    @Override
    public double perimetru() {
        return 2 * (lungime + latime);
    }

    // Returnează lungimea și lățimea dreptunghiului.
    @Override
    public String dimensiuni() {
        return String.format(
            java.util.Locale.US,
            "lungime = %.2f, lățime = %.2f",
            lungime, latime
        );
    }
}
