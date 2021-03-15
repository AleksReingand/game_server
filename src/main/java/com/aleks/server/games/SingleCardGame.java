package com.aleks.server.games;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.DTO.GamePlayerDto;
import com.aleks.server.enums.GameType;
import com.aleks.server.enums.MoveType;
import com.aleks.server.model.Card;
import com.aleks.server.tools.ToolsForGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SingleCardGame implements GameLogic
{

  private final int FOLD_FOR_ALL = 1;
  private final int PLAY_FOR_ONE = 3;
  private final int PLAY_FOR_ALL = 10;

  @Autowired
  private ToolsForGame toolsForGame;

  @Override
  public GameDto executeGameLogic(GameDto gameDto)
  {
    List<GamePlayerDto> players = gameDto.getPlayers();

    List<GamePlayerDto> collectPlayerPlaying = players.stream().filter(player -> player.getMoveType() == MoveType.PLAY)
            .collect(Collectors.toList());

    List<GamePlayerDto> collectPlayerSameCardRating = new ArrayList<>();

    if(collectPlayerPlaying.isEmpty())
    {
      setPlayerToken(players, null, FOLD_FOR_ALL);

      return gameDto;
    }

    if(collectPlayerPlaying.size() == 1)
    {
      setPlayerToken(players, collectPlayerPlaying.get(0), PLAY_FOR_ONE);

      return gameDto;
    }

    collectPlayerPlaying.sort((p1, p2) ->
    {
      Card maxCardPlayer1 = maxCardFromPlayer(p1.getCard());
      Card maxCardPlayer2 = maxCardFromPlayer(p2.getCard());

      int result = compareTwoCards(maxCardPlayer1, maxCardPlayer2);

      if(result == 0)
      {
        collectPlayerSameCardRating.add(p1);
        collectPlayerSameCardRating.add(p2);
      }

      return result;
    });

    if(!collectPlayerSameCardRating.isEmpty())
    {
      for(GamePlayerDto player : collectPlayerSameCardRating)
      {

      };
    }



    return gameDto;
  }

  private Card maxCardFromPlayer(List<Card> cards)
  {
    cards.sort(this::compareTwoCards);

    return cards.get(0);
  }

  private int compareTwoCards(Card card1, Card card2)
  {
    return card1.getRank().getRating() - card2.getRank().getRating();
  }

  private void setPlayerToken(List<GamePlayerDto> players, GamePlayerDto winner, int amount)
  {
    for(GamePlayerDto playerDto : players)
    {
      if(winner != null && playerDto.getPlayerId() == winner.getPlayerId())
      {
        winner.setToken(winner.getToken() + amount);
      }
      else
      {
        playerDto.setToken(playerDto.getToken() - amount);
      }
    }
  }

  @Override
  public GameType getGameType()
  {
    return GameType.SINGLE_CARD_GAME;
  }
}
