package my.work.service.embedded;

import lombok.extern.slf4j.Slf4j;
import my.work.entity.embedded.Address;
import my.work.entity.embedded.EmployeeWithAddressEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

@Slf4j
public class EmployeeWithAddressService {

    static void main() {
        try (
                var sessionFactory = getSessionFactory();
                var session = sessionFactory.getCurrentSession()
        ) {
            session.beginTransaction();

            getEmployees()
                    .forEach(employee -> {
                        session.persist(employee);
                        log.info("Save employee {} {}", employee.getFirstName(), employee.getLastName());
                    });

            session.getTransaction().commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeWithAddressEntity.class)
                .buildSessionFactory();
    }

    private static Set<EmployeeWithAddressEntity> getEmployees() {
        return Set.of(
                EmployeeWithAddressEntity.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .address(Address.builder()
                                .street("Unirii")
                                .number(11)
                                .city("Bucharest")
                                .build())
                        .build());
    }

}
