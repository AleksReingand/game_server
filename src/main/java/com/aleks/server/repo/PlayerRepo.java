package com.aleks.server.repo;

import com.aleks.server.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Integer>
{
  Player findOneByUserName(String userName);
}
