package securityDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Package: securityDemo.service
 * @ClassName: SecurityServiceImpl
 * @Description:
 * @UpdateDate: 2020/3/16 9:12
 */
@Service
public class SecurityServiceImpl implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return new User(username, passwordEncoder.encode("123456"), Arrays.asList(new SimpleGrantedAuthority("user:add"), new SimpleGrantedAuthority("user:update")));
    }
}
