package com.lexisnexis.music.service;

import java.util.List;

import com.lexisnexis.music.model.Album;
import com.lexisnexis.music.model.AlbumData;


public interface AlbumService {
	
     
    public AlbumData saveAlbum(Long albumId, AlbumData album) throws Exception;

	public List<AlbumData> getAlbums(Long id);

	public AlbumData saveAlbum(Long artistId, Long albumId, AlbumData albumData) throws Exception;
}
