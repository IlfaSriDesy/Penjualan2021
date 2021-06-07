package pub.pelatihan.penjualan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pub.pelatihan.penjualan.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
