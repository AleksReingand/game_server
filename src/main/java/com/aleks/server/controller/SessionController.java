package com.aleks.server.controller;

import com.aleks.server.DTO.SessionDto;
import com.aleks.server.model.Session;
import com.aleks.server.services.GameService;
import com.aleks.server.services.PlayerService;
import com.aleks.server.services.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


  @PostMapping("/create")
  public ResponseEntity<Session> createSession(@RequestBody SessionDto sessionDto)
  {
    log.info("created");
    return null;
  }
}
