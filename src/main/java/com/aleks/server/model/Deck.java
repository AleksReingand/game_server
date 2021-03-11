package com.aleks.server.model;

import com.aleks.server.enums.Rank;
import com.aleks.server.enums.Suit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Deck
{
  private List<Card> deck;

  //TODO create deck in another place
  public Deck(int amount)
  {
    for(Suit suit : Suit.values())
    {
      for(Rank rank : Rank.values())
      {
        deck.add(new Card(0, rank, suit));
      }
    }
  }
}
