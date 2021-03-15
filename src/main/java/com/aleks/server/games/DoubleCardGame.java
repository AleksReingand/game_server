package com.aleks.server.games;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.enums.GameType;

public class DoubleCardGame implements GameLogic
{
  @Override
  public GameDto executeGameLogic(GameDto gameDto)
  {
    //TODO double card game
    return null;
  }

  @Override
  public GameType getGameType()
  {
    return GameType.DOUBLE_CARD_GAME;
  }
}
