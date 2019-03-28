package dal.repository;

import animals.Dog;

public class DogRepository extends AbstractRepository {
    @Override
    public Class getDomainClass() {
        return Dog.class;
    }
}
