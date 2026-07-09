package my.work.service;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.PersonWithImageMapEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;
import java.util.Set;

@Slf4j
public class PersonWithImageMapService {

    static void main() {
        try (
                var sessionFactory = getSessionFactory();
                var session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            getPersons()
                    .forEach(person -> {
                        session.persist(person);
                        log.info("Save person {} {}", person.getFirstName(), person.getLastName());
                    });

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PersonWithImageMapEntity.class)
                .buildSessionFactory();
    }

    private static Set<PersonWithImageMapEntity> getPersons() {
        return Set.of(
                PersonWithImageMapEntity.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("johndoe@email.com")
                        .images(Map.of(
                                "img1.jpg", "Image 1",
                                "img2.jpg", "Image 2",
                                "img3.jpg", "Image 3"))
                        .build());
    }

}
