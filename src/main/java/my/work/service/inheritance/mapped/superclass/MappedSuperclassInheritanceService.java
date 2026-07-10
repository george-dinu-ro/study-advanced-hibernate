package my.work.service.inheritance.mapped.superclass;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.inheritance.mapped.superclass.MsCarEntity;
import my.work.entity.inheritance.mapped.superclass.MsTruckEntity;
import my.work.entity.inheritance.mapped.superclass.MsVehicleEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class MappedSuperclassInheritanceService {

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
                .addAnnotatedClass(MsCarEntity.class)
                .addAnnotatedClass(MsTruckEntity.class)
                .buildSessionFactory();
    }

    private static Set<MsVehicleEntity> getVehicles() {
        return Set.of(
                MsCarEntity.builder()
                        .fuel("GASOLINE")
                        .maxSpeed(220)
                        .build(),
                MsTruckEntity.builder()
                        .fuel("DIESEL")
                        .maxLoad(5000)
                        .build());
    }

}
