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
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final AccountMapper accountMapper;

    @Autowired
    public AuthenticationService(AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.accountMapper = accountMapper;
    }

    public CreateAccountResponse registerUser(CreateAccountRequest request){

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
        request.setPassword(encodedPassword);
        request.setAuthorities(authorities);

        Account account = accountMapper.toEntity(request);
        account.setId(7L);
/*        account.setName(request.getName());
        account.setTelephone(request.getTelephone());
        account.setEmail(request.getEmail());
        account.setDateOfBirth(request.getDateOfBirth());*/

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
