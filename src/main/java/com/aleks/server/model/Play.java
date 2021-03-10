package com.aleks.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Play
{
  private Deck deck;
  private Player player1;
  private Player player2;
}
