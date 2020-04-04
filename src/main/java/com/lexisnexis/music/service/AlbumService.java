package com.lexisnexis.music.service;

import java.util.List;

import com.lexisnexis.music.model.AlbumData;


public interface AlbumService {
	
	public List<AlbumData> getAlbums();
     
    public void saveAlbum(AlbumData album);
}
