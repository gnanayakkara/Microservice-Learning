 package com.gnanayakkara.rentcloud.authorizationserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gnanayakkara.rentcloud.authorizationserver.model.AuthUserDetail;
import com.gnanayakkara.rentcloud.authorizationserver.model.User;
import com.gnanayakkara.rentcloud.authorizationserver.repository.UserDeatilRepository;

@Service("userDeatilServiceImpl")
public class UserDeatilServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDeatilRepository userDeatilRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userDeatilRepository.findByUsername(name);
		
		optionalUser.orElseThrow(()-> new UsernameNotFoundException("User Name or Password wrong"));
		
		UserDetails userDetails = new AuthUserDetail(optionalUser.get()); 
		
		new AccountStatusUserDetailsChecker().check(userDetails);
		
		return userDetails;
	}

}
