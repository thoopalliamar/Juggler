package com.stackroute.juggler.ticketengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.ticketengine.domain.ShowHistory;

@Repository
public interface ShowHistoryRepository extends CrudRepository<ShowHistory, String>{

}
