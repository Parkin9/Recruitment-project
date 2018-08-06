package pl.parkin9.recruitment_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.parkin9.recruitment_project.Model.RecordFromTable;

import java.util.List;

public interface RecordFromTableRepository extends JpaRepository <RecordFromTable, Long> {

    @Query(value = "SELECT * FROM tabela_testowa AS Field1 WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 WHERE Field1.columnNumber = Field2.?1 HAVING quantity > 1);", nativeQuery = true)
    List<RecordFromTable> findAllRecordsWithDuplicatedValues(@Param("columnNumber") String columnNumber);

    @Query(value = "SELECT * FROM tabela_testowa AS Field1 WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 WHERE Field1.?1 = Field2.?1 HAVING quantity = 1);", nativeQuery = true)
    List<RecordFromTable> findAllRecordsWithSingledValues(@Param("columnNumber")String columnNumber);
}
