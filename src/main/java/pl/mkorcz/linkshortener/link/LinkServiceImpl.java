package pl.mkorcz.linkshortener.link;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.exceptions.LinkAlreadyExistsException;
import pl.mkorcz.linkshortener.link.exceptions.LinkNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

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

    @Override
    public List<LinkDto> getLinksFromHigherThan(final Integer visits) {
        return linkRepository.findAllByVisitsGreaterThan(visits)
                .stream()
                .map(LinkEntity::toDto)
                .collect(Collectors.toList());
    }
}
