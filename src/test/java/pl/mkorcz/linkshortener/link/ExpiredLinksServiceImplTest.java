package pl.mkorcz.linkshortener.link;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ExpiredLinksServiceImplTest {

    @Mock
    LinkRepository linkRepository;

    @InjectMocks
    ExpiredLinksServiceImpl expiredLinksServiceImpl;


//    @BeforeEach
//    void setUp() {
//        repository = new LinkInMemoryRepository();
//        expiredLinksService = new ExpiredLinksServiceImpl(repository) {
//        };
//    }

    private static final LinkEntity.LinkEntityBuilder LINK_ENTITY_BUILDER = LinkEntity.builder()
            .email("email@email.com")
            .targetUrl("http://google.com")
            .visits(0);

    @Test
    void shouldRemoveExpiredLinks() {

        //given
        final LocalDate today = LocalDate.of(2022, 1, 1);
        LinkEntity expiredLink1 = LINK_ENTITY_BUILDER.id("id1").expirationDate(today.minusDays(20)).build();
        LinkEntity expiredLink2 = LINK_ENTITY_BUILDER.id("id2").expirationDate(today.minusDays(50)).build();
        LinkEntity expiredLink3 = LINK_ENTITY_BUILDER.id("id3").expirationDate(today.minusDays(1800)).build();
        List<LinkEntity> expiredLinks = List.of(expiredLink1, expiredLink2, expiredLink3);
        given(linkRepository.findLinksBeforeDay(today)).willReturn(expiredLinks);

        //when
        expiredLinksServiceImpl.removeExpiredLinks(today);

        //then
        then(linkRepository).should().deleteAll(expiredLinks);
    }

    @Test
    void shouldNotRemoveUnexpiredLinks() {
//        LinkRepository repository = mock(LinkRepository.class);
//        ExpiredLinksService service = new ExpiredLinksServiceImpl(repository);

        final LocalDate today = LocalDate.of(2022, 1, 1);
        final List<LinkEntity> nonExpiredLinks = List.of();
        given(linkRepository.findLinksBeforeDay(today)).willReturn(nonExpiredLinks);

        //when
        expiredLinksServiceImpl.removeExpiredLinks(today);
//        service.removeExpiredLinks(today);

        //then
        then(linkRepository).should().deleteAll(nonExpiredLinks);


    }
}