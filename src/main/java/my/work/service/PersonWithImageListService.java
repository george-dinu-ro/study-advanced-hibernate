package my.work.service;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.PersonWithImageListEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

@Slf4j
public class PersonWithImageListService {

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
                .addAnnotatedClass(PersonWithImageListEntity.class)
                .buildSessionFactory();
    }

    private static Set<PersonWithImageListEntity> getPersons() {
        return Set.of(
                PersonWithImageListEntity.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("johndoe@email.com")
                        .images(List.of("img1.jpg", "img2.jpg", "img3.jpg"))
                        .build());
    }

}
