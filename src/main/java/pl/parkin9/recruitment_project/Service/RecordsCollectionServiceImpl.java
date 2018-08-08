package pl.parkin9.recruitment_project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Repository.RecordFromTableRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordsCollectionServiceImpl implements RecordsCollectionService {

    private final RecordFromTableRepository recordFromTableRepository;

    @Autowired
    public RecordsCollectionServiceImpl(RecordFromTableRepository recordFromTableRepository) {
        this.recordFromTableRepository = recordFromTableRepository;
    }

////////////////////////////////////////////////////////////////////////////////////

    public List<List<RecordFromTable>> buildRecordsList(String columnNumber) {

        List<RecordFromTable> duplicatesList = recordFromTableRepository.findAllRecordsWithDuplicatedValues(columnNumber);
        List<RecordFromTable> singlesList = recordFromTableRepository.findAllRecordsWithSingledValues(columnNumber);

        List<List<RecordFromTable>> recordsList = new ArrayList<>();
        recordsList.add(duplicatesList);
        recordsList.add(singlesList);

        return recordsList;
    }

}
