package pl.mkorcz.linkshortener.link.exceptions;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(final String id) {
        super("Link for id " + id + " not found");
    }
}
