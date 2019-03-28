package animals;

import dal.repository.AnimalRepository;
import dal.util.HibernateSessionFactory;
import enums.Gender;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void dbEntry() {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

        AnimalRepository animalRepository = new AnimalRepository();

        Dog dog = new Dog("Henk", Gender.Female, 0.0);
        Cat cat = new Cat("Truus", Gender.Female, "",0.0);
        session.beginTransaction();
        animalRepository.save(dog);
        animalRepository.save(cat);
        session.getTransaction().commit();
    }
}