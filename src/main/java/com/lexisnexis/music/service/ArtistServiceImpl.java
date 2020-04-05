package com.lexisnexis.music.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lexisnexis.music.dao.ArtistRepository;
import com.lexisnexis.music.dao.ArtistSpecification;
import com.lexisnexis.music.model.Artist;
import com.lexisnexis.music.model.ArtistData;

@Service
public class ArtistServiceImpl implements ArtistService {

	public ArtistRepository artistRepository;

	@Autowired
	public ArtistServiceImpl(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Override
	public List<ArtistData> getAllArtists(String searchTerm) {
		List<Artist> artists;

		if (searchTerm != null) {
			artists = artistRepository.findAll(ArtistSpecification.nameIsLike(searchTerm), Sort.by("name"));
		} else {

		artists = artistRepository.findAll(Sort.by("name"));
		
		}
		List<ArtistData> artistsData = artists.stream().map(a -> new ArtistData(a)).collect(Collectors.toList());
		return artistsData;
	}

	@Override
	public ArtistData saveArtist(ArtistData artist) {
		Artist artist_saved = artistRepository.save(artist.convertToArtist());
		return new ArtistData(artist_saved);

	}

	@Override
	public ArtistData saveArtist(Long id, ArtistData artistData) throws Exception {
		Artist artist = artistRepository.findById(id).orElseThrow(() -> new Exception("Artist not found with id" + id));
		artist.setName(artistData.getName());
		return new ArtistData(artistRepository.save(artist));
	}

}
