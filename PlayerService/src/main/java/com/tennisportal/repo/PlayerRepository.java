package com.tennisportal.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tennisportal.model.Player;
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
