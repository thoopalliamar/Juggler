package com.stackroute.juggler.ticketengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.ticketengine.domain.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, String>{

}
