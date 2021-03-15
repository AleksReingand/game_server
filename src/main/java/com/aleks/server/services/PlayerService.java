package com.aleks.server.services;

import com.aleks.server.DTO.PlayerDto;
import com.aleks.server.model.Player;
import com.aleks.server.repository.PlayerRepository;
import com.aleks.server.security.ContextUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService
{
  private final PlayerRepository playerRepository;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Autowired
  public PlayerService(PlayerRepository playerRepository)
  {
    this.playerRepository = playerRepository;
  }

  @Transactional
  public Player createNewPlayer(PlayerDto playerDto)
  {
    Player newPlayer = Player.builder()
            .userName(playerDto.getUserName())
            .email(playerDto.getEmail())
            .password(passwordEncoder.encode(playerDto.getPassword()))
            .build();

    playerRepository.save(newPlayer);

    return newPlayer;
  }

  public Player getLoggedUser()
  {
    ContextUser principal = (ContextUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return playerRepository.findOneByUserName(principal.getPlayer().getUserName());
  }

  public List<Player> listPlayers()
  {
    return (List<Player>) playerRepository.findAll();
  }
}


