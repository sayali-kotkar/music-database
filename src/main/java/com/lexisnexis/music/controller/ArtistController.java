package com.lexisnexis.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lexisnexis.music.model.ArtistData;
import com.lexisnexis.music.service.ArtistService;

@RestController
public class ArtistController {

	public ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping(value = "/artists")	
	public List<ArtistData> getArtists(@RequestParam(required = false) String searchTerm){
		return artistService.getAllArtists(searchTerm);
	}	
	
	@PostMapping(value = "/artists")	
	public ArtistData createArtists(@RequestBody ArtistData artistData){
		return artistService.saveArtist(artistData);
	}

	@PutMapping(value = "/artists/{artistId}")	
	public ArtistData updateArtist(@PathVariable("artistId") Long id, @RequestBody ArtistData artistData) throws Exception{
		return artistService.saveArtist(id, artistData);
	}
}