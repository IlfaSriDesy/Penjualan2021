package pub.pelatihan.penjualan.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.pelatihan.penjualan.dto.SearchDTO;
import pub.pelatihan.penjualan.dto.UsersDTO;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.UsersRepository;
import pub.pelatihan.penjualan.services.UsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public boolean deleteUser(int id) {
        try {
            Users userOne = usersRepository.getOne(id);
            if(userOne!=null){
                System.out.printf("========1");
                usersRepository.delete(userOne);
                return true;
            }else{
                System.out.printf("========2");
                return false;
            }
        }catch (Exception e){
            System.out.printf("========3");
            return false;
        }
    }

    @Override
    public List<Users> getUsersNative() {
        return usersRepository.getUsersNative();
    }

    @Override
    public Users saveUser(UsersDTO user) {
        Users model = new Users();
        Users result = new Users();
        try {
            model.setUsername(user.getUsername());
            model.setPassword(user.getPassword());
            model.setEmail(user.getEmail());
            model.setFullname(user.getFullname());
            model.setAddress(user.getAddress());
            result = usersRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<Users> searchByUsername(SearchDTO searchDTO) {
        List<Users> listData = usersRepository.searchByUsername(searchDTO.getCari());
        return listData;
    }

    @Override
    public UsersDTO getUserById(int usersId) {
        Users model = usersRepository.getOne(usersId);
        UsersDTO dto = new UsersDTO();
        dto.setUsersId(usersId);
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setEmail(model.getEmail());
        dto.setFullname(model.getFullname());
        dto.setAddress(model.getAddress());
        return dto;
    }

    @Override
    public Users updateUser(UsersDTO user) {
        Users model = new Users();
        Users result = new Users();
        try {
            model.setUsersId(user.getUsersId());
            model.setUsername(user.getUsername());
            model.setPassword(user.getPassword());
            model.setEmail(user.getEmail());
            model.setFullname(user.getFullname());
            model.setAddress(user.getAddress());
            result = usersRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }
}
