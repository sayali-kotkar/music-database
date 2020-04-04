package com.lexisnexis.music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexisnexis.music.dao.ArtistRepository;
import com.lexisnexis.music.model.Artist;
import com.lexisnexis.music.model.ArtistData;

@Service
public class ArtistServiceImpl implements ArtistService{

	
	public ArtistRepository artistRepository;
	
	@Autowired
	public ArtistServiceImpl(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}
	
	@Override
	public List<ArtistData> getAllArtists() {
		
		List<Artist> artists=  artistRepository.findAll();
		List<ArtistData> artistsData = artists.stream().map(a -> new ArtistData(a)).collect(Collectors.toList());
		return artistsData;
	}

	@Override
	public Artist saveArtist(ArtistData artist) {
		return artistRepository.save(artist.getArtist());
		
	}

	@Override
	public Artist saveArtist(Long id, ArtistData artistData) throws Exception {
		Artist artist = artistRepository.findById(id).orElseThrow(() -> new Exception("Artist not found with id"+ id));
		artist.setName(artistData.getName());
		return artistRepository.save(artist);
	}

}
