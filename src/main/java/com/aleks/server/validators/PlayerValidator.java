package com.aleks.server.validators;

import com.aleks.server.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerValidator
{
  @Autowired
  private PlayerRepository playerRepository;

  public void validatePlayerById(int playerId)
  {
    if(!playerRepository.findById(playerId).isPresent())
    {
      //TODO process exception player not found
      throw new RuntimeException("Player not found, id: " + playerId);
    }
  }
}
