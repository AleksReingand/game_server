package com.aleks.server.controller;

import com.aleks.server.DTO.SessionDto;
import com.aleks.server.model.Game;
import com.aleks.server.model.Session;
import com.aleks.server.services.GameService;
import com.aleks.server.services.PlayerService;
import com.aleks.server.services.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/session")
@Slf4j
public class SessionController
{
  @Autowired
  private SessionService sessionService;

  @Autowired
  private PlayerService playerService;

  @Autowired
  private GameService gameService;

  @Autowired
  private HttpSession httpSession;


  @PostMapping("/create")
  public Session createSession(@RequestBody SessionDto sessionDto)
  {
    Integer gameId = (Integer) httpSession.getAttribute("gameId");

    log.info("session to insert:" + sessionDto);

    Session session = sessionService.createSession(gameService.getGame(gameId), playerService.getLoggedUser(), sessionDto);
    Game game = gameService.getGame(gameId);
    gameService.updateGameStatus(gameService.getGame(gameId), sessionService.checkCurrentGameStatus(game));

    return session;
  }

  @GetMapping("/autocreate")
  public Session autoCreateSession()
  {
    Integer gameId = (Integer) httpSession.getAttribute("gameId");

    log.info("AUTO session to insert:" );

    Session move = sessionService.autoCreateSession(gameService.getGame(gameId));

    Game game = gameService.getGame(gameId);
    gameService.updateGameStatus(gameService.getGame(gameId), sessionService.checkCurrentGameStatus(game));

    return move;
  }

  @GetMapping("/list")
  public List<SessionDto> getMovesInGame()
  {
    Integer gameId = (Integer) httpSession.getAttribute("gameId");

    return sessionService.getSessionsInGame(gameService.getGame(gameId));
  }
}
