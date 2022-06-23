package com.example.demohibernate.repository;

import com.example.demohibernate.model.TitlesEntity;
import com.example.demohibernate.model.TitlesEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<TitlesEntity, TitlesEntityPK> {
}
