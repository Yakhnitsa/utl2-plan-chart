package com.yurets_y.utl2planchart.repositories;

import com.yurets_y.utl2planchart.entities.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationsRepository extends CrudRepository<Station,Integer> {

    Iterable<Station> findAllByRusNameContains(String rusName);

    Iterable<Station> findAllByUkrNameContainsOrRusNameContains(String urkName, String rusName);

    Station findFirstByCodeEquals(Integer code);

    Station findByCodeEquals(Integer code);
}
