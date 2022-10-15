package pl.mkorcz.linkshortener.link;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.models.links.Link;
import lombok.*;
import pl.mkorcz.linkshortener.dto.LinkDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class LinkEntity {

    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String targetUrl;
    private LocalDate expirationDate;
    private int visits;

    static LinkEntity fromDto(LinkDto linkDto) {
        return new LinkEntity(
                linkDto.id(),
                linkDto.email(),
                linkDto.targetUrl(),
                linkDto.expirationDate(),
                linkDto.visits()
        );
    }

    LinkDto toDto() {
        return new LinkDto(id, email, targetUrl, expirationDate, visits);
    }
}
