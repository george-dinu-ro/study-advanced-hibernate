package my.work.service.inheritance.single.table;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.inheritance.single.table.CarEntity;
import my.work.entity.inheritance.single.table.TruckEntity;
import my.work.entity.inheritance.single.table.VehicleEntity;
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
                .addAnnotatedClass(VehicleEntity.class)
                .addAnnotatedClass(CarEntity.class)
                .addAnnotatedClass(TruckEntity.class)
                .buildSessionFactory();
    }

    private static Set<VehicleEntity> getEmployees() {
        return Set.of(
                CarEntity.builder()
                        .fuel("GASOLINE")
                        .maxSpeed(220)
                        .build(),
                TruckEntity.builder()
                        .fuel("DIESEL")
                        .maxLoad(5000)
                        .build());
    }

}
