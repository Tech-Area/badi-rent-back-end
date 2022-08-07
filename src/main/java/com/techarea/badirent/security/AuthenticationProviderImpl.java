package com.techarea.badirent.security;

import com.techarea.badirent.entity.User;
import com.techarea.badirent.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserRepository userRepository;

    public AuthenticationProviderImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByUsername(username);
        if(user != null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            return  new UsernamePasswordAuthenticationToken(username,password,authorities);
        } else {
            throw new BadCredentialsException("No user registered");
        }
    }

//    private List<GrantedAuthority> getGrantedAuthority(Set<Authority> authorities){
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for(Authority authority: authorities){
//            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
//        }
//        return grantedAuthorities;
//    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
