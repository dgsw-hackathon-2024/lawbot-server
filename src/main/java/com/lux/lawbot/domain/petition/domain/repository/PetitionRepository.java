package com.lux.lawbot.domain.petition.domain.repository;

import com.lux.lawbot.domain.petition.domain.entity.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetitionRepository extends JpaRepository<Petition, Long> {
}
