package com.aleks.server.controller;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.enums.GameType;
import com.aleks.server.model.Game;
import com.aleks.server.services.GameService;
import com.aleks.server.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/game")
@Slf4j
public class GameController
{
  @Autowired
  GameService gameService;

  @Autowired
  PlayerService playerService;

  @Autowired
  HttpSession httpSession;

  @PostMapping("/create")
  public ResponseEntity<Integer> createNewGame(@RequestBody GameDto gameDto)
  {
    Game game = gameService.createNewGame(playerService.getLoggedUser(), gameDto);
    httpSession.setAttribute("gameId", game.getId());

    log.info("new game id: " + httpSession.getAttribute("gameId") + " stored in session");

    return new ResponseEntity<Integer>(game.getId(), HttpStatus.CREATED);
  }

  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Game> getGamesToJoin(@RequestParam GameType gameType)
  {
    return gameService.getGamesToJoin(playerService.getLoggedUser(), gameType);
  }

  @PostMapping("/join")
  public Game joinGame(@RequestBody GameDto gameDto)
  {
    return gameService.joinGame(playerService.getLoggedUser(), gameDto);
  }

  @GetMapping(value = "/player/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Game> getPlayerGames()
  {
    return gameService.getPlayerGames(playerService.getLoggedUser());
  }

  @GetMapping("/{id}")
  public Game getGameProperties(@PathVariable int id) {

    httpSession.setAttribute("gameId", id);

    return gameService.getGame(id);
  }

  @PostMapping("/move")
  public void move(@RequestBody GameDto gameDto)
  {
    gameService.move(gameDto);
  }
}
