package pub.pelatihan.penjualan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import pub.pelatihan.penjualan.models.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT u FROM Users u WHERE u.email= :email")
    public Users getUserByEmail(String email);

    @Query("FROM Users")
    public List<Users> getUsers();

    @Query(value = "select * from users", nativeQuery = true)
    public List<Users> getUsersNative();

    @Query(value = "select * from users where username LIKE %:cariParam%", nativeQuery = true)
    public List<Users> searchByUsername(@Param("cariParam") String cari);
}
