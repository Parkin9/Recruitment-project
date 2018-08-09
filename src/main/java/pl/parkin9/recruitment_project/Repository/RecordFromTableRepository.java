package pl.parkin9.recruitment_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.parkin9.recruitment_project.Model.RecordFromTable;

@Repository
public interface RecordFromTableRepository extends JpaRepository <RecordFromTable, Long>, RecordFromTableRepositoryCustom {
}
