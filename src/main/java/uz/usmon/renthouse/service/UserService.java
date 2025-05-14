package uz.usmon.renthouse.service;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.usmon.renthouse.dto.UserDto;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.model.User;
import uz.usmon.renthouse.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Integer id) {
        return userRepo.findById(id).get();
    }

    public Result create(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone_number(userDto.getPhone_number());
        user.setPhoto_id(userDto.getPhoto_id());
        user.setSurname(userDto.getSurname());
        userRepo.save(user);
        return new Result(true, "User created");
    }

    public Result update(Integer id, UserDto userDto) {
        Optional<User> user1 = userRepo.findById(id);
        if (user1.isPresent()) {
            User user = userRepo.findById(id).get();
            user.setName(userDto.getName());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setPhone_number(userDto.getPhone_number());
            user.setPhoto_id(userDto.getPhoto_id());
            user.setSurname(userDto.getSurname());
            userRepo.save(user);
            return new Result(true, "User updated");
        }
        return new Result(false, "User not found");
    }

    public Result delete(Integer id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.delete(user.get());
            return new Result(true, "User deleted");
        }
        return new Result(false, "User not found");
    }
}
