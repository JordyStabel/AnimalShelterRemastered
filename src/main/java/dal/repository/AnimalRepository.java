package dal.repository;

import animals.Animal;

public class AnimalRepository extends AbstractRepository {
    @Override
    public Class getDomainClass() {
        return Animal.class;
    }
}
