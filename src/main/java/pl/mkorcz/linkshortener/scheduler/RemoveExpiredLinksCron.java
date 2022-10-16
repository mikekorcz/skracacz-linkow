package pl.mkorcz.linkshortener.scheduler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.mkorcz.linkshortener.link.ExpiredLinksService;
import java.time.LocalDate;

@AllArgsConstructor
@Component
@Slf4j
class RemoveExpiredLinksCron {
    private final ExpiredLinksService expiredLinksService;

    @Scheduled(cron = "${expired.links.cron}")
    void removeExpiredLinks() {
        log.info("Expired links cron job started");
        expiredLinksService.removeExpiredLinks(LocalDate.now());
        log.info("Expired links cron job ended");
    }
}
