package com.aleks.server.security;

import com.aleks.server.model.Player;
import com.aleks.server.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{
  private final PlayerRepo playerRepo;

  @Autowired
  public UserDetailsServiceImpl(PlayerRepo playerRepo)
  {
    this.playerRepo = playerRepo;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    if(username == null || isEmpty(username))
    {
      throw new UsernameNotFoundException("Username cannot be empty");
    }

    Player player = playerRepo.findOneByUserName(username);

    if(player == null)
    {
      throw new UsernameNotFoundException("Player " + username + " doesn't exists");
    }

    return new ContextUser(player);
  }
}

