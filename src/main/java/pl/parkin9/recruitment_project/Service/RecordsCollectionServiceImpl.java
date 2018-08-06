package pl.parkin9.recruitment_project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Repository.RecordFromTableRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordsCollectionServiceImpl implements RecordsCollectionService {

    private final RecordFromTableRepository recordFromTableRepository;

    @Autowired
    public RecordsCollectionServiceImpl(RecordFromTableRepository recordFromTableRepository) {

        this.recordFromTableRepository = recordFromTableRepository;
    }

////////////////////////////////////////////////////////////////////////////////////

    public Map<String, List<RecordFromTable>> buildMap(String columnNumber) {

        List<RecordFromTable> recordsWithDuplicates = new ArrayList<>(recordFromTableRepository
                                                                    .findAllRecordsWithDuplicatedValues(columnNumber));

        List<RecordFromTable> recordsWithSingles = new ArrayList<>(recordFromTableRepository
                                                                    .findAllRecordsWithSingledValues(columnNumber));

        Map<String, List<RecordFromTable>> recordsMap = new HashMap<>();
        recordsMap.put("recordsWithDuplicates", recordsWithDuplicates);
        recordsMap.put("recoredsWithSingles", recordsWithSingles);

        return recordsMap;
    }
}
