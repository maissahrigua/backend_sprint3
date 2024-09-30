package com.maissa.songs.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maissa.songs.dto.SongDTO;
import com.maissa.songs.entities.Song;
import com.maissa.songs.service.SongService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SongRESTController {
	@Autowired
	SongService songService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SongDTO> getAllSongs() {
		return songService.getAllSongs();
	 } 		
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public SongDTO getSongById(@PathVariable("id") Long id) {	
		return songService.getSong(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public SongDTO createSong(@RequestBody SongDTO songDTO) {
		return songService.saveSong(songDTO);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public SongDTO updateSong(@RequestBody SongDTO songDTO) {
		return songService.updateSong(songDTO);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteSong(@PathVariable("id") Long id)
	{
		songService.deleteSongById(id);
	}
	
	@RequestMapping(value="/sonsalb/{idAlb}",method = RequestMethod.GET)
	public List<Song> getSongsByAlbId(@PathVariable("idAlb") Long idAlb) {
		return songService.findByAlbumIdAlb(idAlb);
	 }
}