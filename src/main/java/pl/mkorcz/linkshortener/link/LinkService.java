package pl.mkorcz.linkshortener.link;

import pl.mkorcz.linkshortener.dto.LinkDto;

import java.util.List;

public interface LinkService {
    public LinkDto createLink(LinkDto toDto);

    String gatherLinkAndIncrementVisits(String id);

    List<LinkDto> getLinksFromHigherThan(Integer visits);
}
