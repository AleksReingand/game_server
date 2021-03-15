package com.aleks.server.DTO;

import com.aleks.server.enums.MoveType;
import com.aleks.server.model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayerDto
{
  private int playerId;

  private MoveType moveType;

  private List<Card> card;

  private int token;
}
