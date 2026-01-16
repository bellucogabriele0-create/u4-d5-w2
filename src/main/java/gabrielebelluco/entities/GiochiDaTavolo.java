package gabrielebelluco.entities;

public class GiochiDaTavolo extends Gioco {
    private int NumeroDiGiocatori;
    private int DurataMediaDiUnaPartita;

    public GiochiDaTavolo(String titolo, int annoPubblicazione, double prezzo) {
        super(titolo, annoPubblicazione, prezzo);
        this.DurataMediaDiUnaPartita = DurataMediaDiUnaPartita;
        this.NumeroDiGiocatori = NumeroDiGiocatori;
    }

    public int getNumeroDiGiocatori() {
        return NumeroDiGiocatori;
    }

    public int getDurataMediaDiUnaPartita() {
        return DurataMediaDiUnaPartita;
    }

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                "NumeroDiGiocatori=" + NumeroDiGiocatori +
                ", DurataMediaDiUnaPartita=" + DurataMediaDiUnaPartita +
                '}';
    }
}
