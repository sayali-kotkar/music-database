package com.lexisnexis.music.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexisnexis.music.dao.AlbumRepository;
import com.lexisnexis.music.model.Album;
import com.lexisnexis.music.model.AlbumData;

@Service
public class AlbumServiceImpl implements AlbumService{

	private AlbumRepository albumRepository;
	
	@Autowired
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		this.albumRepository =albumRepository;
	}
	
	@Override
	public List<AlbumData> getAlbums() {
		List<Album> albums =  albumRepository.findAll();
		return albums.stream().map(a -> new AlbumData(a)).collect(Collectors.toList());
	}

	@Override
	public void saveAlbum(AlbumData albumData) {
		albumRepository.save(albumData.getAlbum());
		
	}

}
