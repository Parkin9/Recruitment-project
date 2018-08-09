package pl.parkin9.recruitment_project;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.parkin9.recruitment_project.Controller.IndexController;
import pl.parkin9.recruitment_project.Model.RecordFromTable;
import pl.parkin9.recruitment_project.Service.CastRecordsService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitmentProjectApplicationTests {

    @Autowired
    private IndexController indexController;
    @Autowired
    private CastRecordsService castRecordsService;

///////////////////////////////////////////////////////////////////

    @Test
    public void contextLoads() {

        assertNotNull(indexController);
    }

    @Test
    public void shouldConvertRawTypeListToRecordFromTableTypeList() {

        List rawList = new ArrayList();
        rawList.add(new RecordFromTable());
        rawList.add(new RecordFromTable());

        List<RecordFromTable> castedList = castRecordsService.castRecords(rawList);

        assertThat(castedList.get(0)).isInstanceOf(RecordFromTable.class);
        assertThat(castedList.get(1)).isInstanceOf(RecordFromTable.class);
    }
}
