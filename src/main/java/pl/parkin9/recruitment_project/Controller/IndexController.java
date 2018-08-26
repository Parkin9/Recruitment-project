package pl.parkin9.recruitment_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Repository.RecordFromTableRepository;
import pl.parkin9.recruitment_project.Service.CastRecordsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    private final RecordFromTableRepository recordFromTableRepository;
    private CastRecordsService castRecordsService;


    @Autowired
    public IndexController(RecordFromTableRepository recordFromTableRepository, CastRecordsService castRecordsService) {
        this.recordFromTableRepository = recordFromTableRepository;
        this.castRecordsService = castRecordsService;
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

        // Getting 2 raw Lists of Records from Database
        List duplicatesRawList = recordFromTableRepository.findAllRecordsWithDuplicatedValues(columnName);
        List singlesRawList = recordFromTableRepository.findAllRecordsWithSingledValues(columnName);

        // Casting raw Lists to RecordFromTable type
        List<RecordFromTable> duplicatesCastList = castRecordsService.castRecords(duplicatesRawList);
        List<RecordFromTable> singlesCastList = castRecordsService.castRecords(singlesRawList);

        // Preparing a List to send as response. It contains above Lists
        List<List<RecordFromTable>> recordsList = new ArrayList<>();
        recordsList.add(duplicatesCastList);
        recordsList.add(singlesCastList);

        return recordsList;
    }
}
