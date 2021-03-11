package com.aleks.server.services;

import com.aleks.server.DTO.PlayerDto;
import com.aleks.server.model.Player;
import com.aleks.server.repo.PlayerRepo;
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
  private final PlayerRepo playerRepo;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Autowired
  public PlayerService(PlayerRepo playerRepo)
  {
    this.playerRepo = playerRepo;
  }

  @Transactional
  public Player createNewPlayer(PlayerDto playerDto)
  {
    Player newPlayer = new Player();
    newPlayer.setUserName(playerDto.getUserName());
    newPlayer.setPassword(passwordEncoder.encode(playerDto.getPassword()));
    newPlayer.setEmail(playerDto.getEmail());

    playerRepo.save(newPlayer);

    return newPlayer;
  }

  public Player getLoggedUser()
  {
    ContextUser principal = (ContextUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return playerRepo.findOneByUserName(principal.getPlayer().getUserName());
  }

  public List<Player> listPlayers()
  {
    List<Player> players = (List<Player>) playerRepo.findAll();

    return players;
  }
}


