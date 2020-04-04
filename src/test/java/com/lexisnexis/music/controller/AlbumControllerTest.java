package com.lexisnexis.music.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lexisnexis.music.model.Album;
import com.lexisnexis.music.model.AlbumData;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AlbumControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldSaveAlbums() throws Exception {
		
		AlbumData albumDataRequest = new AlbumData("frozen","1988","hiphop");
		String base_url = "http://localhost:" + port + "/artists";
		
		ResponseEntity<Album> album= this.restTemplate.postForEntity(base_url, albumDataRequest,Album.class);
		assertThat(album.getBody().getTitle(),Matchers.is("album"));
	}
	
	@Test
	public void shouldReturnAlbums() throws Exception {
		
		 String base_url = "http://localhost:" + port + "/artists";
		
		List<Album> albumList = this.restTemplate.getForObject(base_url, List.class);
		assertThat(albumList.size(),Matchers.is(0));
	}
	
	
}
