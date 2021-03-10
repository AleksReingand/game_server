package com.aleks.server.controller;

import com.aleks.server.model.Deck;
import com.aleks.server.model.Play;
import com.aleks.server.model.Player;

public class Main
{
  public static void main(String[] args)
  {
    Play play = new Play(new Deck(52), new Player("player 1", 100), new Player("player 2", 100));

  }
}
