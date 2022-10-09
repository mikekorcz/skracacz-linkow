package pl.mkorcz.linkshortener.link;

import org.springframework.stereotype.Service;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.exceptions.DuplicateLinkException;
import pl.mkorcz.linkshortener.link.exceptions.LinkAlreadyExistsException;
import pl.mkorcz.linkshortener.link.exceptions.LinkNotFoundException;

import java.io.IOException;
import java.util.HashMap;

@Service
public class LinkServiceImpl implements LinkService {

    private final HashMap<String, LinkDto> linkRepository;

    LinkServiceImpl() {
        linkRepository = new HashMap<>();
    }


    @Override
    public LinkDto createLink(final LinkDto toDto) {

        if (linkRepository.containsKey(toDto.id())) {
            throw new LinkAlreadyExistsException(toDto.id());
        } else {
            linkRepository.put(toDto.id(), toDto);
            return toDto;
        }

    }

    @Override
    public String gatherLink(final String id) {
        LinkDto linkDto = linkRepository.get(id);
        if (linkDto == null) {
            throw new LinkNotFoundException(id);
        }
        return linkDto.targetUrl();
    }
}
