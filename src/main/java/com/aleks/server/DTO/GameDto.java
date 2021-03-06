package com.aleks.server.DTO;

import com.aleks.server.enums.DeckType;
import com.aleks.server.enums.GameType;
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
  private GameType gameType;
  private DeckType deckType;
  private List<GamePlayerDto> players;
}
