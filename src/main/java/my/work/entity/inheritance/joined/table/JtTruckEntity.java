package my.work.entity.inheritance.joined.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "jt_truck_tab")
@PrimaryKeyJoinColumn(name = "vehicle_id")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class JtTruckEntity extends JtVehicleEntity {

    @Column(name = "max_load")
    private int maxLoad;

}
