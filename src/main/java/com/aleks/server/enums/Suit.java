package com.aleks.server.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Suit
{
  CLUBS(1),
  DIAMONDS(2),
  HEARTS(3),
  SPADES(4);

  private final int rating;
}
