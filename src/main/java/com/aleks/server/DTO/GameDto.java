package com.aleks.server.DTO;

import com.aleks.server.enums.DeckType;
import com.aleks.server.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto
{
  private int id;
  private List<Player> players;
  DeckType deckType;
}
