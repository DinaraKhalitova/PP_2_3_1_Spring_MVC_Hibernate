package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("KIA CEE'D", 2014, "G4FA"));
        carsList.add(new Car("KIA K5", 2021, "G4NA"));
        carsList.add(new Car("KIA K8", 2021, "G4KN"));
        carsList.add(new Car("KIA STINGER", 2023, "V6"));
        carsList.add(new Car("KIA OPTIMA", 2018, "G4KD"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carsList;
        }
        return carsList.stream().limit(count).collect(Collectors.toList());
    }
}