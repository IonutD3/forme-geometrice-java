
/**
 * Interfața comună pentru toate formele geometrice.
 * Fiecare formă trebuie să calculeze aria, perimetrul,
 * să ofere dimensiunile și să returneze numele său.
 */
public interface Forma {

    // Calculează și returnează aria formei geometrice.
    double aria();

    // Calculează și returnează perimetrul formei geometrice.
    double perimetru();

    // Returnează dimensiunile formei sub formă de text.
    String dimensiuni();

    // Returnează numele formei geometrice.
    String nume();
}
