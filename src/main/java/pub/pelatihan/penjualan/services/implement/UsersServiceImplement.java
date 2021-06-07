package pub.pelatihan.penjualan.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.pelatihan.penjualan.dto.SearchDTO;
import pub.pelatihan.penjualan.dto.UsersDTO;
import pub.pelatihan.penjualan.models.Role;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.RoleRepository;
import pub.pelatihan.penjualan.repositories.UsersRepository;
import pub.pelatihan.penjualan.services.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImplement implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

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

            // save data user
            model.setUsername(user.getUsername());
            model.setPassword(user.getPassword());
            model.setEmail(user.getEmail());
            model.setFullname(user.getFullname());
            model.setAddress(user.getAddress());

            // save data role
            Optional<Role> role = roleRepository.findById(user.getRoleId());
            if (role.isPresent()) {
                model.setRole(role.get());
            }
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
//        dto.setAddress(model.getAddress());
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
//            model.setAddress(user.getAddress());
            result = usersRepository.save(model);
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<UsersDTO> getUsers() {
        List<UsersDTO> result = new ArrayList<>();
        List<Users> users = usersRepository.getUsers();

        for(Users user : users)  {
            UsersDTO dto = new UsersDTO();

            // set attribute user
            dto.setUsersId(user.getUsersId());
            dto.setUsername(user.getUsername());
            dto.setPassword(user.getPassword());
            dto.setEmail(user.getEmail());
            dto.setFullname(user.getFullname());
            dto.setAddress(user.getAddress());

            // set attribute role
            dto.setRoleId(user.getRole().getRoleId());
            dto.setRolename(user.getRole().getRolename());

            result.add(dto);
        }

        return result;
    }
}
