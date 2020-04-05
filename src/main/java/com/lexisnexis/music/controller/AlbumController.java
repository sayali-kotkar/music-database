package com.lexisnexis.music.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lexisnexis.music.model.AlbumData;
import com.lexisnexis.music.service.AlbumService;

@RestController
@RequestMapping(value = "/artists/{artistId}")
public class AlbumController {

	public AlbumService albumService;
	
	@Autowired
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	@GetMapping(value = "/dummy")	
	public List<AlbumData> dummy(@PathVariable("artistId") Long artistId){
		AlbumData albumData = new AlbumData();
		albumData.setTitle("album1");
		List<AlbumData> artist = new ArrayList();
		artist.add(albumData);
		return artist;
	}
	
	@GetMapping(value = "/albums")	
	public List<AlbumData> getAlbums(@PathVariable( "artistId" ) Long artistId){
		
		return albumService.getAlbums(artistId);
	}
	
	
	@PostMapping(value = "/albums")	
	public AlbumData createAlbums(@PathVariable( "artistId" ) Long id, @RequestBody AlbumData albumData) throws Exception{
		 return albumService.saveAlbum(id, albumData);
	}

	@PutMapping(value = "albums/{albumId}")	
	public AlbumData updateAlbums(@PathVariable( "artistId" ) Long artistId, @PathVariable( "albumId" ) Long albumId, @RequestBody AlbumData albumData) throws Exception{
		 return albumService.saveAlbum(artistId, albumId, albumData);
	}

}
