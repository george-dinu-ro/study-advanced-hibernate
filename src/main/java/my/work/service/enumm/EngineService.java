package my.work.service.enumm;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.enumm.EngineEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

import static my.work.entity.enumm.EngineEntity.FuelType;

@Slf4j
public class EngineService {

    static void main() {
        try (
                var sessionFactory = getSessionFactory();
                var session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            getEngines()
                    .forEach(engine -> {
                        session.persist(engine);
                        log.info("Save engine {} {}", engine.getFuel(), engine.getPower());
                    });

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EngineEntity.class)
                .buildSessionFactory();
    }

    private static Set<EngineEntity> getEngines() {
        return Set.of(
                EngineEntity.builder()
                        .fuel(FuelType.DIESEL)
                        .power(1000)
                        .build());
    }

}
