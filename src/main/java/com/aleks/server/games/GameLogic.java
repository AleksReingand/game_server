package com.aleks.server.games;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.enums.GameType;

public interface GameLogic
{
  GameDto executeGameLogic(GameDto game);
  GameType getGameType();
}
