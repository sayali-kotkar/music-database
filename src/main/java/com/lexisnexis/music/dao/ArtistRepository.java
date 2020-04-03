package com.lexisnexis.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lexisnexis.music.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
