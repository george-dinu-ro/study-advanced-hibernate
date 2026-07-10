package my.work.service.inheritance.table.per.clasz;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.inheritance.table.per.clasz.TpcCarEntity;
import my.work.entity.inheritance.table.per.clasz.TpcTruckEntity;
import my.work.entity.inheritance.table.per.clasz.TpcVehicleEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class TablePerClassInheritanceService {

    static void main() {
        try (
                var sessionFactory = getSessionFactory();
                var session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            getVehicles()
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
                .addAnnotatedClass(TpcCarEntity.class)
                .addAnnotatedClass(TpcTruckEntity.class)
                .buildSessionFactory();
    }

    private static Set<TpcVehicleEntity> getVehicles() {
        return Set.of(
                TpcCarEntity.builder()
                        .fuel("GASOLINE")
                        .maxSpeed(220)
                        .build(),
                TpcTruckEntity.builder()
                        .fuel("DIESEL")
                        .maxLoad(5000)
                        .build());
    }

}
