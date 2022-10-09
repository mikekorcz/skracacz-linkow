package pl.mkorcz.linkshortener.link.exceptions;

public class LinkAlreadyExistsException extends RuntimeException {

    public LinkAlreadyExistsException(final String id) {
        super("Link for id " + id + " already exist");
    }
}
