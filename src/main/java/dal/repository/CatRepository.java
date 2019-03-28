package dal.repository;

import animals.Cat;

public class CatRepository extends AbstractRepository {
    @Override
    public Class getDomainClass() {
        return Cat.class;
    }
}
