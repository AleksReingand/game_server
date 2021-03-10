package com.aleks.server.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PlayerDto
{
  @NotNull
  private String userName;

  @NotNull
  private String password;

  @NotNull
  private String email;

  private int tokens;
}
