package com.yurets_y.utl2planchart.repositories;

import com.yurets_y.utl2planchart.entities.Partner;
import org.springframework.data.repository.CrudRepository;

public interface PartnersRepository extends CrudRepository<Partner,Long> {

    Partner getById(Long id);

    Iterable<Partner> getAllByShortCompanyNameContains(String name);

    Iterable<Partner> getAllByCode(Integer code);

    Iterable<Partner> getAllByOrderById();



}
