package uph.tpsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uph.tpsi.models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>
{
        UserRole findByUserType ( UserRole.UserType usertype );
}
