package pl.parkin9.recruitment_project.Service;

import org.springframework.stereotype.Service;
import pl.parkin9.recruitment_project.Model.RecordFromTable;

import java.util.ArrayList;
import java.util.List;

/*
* "castRecords" method casts a Raw-type List from Database to RecordFromTable-type.
*/

@Service
public class CastRecordsServiceImpl implements CastRecordsService {
    
    public List<RecordFromTable> castRecords(List rawRecordsList) {

        // Initialize a empty RecordFromTable-type List.
        List<RecordFromTable> castedRecordsList = new ArrayList<>();

        // Converting elements of a Raw-type List
        for (Object rawRecord : rawRecordsList) {
            castedRecordsList.add((RecordFromTable) rawRecord);
        }
        
        return castedRecordsList;
    }
}
