package com.aleks.server.repository;

import com.aleks.server.model.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository  extends CrudRepository<Deck, Integer>
{

}
