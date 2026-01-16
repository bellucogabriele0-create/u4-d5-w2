package gabrielebelluco.entities;

public class GiochiDaTavolo extends Gioco {
    private int NumeroDiGiocatori;
    private int DurataMediaDiUnaPartita;

    public GiochiDaTavolo(int DurataMediaDiUnaPartita, int NumeroDiGiocatori, int id, String titolo, int annoPubblicazione, double prezzo) {
        super(id, titolo, annoPubblicazione, prezzo);
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
        return super.toString() + " GiochiDaTavolo{" +
                "NumeroDiGiocatori=" + NumeroDiGiocatori +
                ", DurataMediaDiUnaPartita=" + DurataMediaDiUnaPartita +
                '}';
    }
}
