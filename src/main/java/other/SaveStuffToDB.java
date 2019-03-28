package other;

//import dal.repository.AnimalRepository;
import dal.util.HibernateSessionFactory;
import org.hibernate.Session;

public class SaveStuffToDB implements Observer {

    //private AnimalRepository animalRepository = new AnimalRepository();
    private Session session;

    @Override
    public void update(Object object) {
        System.out.println(object.toString());
        //animalRepository.save(object);
        session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        session.save(object);
    }
}
