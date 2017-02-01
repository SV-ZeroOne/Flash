package za.co.entelect.bootcamp.flash.web.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import za.co.entelect.bootcamp.flash.domain.CustomerAccounts;
import za.co.entelect.bootcamp.flash.services.CustomerAccountService;

/**
 * Created by steve.velcev on 2017/02/01.
 */
public class CustomUserDetailsService implements UserDetailsService{

    private CustomerAccountService customerAccountService;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomerAccounts userAcc = customerAccountService.getCustomerAccountsRepository().getCustomerAccountByUsername(userName);
        //UserDetails userDetails = (UserDetails) new User(userAcc.getUserName(), userAcc.getPassword(), new GrantedAuthority[]{ new SimpleGrantedAuthority("ROLE_USER") });
        return null;
    }

}

