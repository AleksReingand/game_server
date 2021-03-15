package com.aleks.server.model;

import com.aleks.server.enums.Rank;
import com.aleks.server.enums.Suit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "rank", nullable = false)
  private Rank rank;

  @Column(name = "suit", nullable = false)
  private Suit suit;

  @Column(name = "joker", nullable = false)
  private boolean isJoker;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
          name = "game_card",
          joinColumns = {@JoinColumn(name = "card_id")},
          inverseJoinColumns = {@JoinColumn(name = "game_id")}
  )
  private Set<Player> players;
}
