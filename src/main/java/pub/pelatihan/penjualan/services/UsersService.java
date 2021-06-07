package pub.pelatihan.penjualan.services;

import pub.pelatihan.penjualan.dto.SearchDTO;
import pub.pelatihan.penjualan.dto.UsersDTO;
import pub.pelatihan.penjualan.models.Users;

import java.util.List;

public interface UsersService {

    public boolean deleteUser(int id);
    public List<Users> getUsersNative();
    public Users saveUser(UsersDTO user);
    public List<Users> searchByUsername(SearchDTO searchDTO);
    public UsersDTO getUserById(int usersId);
    public Users updateUser(UsersDTO user);
    public List<UsersDTO> getUsers();
}
