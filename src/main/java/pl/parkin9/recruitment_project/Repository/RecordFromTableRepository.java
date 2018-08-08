package pl.parkin9.recruitment_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.parkin9.recruitment_project.Model.RecordFromTable;

import java.util.List;

public interface RecordFromTableRepository extends JpaRepository <RecordFromTable, Long>, RecordFromTableRepositoryCustom {

//    @Query(value = "SELECT rec1 FROM RecordFromTable rec1 WHERE EXISTS (SELECT rec2.id FROM RecordFromTable rec2 WHERE rec1.kolumna1 = rec2.kolumna1 HAVING COUNT(rec1.id) > 1);")
//    List<RecordFromTable> findAllRecordsWithDuplicatedValues(String columnName);
//
//    @Query(value = "SELECT * FROM tabela_testowa AS Field1 WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 WHERE Field1.kolumna1 = Field2.kolumna1 HAVING quantity = 1);", nativeQuery = true)
//    List<RecordFromTable> findAllRecordsWithSingledValues(String columnName);
}
