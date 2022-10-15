package pl.mkorcz.linkshortener.link;

import pl.mkorcz.linkshortener.dto.LinkDto;

public interface LinkService {
    public LinkDto createLink(LinkDto toDto);

    String gatherLinkAndIncrementVisits(String id);
}
