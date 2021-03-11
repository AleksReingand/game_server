package com.aleks.server.services;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.enums.GameStatus;
import com.aleks.server.enums.GameType;
import com.aleks.server.model.Game;
import com.aleks.server.model.Player;
import com.aleks.server.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

  private final GameRepo gameRepo;

  @Autowired
  public GameService(GameRepo gameRepo)
  {
    this.gameRepo = gameRepo;
  }

  @Transactional
  public Game createNewGame(Player player, GameDto gameDto)
  {
    Game game = new Game();
    //TODO fill game

    gameRepo.save(game);

    return game;
  }

  @Transactional
  public Game updateGameStatus(Game game, GameStatus gameStatus)
  {
    Game gameForUpdate = getGame(game.getId());
    gameForUpdate.setGameStatus(gameStatus);

    return gameForUpdate;
  }

  @Transactional
  public List<Game> getGamesToJoin(Player player)
  {
    return gameRepo.findByGameTypeAndGameStatus(GameType.COMPETITION, GameStatus.WAITS_FOR_PLAYER)
                   .stream()
                   .filter(game -> game.getFirstPlayer() != player)
                   .collect(Collectors.toList());
  }

  @Transactional
  public Game joinGame(Player player, GameDto gameDTO)
  {
    Game game =  getGame(gameDTO.getId());
    game.setSecondPlayer(player);

    gameRepo.save(game);

    updateGameStatus(game, GameStatus.IN_PROGRESS);

    return game;

  }

  public List<Game> getPlayerGames(Player player)
  {
    return gameRepo.findByGameStatus(GameStatus.IN_PROGRESS)
                   .stream().filter(game -> game.getFirstPlayer() == player)
                   .collect(Collectors.toList());
  }

  public Game getGame(int id)
  {
    //TODO think about it
    return gameRepo.findById(id).get();
  }
}

