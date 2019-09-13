package uph.tpsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uph.tpsi.models.CarRegister;

public interface CarRegisterRepository extends JpaRepository<CarRegister, Long>
{

}
