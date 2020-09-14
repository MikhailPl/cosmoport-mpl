package com.space.service;

import com.space.BadRequestException;
import com.space.ShipNotFoundException;
import com.space.model.Ship;
import com.space.model.ShipType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ShipService {

  Page<Ship> gelAllShips(Specification<Ship> specification, Pageable sortedByName);

  List<Ship> gelAllShips(Specification<Ship> specification);

  Ship createShip(Ship requestShip) throws BadRequestException;

  Ship getShip(Long id) throws ShipNotFoundException;

  Ship editShip(Long id, Ship ship) throws BadRequestException, ShipNotFoundException;

  void deleteById(Long id) throws ShipNotFoundException;

  Long checkAndParseId(String id) throws BadRequestException;

  Specification<Ship> filterByPlanet(String planet);

  Specification<Ship> filterByName(String name);

  Specification<Ship> filterByShipType(ShipType shipType);

  Specification<Ship> filterByDate(Long after, Long before);

  Specification<Ship> filterByUsage(Boolean isUsed);

  Specification<Ship> filterBySpeed(Double min, Double max);

  Specification<Ship> filterByCrewSize(Integer min, Integer max);

  Specification<Ship> filterByRating(Double min, Double max);

}
