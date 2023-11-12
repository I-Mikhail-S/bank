package org.bank.demo.servises;

import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.api.response.LoginResponse;
import org.bank.demo.mapper.AccountMapper;
import org.bank.demo.servises.TokenService;
import org.bank.demo.entites.Account;
import org.bank.demo.entites.Role;
import org.bank.demo.api.response.LoginResponse;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AccountMapper accountMapper;




    public CreateAccountResponse registerUser(CreateAccountRequest request){

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
        request.setPassword(encodedPassword);
        request.setAuthorities(authorities);
        Account account = accountMapper.toEntity(request);
        accountRepository.save(account);
        return accountMapper.toResponse(account);
    }

    public LoginResponse loginUser(String email, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            String token = tokenService.generateJwt(auth);
            return new LoginResponse(accountRepository.findByEmail(email).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponse(null, "");
        }
    }
}
