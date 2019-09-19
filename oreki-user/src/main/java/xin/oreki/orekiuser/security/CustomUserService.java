package xin.oreki.orekiuser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xin.oreki.orekiuser.domain.User;
import xin.oreki.orekiuser.repo.UserRepository;

/**
 * @author oreki
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户: " + username + " 不存在!");
        }
        return user;
    }
}
