package uph.tpsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uph.tpsi.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>
{
        List<Car> findAllByUser_Username(String username);
}
