package my.work.service.inheritance.single.table;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.inheritance.single.table.StCarEntity;
import my.work.entity.inheritance.single.table.StTruckEntity;
import my.work.entity.inheritance.single.table.StVehicleEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class SingleTableInheritanceService {

    static void main() {
        try (
                var sessionFactory = getSessionFactory();
                var session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            getEmployees()
                    .forEach(vehicle -> {
                        session.persist(vehicle);
                        log.info("Save vehicle {}", vehicle.getFuel());
                    });

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StVehicleEntity.class)
                .addAnnotatedClass(StCarEntity.class)
                .addAnnotatedClass(StTruckEntity.class)
                .buildSessionFactory();
    }

    private static Set<StVehicleEntity> getEmployees() {
        return Set.of(
                StCarEntity.builder()
                        .fuel("GASOLINE")
                        .maxSpeed(220)
                        .build(),
                StTruckEntity.builder()
                        .fuel("DIESEL")
                        .maxLoad(5000)
                        .build());
    }

}
