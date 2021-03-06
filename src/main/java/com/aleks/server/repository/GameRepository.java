package com.aleks.server.repository;

import com.aleks.server.enums.GameStatus;
import com.aleks.server.enums.GameType;
import com.aleks.server.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer>
{
  List<Game> findByGameTypeAndGameStatus(GameType GameType, GameStatus GameStatus);
  List<Game> findByGameStatus(GameStatus gameStatus);
}
