package com.mascarello.milagre.repositories;

import com.mascarello.milagre.models.MilagreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilagreRepository extends JpaRepository<MilagreModel,Long> {

}
