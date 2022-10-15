package pl.mkorcz.linkshortener.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.mkorcz.linkshortener.dto.LinkDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

record CreateLinkDto(
        @Schema(description = "Identifier/alias to link. Used for redirection", example = "link-alias", required = true)
        @NotBlank
        @Size(min = 1, max = 30, message = "Identyfikator musi zawierać od 1 do 30 znaków")
        String id,
        @NotBlank(message = "Prosze uzupełnić pole")
        @Email
        String email,
        String targetUrl,

        @Future
        LocalDate expirationDate) {

    LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}


