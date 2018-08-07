package pl.parkin9.recruitment_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Service.RecordsCollectionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @ResponseBody
    public List<List<RecordFromTable>> postIndex(HttpServletRequest request) {

        String columnName = request.getParameter("columnName");

        return recordsCollectionService.buildRecordsList(columnName);
    }
}
