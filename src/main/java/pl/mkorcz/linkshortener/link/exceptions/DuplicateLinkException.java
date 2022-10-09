package pl.mkorcz.linkshortener.link.exceptions;

public class DuplicateLinkException extends RuntimeException {

    public DuplicateLinkException(final String id) {
        super("Link for id " + id + " is duplicated");
    }
}
