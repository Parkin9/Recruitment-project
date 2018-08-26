package pl.parkin9.recruitment_project.Repository;

import java.util.List;

public interface RecordFromTableRepositoryCustom {

    List findAllRecordsWithDuplicatedValues(String columnName);

    List findAllRecordsWithSingledValues(String columnName);
}
