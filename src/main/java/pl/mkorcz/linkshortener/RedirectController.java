package pl.mkorcz.linkshortener;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/s")
class RedirectController {

    @GetMapping(path = "/{id}")
    public void redirectLink(@PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("https://google.com");
    }
}
