package my.work.service.map;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.map.PersonWithImageCustomSortedMapEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Slf4j
public class PersonWithImageCustomSortedMapService {

    static void main() {
        try (var sessionFactory = getSessionFactory()) {
            insertData(sessionFactory);
            getData(sessionFactory);
        }
    }

    private static void insertData(SessionFactory sessionFactory) {
        try (var session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            getPersons().forEach(person -> {
                session.persist(person);
                log.info("Save person {} {}", person.getFirstName(), person.getLastName());
            });

            session.getTransaction().commit();
        }
    }

    private static void getData(SessionFactory sessionFactory) {
        try (var session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            var person = session
                    .createNativeQuery("SELECT * FROM person_with_image_map_tab ORDER BY id DESC LIMIT 1", PersonWithImageCustomSortedMapEntity.class)
                    .getSingleResult();

            log.info("Load person {}", person);

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PersonWithImageCustomSortedMapEntity.class)
                .buildSessionFactory();
    }

    private static Set<PersonWithImageCustomSortedMapEntity> getPersons() {
        return Set.of(
                PersonWithImageCustomSortedMapEntity.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("johndoe@email.com")
                        .images(
                                new TreeMap<>(
                                        Map.of(
                                                "img1.jpg", "Image 1",
                                                "img2.jpg", "Image 2",
                                                "img3.jpg", "Image 3")))
                        .build());
    }

}
