package com.lexisnexis.music.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtistData {
	
	public ArtistData(Artist artist) {
		this.id =  artist.getArtistId();
		this.name =  artist.getName();
	}
	
	public ArtistData(String name) {
		this.name = name;
	}

	private Long id;
	private String name;
	
	public Artist getArtist() {
		Artist artist = new Artist();
		artist.setName(this.name);
		return artist;
				
	}
}
