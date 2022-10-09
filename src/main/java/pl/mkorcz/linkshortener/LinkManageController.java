package pl.mkorcz.linkshortener;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
class LinkManageController {

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return link.toDo();
    }

//    @GetMapping("/getAll")
//    LinkDto getAllLinks()
}
