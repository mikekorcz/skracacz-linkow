package pl.mkorcz.linkshortener.link;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
class ExpiredLinksServiceImpl implements ExpiredLinksService {


    private final LinkRepository linkRepository;

    @Override
    @Transactional
    public void removeExpiredLinks(final LocalDate currentDate) {
        final List<LinkEntity> expiredLinks =  linkRepository.findLinksBeforeDay(currentDate);
        linkRepository.deleteAll(expiredLinks);
        log.info((long) expiredLinks.size() + " items with the expiration before " + currentDate + " has been deleted.");

    }
}
