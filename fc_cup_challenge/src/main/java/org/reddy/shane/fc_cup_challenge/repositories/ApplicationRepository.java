package org.reddy.shane.fc_cup_challenge.repositories;

import org.reddy.shane.fc_cup_challenge.models.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, String> {
    @Override
    Application findOne(String id);

    @Override
    void delete(Application deleted);
}