package pl.parkin9.recruitment_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Repository.RecordFromTableRepository;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    private final RecordFromTableRepository recordFromTableRepository;

    @Autowired
    public IndexController(RecordFromTableRepository recordFromTableRepository) {
        this.recordFromTableRepository = recordFromTableRepository;
    }

//////////////////////////////////////////////////////////////////////////////

    @GetMapping("/home")
    public String getIndex() {

        return "index";
    }

    @PostMapping("/home")
    @ResponseBody
    public List<List<RecordFromTable>> postIndex(HttpServletRequest request) {

        // Parameter from Frontend (name of column)
        String columnName = request.getParameter("columnName");

        // Getting 2 Lists of Records from Database
        List<RecordFromTable> duplicatesList = recordFromTableRepository.findAllRecordsWithDuplicatedValues(columnName);
        List<RecordFromTable> singlesList = recordFromTableRepository.findAllRecordsWithSingledValues(columnName);

        // Preparing a List to send as response. It contains above Lists
        List<List<RecordFromTable>> recordsList = new ArrayList<>();
        recordsList.add(duplicatesList);
        recordsList.add(singlesList);

        return recordsList;
    }
}
