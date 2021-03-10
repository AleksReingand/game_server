package com.aleks.server.DTO;

import com.aleks.server.model.Game;
import com.aleks.server.model.Player;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SessionDto
{
  private Game game;

  private Player player;

  private LocalDateTime created;
}
