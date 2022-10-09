package pl.mkorcz.linkshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.LinkService;

@RestController
@RequestMapping("/links")
class LinkManageController {

    private final LinkService linkService;

    LinkManageController(final LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public LinkDto createLink(@RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }


}
