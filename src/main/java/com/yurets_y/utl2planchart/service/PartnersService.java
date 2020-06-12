package com.yurets_y.utl2planchart.service;

import com.yurets_y.utl2planchart.entities.Partner;
import com.yurets_y.utl2planchart.repositories.PartnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PartnersService {

    @Autowired
    private PartnersRepository partnerRepo;

    public void save(Partner partner){
        if(partner != null){
            partnerRepo.save(partner);
        }
    }

    public void update(Partner partner){
        Partner updatedPartner = partnerRepo.getById(partner.getId());
        if(updatedPartner != null){
            partnerRepo.save(partner);
        }
    }

    public void delete(Partner partner){
        partnerRepo.delete(partner);
    }

    public Iterable<Partner> getAllById(){
        return partnerRepo.findAll();
    }


}
