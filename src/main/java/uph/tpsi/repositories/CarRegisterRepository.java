package uph.tpsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uph.tpsi.models.CarRegister;

public interface CarRegisterRepository extends JpaRepository<CarRegister, Long>
{
}
