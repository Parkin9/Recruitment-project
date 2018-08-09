package pl.parkin9.recruitment_project.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Service.CastRecordsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/*
* I wrote this custom repository class, because a column's name can't be "injected" into a SQL query
* (Spring uses a Prepared Statement). I read about a "Specification", "Querydsl" and "Criteria API"
* to learn how to dynamically build queries. However I think, that a User can't send his own value
* to a server so can't inject SQL commands too, therefore using a simple concatenation is enough
* to keep Database safe from Trolls :).
*/

@Component
public class RecordFromTableRepositoryImpl implements RecordFromTableRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private CastRecordsService castRecordsService;

    @Autowired
    public RecordFromTableRepositoryImpl(CastRecordsService castRecordsService) {
        this.castRecordsService = castRecordsService;
    }

/////////////////////////////////////////////////////////////////////////////////////////

    @Override
    @Transactional
    public List<RecordFromTable> findAllRecordsWithDuplicatedValues(String columnName) {

        String queryString = "SELECT * FROM tabela_testowa AS Field1 " +
                                "WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 " +
                                "WHERE Field1." + columnName + " = Field2." + columnName + " HAVING quantity > 1);";

        Query query = entityManager.createNativeQuery(queryString, RecordFromTable.class);

        List rawRecordsList = query.getResultList();

        List<RecordFromTable> castedRecordsList = castRecordsService.castRecords(rawRecordsList);

        return castedRecordsList;
    }

    @Override
    @Transactional
    public List<RecordFromTable> findAllRecordsWithSingledValues(String columnName) {

        String queryString = "SELECT * FROM tabela_testowa AS Field1 " +
                                "WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 " +
                                "WHERE Field1." + columnName + " = Field2." + columnName + " HAVING quantity = 1);";

        Query query = entityManager.createNativeQuery(queryString, RecordFromTable.class);

        List rawRecordsList = query.getResultList();

        List<RecordFromTable> castedRecordsList = castRecordsService.castRecords(rawRecordsList);

        return castedRecordsList;
    }
}
