package com.aleks.server.model;

import com.aleks.server.enums.Rank;
import com.aleks.server.enums.Suit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Card
{
  private Rank rank;
  private Suit suit;
}
