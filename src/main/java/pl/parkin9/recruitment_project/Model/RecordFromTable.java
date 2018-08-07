package pl.parkin9.recruitment_project.Model;

import javax.persistence.*;

@Entity(name = "tabela_testowa")
public class RecordFromTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kolumna1")
    private String valueColumn1;

    @Column(name = "kolumna2")
    private String valueColumn2;

    @Column(name = "kolumna3")
    private String valueColumn3;

    @Column(name = "kolumna4")
    private Long valueColumn4;

////////////////////////////////////////////////////////////////////////////////////////////////

    public RecordFromTable() {
    }

    public Long getId() {
        return id;
    }

    public String getValueColumn1() {
        return valueColumn1;
    }

    public void setValueColumn1(String valueColumn1) {
        this.valueColumn1 = valueColumn1;
    }

    public String getValueColumn2() {
        return valueColumn2;
    }

    public void setValueColumn2(String valueColumn2) {
        this.valueColumn2 = valueColumn2;
    }

    public String getValueColumn3() {
        return valueColumn3;
    }

    public void setValueColumn3(String valueColumn3) {
        this.valueColumn3 = valueColumn3;
    }

    public Long getValueColumn4() {
        return valueColumn4;
    }

    public void setValueColumn4(Long valueColumn4) {
        this.valueColumn4 = valueColumn4;
    }

    @Override
    public String toString() {
        return "RecordFromTable{" +
                "id=" + id +
                ", valueColumn1='" + valueColumn1 + '\'' +
                ", valueColumn2='" + valueColumn2 + '\'' +
                ", valueColumn3='" + valueColumn3 + '\'' +
                ", valueColumn4=" + valueColumn4 +
                '}';
    }
}
