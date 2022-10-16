package pl.mkorcz.linkshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.mkorcz.linkshortener.dto.LinkDto;
import pl.mkorcz.linkshortener.link.LinkService;

import javax.validation.Valid;
import java.util.List;

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
    public LinkDto createLink(@Valid @RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/visits/{visits}")
    List<LinkDto> getLinksForVisitsHigherThan(@PathVariable Integer visits) {
        return linkService.getLinksFromHigherThan(visits);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    LinkDto getLinksById(@PathVariable String id) {
        return linkService.getLinkById(id);
    }


}
