package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CarDAO implements CarService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Car> index() {
        List<Car> carslist = entityManager.createQuery("from Car", Car.class).getResultList();
        return carslist;
    }

    @Override
    @Transactional
    public List<Car> getCarList(int count) {
        return index().stream().limit(count).toList();
    }
}
