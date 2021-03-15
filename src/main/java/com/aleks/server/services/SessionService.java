package com.aleks.server.services;

import com.aleks.server.DTO.SessionDto;
import com.aleks.server.enums.GameStatus;
import com.aleks.server.model.Game;
import com.aleks.server.model.Player;
import com.aleks.server.model.Session;
import com.aleks.server.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService
{
  private final SessionRepository sessionRepository;
  
  @Autowired
  public SessionService(SessionRepository sessionRepository)
  {
    this.sessionRepository = sessionRepository;
  }

  @Transactional
  public Session createSession(Game game, Player player, SessionDto sessionDto)
  {
    Session session = Session.builder()
            .game(game)
            .player(player)
            .build();
    //TODO fill session

    sessionRepository.save(session);

    return session;
  }

  @Transactional
  public Session autoCreateSession(Game game)
  {
    Session session = new Session();
    //TODO fill session

    sessionRepository.save(session);

    return session;
  }

  public List<SessionDto> getSessionsInGame(Game game)
  {

    List<Session> sessionsInGame = sessionRepository.findByGame(game);
    List<SessionDto> sessions = new ArrayList<>();

    for(Session session : sessionsInGame)
    {
      SessionDto sessionDto = new SessionDto();
      //TODO fill sessionDto

      sessions.add(sessionDto);
    }

    return sessions;
  }

  public List<String> getTakenSessionInGame(Game game)
  {
    return sessionRepository.findByGame(game)
                      .stream()
                      .map(session -> session.getCard().getRank().name() + " " + session.getCard().getSuit().name())
                      .collect(Collectors.toList());
  }

  public List<String> getPlayerSessionInGame(Game game, Player player)
  {
    return sessionRepository.findByGameAndPlayer(game, player)
                      .stream()
                      .map(session -> session.getCard().getRank().name() + " " + session.getCard().getSuit().name())
                      .collect(Collectors.toList());
  }

  public int getTheNumberOfPlayerSessionsInGame(Game game, Player player)
  {
    return sessionRepository.countByGameAndPlayer(game, player);
  }

  public GameStatus checkCurrentGameStatus(Game game)
  {
    //TODO write logic
    return null;
  }
}

