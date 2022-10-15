package pl.mkorcz.linkshortener.link;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.exceptions.DuplicateLinkException;
import pl.mkorcz.linkshortener.link.exceptions.LinkAlreadyExistsException;
import pl.mkorcz.linkshortener.link.exceptions.LinkNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LinkServiceImpl implements LinkService {

    private LinkServiceRepository linkRepository;

    @Override
    public LinkDto createLink(final LinkDto toDto) {

        if (linkRepository.findById(toDto.id()).isPresent()) {
            throw new LinkAlreadyExistsException(toDto.id());
        }
        linkRepository.save(LinkEntity.fromDto(toDto));
        return toDto;
    }

    @Override
    public String gatherLink(final String id) {
        final LinkEntity linkEntity = linkRepository.findById(id)
                        .orElseThrow(() -> new LinkNotFoundException(id));

        return linkEntity.getTargetUrl();
    }
}
