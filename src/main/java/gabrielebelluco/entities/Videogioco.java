package gabrielebelluco.entities;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataDiGioco;
    private Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, double prezzo) {
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataDiGioco = durataDiGioco;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataDiGioco() {
        return durataDiGioco;
    }

    public Genere getGenere() {
        return genere;
    }
}
