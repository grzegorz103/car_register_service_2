package uph.tpsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uph.tpsi.models.User;

public interface UserRepository extends JpaRepository<User, Long>
{
        User findByUsername ( String s );
}
