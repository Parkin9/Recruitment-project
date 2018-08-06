package pl.parkin9.recruitment_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.parkin9.recruitment_project.Service.RecordsCollectionService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app")
public class IndexController {

    private final RecordsCollectionService recordsCollectionService;

    @Autowired
    public IndexController(RecordsCollectionService recordsCollectionService) {
        this.recordsCollectionService = recordsCollectionService;
    }

//////////////////////////////////////////////////////////////////////////////

    @GetMapping("/home")
    public String getIndex() {

        return "index";
    }

    @PostMapping("/home")
    public String postIndex(HttpServletRequest request, Model model) {

        String columnNumber = request.getParameter("columnNumber");

        model.addAllAttributes(recordsCollectionService.buildMap(columnNumber));

        return "index";
    }
}
