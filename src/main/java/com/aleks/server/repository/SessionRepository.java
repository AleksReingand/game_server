package com.aleks.server.repository;

import com.aleks.server.model.Game;
import com.aleks.server.model.Player;
import com.aleks.server.model.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer>
{
  List<Session> findByGame(Game game);
  List<Session> findByGameAndPlayer(Game game, Player player);
  int countByGameAndPlayer(Game game, Player player);
}
