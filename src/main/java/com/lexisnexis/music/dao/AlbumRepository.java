package com.lexisnexis.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lexisnexis.music.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
