package com.aleks.server.games;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.enums.GameType;

public class Competition implements GameLogic
{
  @Override
  public GameDto executeGameLogic(GameDto gameDto)
  {
    return null;
  }

  @Override
  public GameType getGameType()
  {
    return GameType.COMPETITION;
  }
}
