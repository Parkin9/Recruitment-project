package pl.parkin9.recruitment_project.Repository;

import pl.parkin9.recruitment_project.Model.RecordFromTable;

import java.io.IOException;
import java.util.List;

public interface RecordFromTableRepositoryCustom {

    List<RecordFromTable> findAllRecordsWithDuplicatedValues(String columnName);

    List<RecordFromTable> findAllRecordsWithSingledValues(String columnName);
}
