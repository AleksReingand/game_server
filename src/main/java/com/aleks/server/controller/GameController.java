package com.aleks.server.controller;

import com.aleks.server.DTO.GameDto;
import com.aleks.server.model.Game;
import com.aleks.server.services.GameService;
import com.aleks.server.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/game")
@Slf4j
public class GameController
{
  @Autowired
  GameService gameService;

  @Autowired
  PlayerService playerService;


  @PostMapping("/create")
  public ResponseEntity<Game> createNewGame(@RequestBody GameDto gameDto)
  {

    log.info("created");

    return null;
  }




}
