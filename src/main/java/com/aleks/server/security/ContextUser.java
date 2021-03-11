package com.aleks.server.security;

import com.aleks.server.model.Player;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

public class ContextUser extends User
{
  private final Player player;

  public ContextUser(Player player)
  {
    super(player.getUserName(),
            player.getPassword(),
            true,
            true,
            true,
            true,
            Set.of(new SimpleGrantedAuthority("create")));

    this.player = player;
  }

  public Player getPlayer()
  {
    return  player;
  }
}