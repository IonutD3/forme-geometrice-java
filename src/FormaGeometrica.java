
/**
 * Clasă abstractă ce implementează elementele comune
 * tuturor formelor geometrice.
 */
public abstract class FormaGeometrica implements Forma {

    // Numele formei geometrice.
    protected final String nume;

    // Constructorul inițializează numele formei.
    protected FormaGeometrica(String nume) {
        this.nume = nume;
    }

    // Returnează numele formei geometrice.
    @Override
    public String nume() {
        return nume;
    }
}
