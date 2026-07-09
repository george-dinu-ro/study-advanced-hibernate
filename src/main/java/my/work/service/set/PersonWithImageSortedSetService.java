package my.work.service.set;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.set.PersonWithImageSortedSetEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class PersonWithImageSortedSetService {

    static void main() {
        try (var sessionFactory = getSessionFactory()) {
            insertData(sessionFactory);
            getData(sessionFactory);
        }
    }

    private static void insertData(SessionFactory sessionFactory) {
        try (var session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            getPersons().forEach(personWithImageSetEntity -> {
                session.persist(personWithImageSetEntity);
                log.info("Save person {} {}", personWithImageSetEntity.getFirstName(), personWithImageSetEntity.getLastName());
            });

            session.getTransaction().commit();
        }
    }

    private static void getData(SessionFactory sessionFactory) {
        try (var session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            var person = session
                    .createNativeQuery("SELECT * FROM person_with_image_set_tab ORDER BY id DESC LIMIT 1", PersonWithImageSortedSetEntity.class)
                    .getSingleResult();

            log.info("Load person {}", person);

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PersonWithImageSortedSetEntity.class)
                .buildSessionFactory();
    }

    private static Set<PersonWithImageSortedSetEntity> getPersons() {
        return Set.of(
                PersonWithImageSortedSetEntity.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("johndoe@email.com")
                        .images(Set.of("img1.jpg", "img2.jpg", "img3.jpg"))
                        .build());
    }

}
