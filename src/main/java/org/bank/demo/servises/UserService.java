package org.bank.demo.servises;

import org.bank.demo.exception.NotFoundAccountException;
import org.bank.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        return accountRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundAccountException("user is not valid")
        );
    }

}

