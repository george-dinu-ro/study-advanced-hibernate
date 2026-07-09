package my.work.service;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.PersonWithImageSetEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class PersonWithImageSetService {

    static void main() {
        try (
                var sessionFactory = getSessionFactory();
                var session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            getPersons().forEach(personWithImageSetEntity -> {
                session.persist(personWithImageSetEntity);
                log.info("Save person {} {}", personWithImageSetEntity.getFirstName(), personWithImageSetEntity.getLastName());
            });

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PersonWithImageSetEntity.class)
                .buildSessionFactory();
    }

    private static Set<PersonWithImageSetEntity> getPersons() {
        return Set.of(
                PersonWithImageSetEntity.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("johndoe@email.com")
                        .images(Set.of("img1.jpg", "img2.jpg", "img3.jpg"))
                        .build());
    }

}
