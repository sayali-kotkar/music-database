package com.lexisnexis.music.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexisnexis.music.dao.AlbumRepository;
import com.lexisnexis.music.dao.ArtistRepository;
import com.lexisnexis.music.model.Album;
import com.lexisnexis.music.model.AlbumData;
import com.lexisnexis.music.model.Artist;

@Service
public class AlbumServiceImpl implements AlbumService {

	private AlbumRepository albumRepository;

	private ArtistRepository artistRepository;

	@Autowired
	public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository) {
		this.albumRepository = albumRepository;
		this.artistRepository = artistRepository;
	}
	/*
	 * @Override public List<AlbumData> getAlbums() { List<Album> albums =
	 * albumRepository.findAll(); return albums.stream().map(a -> new
	 * AlbumData(a)).collect(Collectors.toList()); }
	 */

	@Override
	public AlbumData saveAlbum(Long id, AlbumData albumData) throws Exception {

		Artist artist = artistRepository.findById(id)
				.orElseThrow(() -> new Exception("No artist exist with id: " + id));
		Album album = albumData.convertObjectAlbum();
		album.setArtist(artist);
		return new AlbumData(albumRepository.save(album));
	}

	@Override
	public List<AlbumData> getAlbums(Long id) {
		// TODO Auto-generated method stub
		List<Album> album =  albumRepository.fetchAlbums(id);
		List<AlbumData> albumData = album.stream().map(a -> new AlbumData(a)).collect(Collectors.toList());
		return albumData;
	}

	@Override
	public AlbumData saveAlbum(Long artistId, Long albumId, AlbumData albumData) throws Exception {
		Artist artist = artistRepository.findById(artistId)
				.orElseThrow(() -> new Exception("No artist exist with id: " + artistId));

		Album album = albumRepository.findById(albumId)
				.orElseThrow(() -> new Exception("No album exist with id: " + albumId));
		
		album.setTitle(albumData.getTitle());
		album.setGenres(albumData.getGenres());
		album.setYearOfRelease(albumData.getGenres());
		return new AlbumData(albumRepository.save(album));
	}

}
