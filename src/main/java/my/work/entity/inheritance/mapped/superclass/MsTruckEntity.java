package my.work.entity.inheritance.mapped.superclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ms_truck_tab")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class MsTruckEntity extends MsVehicleEntity {

    @Column(name = "max_load")
    private int maxLoad;

}
