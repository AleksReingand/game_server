package com.aleks.server.repository;

import com.aleks.server.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>
{
  Player findOneByUserName(String userName);
}
