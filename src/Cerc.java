
/**
 * Reprezintă un cerc și permite calcularea ariei
 * și a perimetrului acestuia.
 */
public class Cerc extends FormaGeometrica {

    // Raza cercului.
    private final double raza;

    // Construiește cercul și verifică dacă raza este pozitivă.
    public Cerc(double raza) {
        super("Cerc");

        if (raza <= 0) {
            throw new IllegalArgumentException(
                "Raza trebuie să fie pozitivă."
            );
        }

        this.raza = raza;
    }

    // Calculează aria cercului: pi * raza * raza.
    @Override
    public double aria() {
        return Math.PI * raza * raza;
    }

    // Calculează perimetrul cercului: 2 * pi * raza.
    @Override
    public double perimetru() {
        return 2 * Math.PI * raza;
    }

    // Returnează raza cercului formatată cu două zecimale.
    @Override
    public String dimensiuni() {
        return String.format(
            java.util.Locale.US, "raza = %.2f", raza
        );
    }
}
