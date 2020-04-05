package com.lexisnexis.music.service;

import java.util.List;

import com.lexisnexis.music.model.AlbumData;
import com.lexisnexis.music.model.Artist;
import com.lexisnexis.music.model.ArtistData;


public interface ArtistService {

	public List<ArtistData> getAllArtists();
	
	public ArtistData saveArtist(ArtistData artist);

	public ArtistData saveArtist(Long id, ArtistData artistData) throws Exception;
}
		