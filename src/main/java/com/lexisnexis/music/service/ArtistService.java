package com.lexisnexis.music.service;

import java.util.List;

import com.lexisnexis.music.model.ArtistData;


public interface ArtistService {

	public List<ArtistData> getAllArtists(String searchTerm, int page, int limit);
	
	public ArtistData saveArtist(ArtistData artist);

	public ArtistData saveArtist(Long id, ArtistData artistData) throws Exception;
}
		