package gabrielebelluco.entities;

import gabrielebelluco.Exceptions.IdNotFound;
import gabrielebelluco.Exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collezione {
    List<Gioco> giochi = new ArrayList<>();

    public void addGioco(Gioco gioco) {
        if (giochi.stream().anyMatch(agg -> agg.getId() == gioco.getId())) {
            throw new ValidationException("Errore: il codice ID " + gioco.getId() + " è già presente in collezione.");
        }
        giochi.add(gioco);
        System.out.println("Gioco aggiunto con successo: " + gioco.getTitolo());
    }


    public Gioco ricercaPerId(int id) throws IdNotFound {
        List<Gioco> result = giochi.stream()
                .filter(ricercaID -> ricercaID.getId() == id)
                .collect(Collectors.toList());
        if (result.size() == 0) throw new IdNotFound(id);
        return result.get(0);
    }

    public List<Gioco> ricercaPerPrezzo(double prezzoMax) {
        return giochi.stream()
                .filter(Prezzo -> Prezzo.getPrezzo() < prezzoMax)
                .collect(Collectors.toList());
    }

    public List<GiochiDaTavolo> ricercaNumGioc(int numeroGiocatori) {
        return giochi.stream()
                .filter(ricercaNumGioc -> ricercaNumGioc instanceof GiochiDaTavolo)
                .map(ricercaNumGioc -> (GiochiDaTavolo) ricercaNumGioc)
                .filter(tavolo -> tavolo.getNumeroDiGiocatori() == numeroGiocatori)
                .collect(Collectors.toList());
    }

    public void rimuoviPerId(int id) throws IdNotFound {
        Gioco giocoDaRimuovere = null;
        for (int i = 0; i < giochi.size(); i++) {
            Gioco controllogioco = giochi.get(i);
            if (controllogioco.getId() == id) {
                giocoDaRimuovere = controllogioco;
                break;
            }
        }
        if (giocoDaRimuovere != null) {
            giochi.remove(giocoDaRimuovere);
            System.out.println("gioco rimosso: " + giocoDaRimuovere.getTitolo());
        } else {
            throw new IdNotFound(id);
        }
    }

    public void Statistiche() {
        long numeroVideogiochi = giochi.stream().filter(g -> g instanceof Videogioco).count();
        System.out.println("numero videogiochi: " + numeroVideogiochi);

        long numeroGiochiDaTavolo = giochi.stream().filter(g -> g instanceof GiochiDaTavolo).count();
        System.out.println("numero giochi da tavolo: " + numeroGiochiDaTavolo);
        double mediaPrezzi = giochi.stream().mapToDouble(med -> med.getPrezzo()).average().orElse(0.0);
        System.out.println("media prezzi: " + mediaPrezzi);
    }

}


