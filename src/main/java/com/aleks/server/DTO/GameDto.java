package com.aleks.server.DTO;

import com.aleks.server.enums.DescType;
import com.aleks.server.model.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameDto
{
  private List<Player> players;

  DescType deckType;
}
