package pl.mkorcz.linkshortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkorcz.linkshortener.link.LinkService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/s")
class RedirectController {

    private final LinkService linkService;

    RedirectController(final LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping(path = "/{id}")
    public void redirectLink(
            @PathVariable String id,
            HttpServletResponse httpServletResponse

    ) throws IOException {
        String targetUrl = linkService.gatherLink(id);
        httpServletResponse.sendRedirect(targetUrl);
    }
}
