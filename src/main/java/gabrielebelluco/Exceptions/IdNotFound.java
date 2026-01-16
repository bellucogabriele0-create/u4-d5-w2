package gabrielebelluco.Exceptions;

public class IdNotFound extends Exception {
    public IdNotFound(int id) {
        super("L'id " + id + " non è stato trovato");
    }
}
