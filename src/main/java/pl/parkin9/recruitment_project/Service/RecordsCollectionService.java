package pl.parkin9.recruitment_project.Service;

import pl.parkin9.recruitment_project.Model.RecordFromTable;

import java.util.List;
import java.util.Map;

public interface RecordsCollectionService {

    Map<String, List<RecordFromTable>> buildMap(String columnNumber);
}
