package gr.codehub.teamb.acmeshop.utils;

import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static gr.codehub.teamb.acmeshop.enums.Role.ADMIN;

@Component
public class Authenticate {

    @Autowired
    UserRepository userRepository;

    public boolean Authenticate(String token){
        if(userRepository.findUserByToken(token)!=null){
            return  true;
        }else{
            return false;
        }
    }

    public boolean Authorize(String token){
        if(userRepository.findUserByToken(token).getRole()==ADMIN){
            return  true;
        }else{
            return false;
        }
    }

}
