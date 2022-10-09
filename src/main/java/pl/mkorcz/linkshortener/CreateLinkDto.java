package pl.mkorcz.linkshortener;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

record CreateLinkDto(
        @Schema(description = "Identifier/alias to link. Used for redirection", example = "link-alias", required = true)
        String id,
        String email,
        String targetUrl,
        LocalDate expirationDate) {

    LinkDto toDo() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}


