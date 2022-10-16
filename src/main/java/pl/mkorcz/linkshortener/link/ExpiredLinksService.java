package pl.mkorcz.linkshortener.link;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ExpiredLinksService {
    void removeExpiredLinks(LocalDate now);
}
