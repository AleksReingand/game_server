package com.aleks.server.games;

import com.aleks.server.enums.GameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameFactory
{
  @Autowired
  private List<GameLogic> games;

  private final Map<GameType, GameLogic> gameByType = new HashMap<>();

  @PostConstruct
  private void init()
  {
    games.forEach(gameLogic -> gameByType.put(gameLogic.getGameType(), gameLogic));
  }

  public GameLogic getByGameType(GameType gameType)
  {
    // if null, it can relate from our wish
    return gameByType.getOrDefault(gameType, gameByType.get(GameType.COMPETITION));
  }

}
