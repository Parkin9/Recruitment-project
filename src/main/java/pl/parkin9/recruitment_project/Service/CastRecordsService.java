package pl.parkin9.recruitment_project.Service;

import pl.parkin9.recruitment_project.Model.RecordFromTable;

import java.util.List;

public interface CastRecordsService {

    List<RecordFromTable> castRecords(List rawRecordsList);
}
