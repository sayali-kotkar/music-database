package com.lexisnexis.music.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lexisnexis.music.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	@Query(value = "Select * FROM ALBUM a  WHERE a.artist_id = ?1", nativeQuery = true)
	List<Album> fetchAlbums(Long artistId); 
}
