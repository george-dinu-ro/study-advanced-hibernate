package my.work.entity.inheritance.table.per.clasz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public abstract class TpcVehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_generator")
    @TableGenerator(
            name = "tbl_generator",
            table = "table_generator_tab",
            pkColumnName = "pk_name",
            valueColumnName = "pk_value",
            pkColumnValue = "vehicle_id",
            allocationSize = 1
    )
    private Integer id;

    private String fuel;

}
