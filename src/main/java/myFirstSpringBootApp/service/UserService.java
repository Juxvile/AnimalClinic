package myFirstSpringBootApp.service;

import lombok.RequiredArgsConstructor;
import myFirstSpringBootApp.domain.Role;
import myFirstSpringBootApp.domain.User;
import myFirstSpringBootApp.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepo userRepo;

    public boolean addUser(User user){
        

        User userByLogin = userRepo.findByUsername(user.getUsername());

        if(userByLogin == null && userRepo.findByEmail(user.getEmail()) == null) {

            user.setRoles(Collections.singleton(Role.USER));
            user.setActive(true);
            userRepo.save(user);
            return true;
        } else {
            return false;
        }
    }
}