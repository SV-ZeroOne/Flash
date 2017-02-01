package za.co.entelect.bootcamp.flash.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.domain.UserRoles;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;
import za.co.entelect.bootcamp.flash.services.UserRoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve.velcev on 2017/02/01.
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private CustomerAccountService customerAccountService;
    @Autowired
    private UserRoleService userRoleService;

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomerAccounts userAcc = customerAccountService.getCustomerAccountsRepository().getCustomerAccountByUsername(userName);
        //UserDetails userDetails = (UserDetails) new User(userAcc.getUserName(), userAcc.getPassword(), new GrantedAuthority[]{ new SimpleGrantedAuthority("ROLE_USER") });
        if (userAcc == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ userName);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<String> userRoles = new ArrayList<String>();
        List<UserRoles> userRolesObjectList = new ArrayList<UserRoles>();
        userRolesObjectList = userRoleService.getUserRolesRepository().getUserRolesByCustomerId(userAcc.getID());
        for (UserRoles user: userRolesObjectList) {
            userRoles.add(user.getRole());
        }
        return  new org.springframework.security.core.userdetails.User
                (userAcc.getUserName(),
                        new String(userAcc.getPassword()), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        getAuthorities(userRoles));
    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

