package com.lexisnexis.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lexisnexis.music.model.AlbumData;
import com.lexisnexis.music.service.AlbumService;

@Controller
@RequestMapping(value = "/artists/{artistId}")
public class AlbumController {

	public AlbumService albumService;
	
	@Autowired
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	@GetMapping(value = "/albums")	
	public List<AlbumData> getAlbums(){
		return albumService.getAlbums();
	}
	
	
	@PostMapping(value = "/albums")	
	public void createAlbums(@RequestBody AlbumData albumData){
		 albumService.saveAlbum(albumData);
	}

	
	@PutMapping(value = "albums/{albumId}")	
	public void updateAlbums(@PathVariable( "albumId" ) Long id, @RequestBody AlbumData albumData){
		 albumService.saveAlbum(albumData);
	}

}
