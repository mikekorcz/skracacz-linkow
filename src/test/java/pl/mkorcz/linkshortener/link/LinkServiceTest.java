package pl.mkorcz.linkshortener.link;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.exceptions.LinkAlreadyExistsException;
import pl.mkorcz.linkshortener.link.exceptions.LinkNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LinkServiceTest {

    private LinkService linkService;

    @BeforeEach
    void setUp() {
        linkService = new LinkServiceImpl();

    }

    @Test
    void shouldSaveAndRetrieveLink() {
        //given
        final LinkDto linkDto = new LinkDto("id", "email", "targetUrl", null, 0);
        //when
        final LinkDto resultLink = linkService.createLink(linkDto);
        final String resultTargetUrl = linkService.gatherLink(linkDto.id());
        //then
        assertEquals(linkDto.id(),resultLink.id());
        assertEquals(linkDto.targetUrl(), resultTargetUrl);
    }

    @Test
    void shouldThrowExceptionIfLinkNotFound() {
        //given
        String notExistingId = "cokolwiek";

        //when then
        assertThrows(LinkNotFoundException.class, () -> linkService.gatherLink(notExistingId));
    }

    @Test
    @DisplayName("Should throw link not found exception when link with same id already added")
    void shouldThrowLinkAlreadyExistsExceptionWhenLinkWithSameIdAlreadyAdded() {
        //given
        String duplicatedId = "id";
        linkService.createLink(new LinkDto(duplicatedId, "emal", "target", null, 0));
        //when //then
        assertThrows(LinkAlreadyExistsException.class, () -> linkService.createLink(new LinkDto(duplicatedId, "another email", "another target", null, 0)));
    }
}