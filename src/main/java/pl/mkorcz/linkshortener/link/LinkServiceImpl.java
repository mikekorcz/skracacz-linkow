package pl.mkorcz.linkshortener.link;

import io.swagger.v3.oas.models.links.Link;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.exceptions.LinkAlreadyExistsException;
import pl.mkorcz.linkshortener.link.exceptions.LinkNotFoundException;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class LinkServiceImpl implements LinkService {

    private final LinkServiceRepository linkRepository;

    @Override
    public LinkDto createLink(final LinkDto toDto) {

        if (linkRepository.findById(toDto.id()).isPresent()) {
            throw new LinkAlreadyExistsException(toDto.id());
        }
        linkRepository.save(LinkEntity.fromDto(toDto));
        return toDto;
    }

    @Transactional
    @Override
    public String gatherLinkAndIncrementVisits(final String id) {
        final LinkEntity linkEntity = linkRepository.findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id));
        linkEntity.setVisits(linkEntity.getVisits() + 1);

        return linkEntity.getTargetUrl();

    }


}
