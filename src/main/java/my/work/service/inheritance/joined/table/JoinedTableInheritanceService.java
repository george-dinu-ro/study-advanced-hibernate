package my.work.service.inheritance.joined.table;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.inheritance.joined.table.JtCarEntity;
import my.work.entity.inheritance.joined.table.JtTruckEntity;
import my.work.entity.inheritance.joined.table.JtVehicleEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class JoinedTableInheritanceService {

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
                .addAnnotatedClass(JtVehicleEntity.class)
                .addAnnotatedClass(JtCarEntity.class)
                .addAnnotatedClass(JtTruckEntity.class)
                .buildSessionFactory();
    }

    private static Set<JtVehicleEntity> getVehicles() {
        return Set.of(
                JtCarEntity.builder()
                        .fuel("GASOLINE")
                        .maxSpeed(220)
                        .build(),
                JtTruckEntity.builder()
                        .fuel("DIESEL")
                        .maxLoad(5000)
                        .build());
    }

}
