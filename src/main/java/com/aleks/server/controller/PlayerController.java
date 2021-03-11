package com.aleks.server.controller;

import com.aleks.server.DTO.PlayerDto;
import com.aleks.server.model.Player;
import com.aleks.server.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController
{
  @Autowired
  PlayerService playerService;

  @PostMapping("/create")
  public Player createPlayer(@RequestBody PlayerDto playerDto)
  {
    Player newPlayer = playerService.createNewPlayer(playerDto);

    log.info("player " + newPlayer.getUserName() + " created");

    return newPlayer;
  }

  @GetMapping( "/players")
  public List<Player> getPlayers()
  {
    return playerService.listPlayers();
  }

  @GetMapping(value = "/logged", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Player> getLoggedPlayer()
  {
    return new ResponseEntity<Player>(playerService.getLoggedUser(), HttpStatus.CREATED);
  }
}
