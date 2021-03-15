package com.aleks.server.services;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.DTO.GamePlayerDto;
import com.aleks.server.enums.GameStatus;
import com.aleks.server.enums.GameType;
import com.aleks.server.games.GameFactory;
import com.aleks.server.model.Game;
import com.aleks.server.model.Player;
import com.aleks.server.model.Transaction;
import com.aleks.server.repository.GameRepository;
import com.aleks.server.validators.PlayerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameService
{
  @Autowired
  private GameRepository gameRepo;

  @Autowired
  private GameFactory gameFactory;

  @Autowired
  PlayerValidator playerValidator;

  public Game createNewGame(Player player, GameDto gameDto)
  {
    Game game = Game.builder()
            .gameType(gameDto.getGameType())
            .gameStatus(GameStatus.WAITS_FOR_PLAYER)
            .build();

    gameRepo.save(game);

    return game;
  }

  public List<Game> getGamesToJoin(Player player, GameType gameType)
  {
    return gameRepo.findByGameTypeAndGameStatus(gameType, GameStatus.WAITS_FOR_PLAYER);
  }

  public Game joinGame(Player player, GameDto gameDTO)
  {
    Game game = getGame(gameDTO.getId());
    game.setGameStatus(GameStatus.IN_PROGRESS);

    gameRepo.save(game);

    return game;
  }

  public List<Game> getPlayerGames(Player player)
  {
    return gameRepo.findByGameStatus(GameStatus.IN_PROGRESS);
  }

  public Game getGame(int id)
  {
    //TODO exception not found
    return gameRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found the game's id: " + id));
  }

  public List<Transaction> move(GameDto gameDto)
  {
    List<GamePlayerDto> players = gameDto.getPlayers();
    players.forEach(player -> playerValidator.validatePlayerById(player.getPlayerId()));

    gameFactory.getByGameType(gameDto.getGameType()).executeGameLogic(gameDto);

    //update transaction table


    //return who winner and loser state
    return null;
  }
}

