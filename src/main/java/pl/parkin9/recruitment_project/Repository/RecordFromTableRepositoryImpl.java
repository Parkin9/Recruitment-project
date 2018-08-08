package pl.parkin9.recruitment_project.Repository;

import org.springframework.transaction.annotation.Transactional;
import pl.parkin9.recruitment_project.Model.RecordFromTable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class RecordFromTableRepositoryImpl implements RecordFromTableRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<RecordFromTable> findAllRecordsWithDuplicatedValues(String columnName){

        String queryString = "SELECT * FROM tabela_testowa AS Field1 " +
                                "WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 " +
                                "WHERE Field1." + columnName + " = Field2." + columnName + " HAVING quantity > 1);";

        Query query = entityManager.createNativeQuery(queryString);

        List rows = query.getResultList();


        return null;
    }

    @Override
    @Transactional
    public List<RecordFromTable> findAllRecordsWithSingledValues(String columnName) {

        String queryString = "SELECT * FROM tabela_testowa AS Field1 " +
                                "WHERE EXISTS (SELECT COUNT(id) AS quantity FROM tabela_testowa AS Field2 " +
                                "WHERE Field1." + columnName + " = Field2." + columnName + " HAVING quantity = 1);";

        TypedQuery<RecordFromTable> typedQuery = entityManager.createQuery(queryString, RecordFromTable.class);

        return typedQuery.getResultList();
    }
}
