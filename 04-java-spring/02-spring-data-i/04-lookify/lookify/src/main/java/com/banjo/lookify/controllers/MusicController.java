package com.banjo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banjo.lookify.models.Music;
import com.banjo.lookify.services.MusicService;

@Controller
public class MusicController {
	private final MusicService musicService;
	
	public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "music/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Music> music = musicService.allMusic();
		model.addAttribute("music", music);
		return "music/dashboard.jsp";
	}
	
	@RequestMapping("/music/new")
	public String newMusic(@ModelAttribute("music") Music music, Model model) {
		
	return "/music/new.jsp";
	}
	
	@RequestMapping(value="/music", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("music") Music music, BindingResult result) {
		if (result.hasErrors()) {
			return "music/new.jsp";
		} else {
			musicService.createMusic(music);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", musicService.findMusic(id));
		return "music/show.jsp";
	}
	
	@RequestMapping("/search/topten")
	public String topten(Model model) {
		List<Music> topten = musicService.topTen();
		model.addAttribute("top", topten);
		return "music/topten.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
		public String search(@RequestParam(value="artist") String search, Model model) {
		List<Music> results = musicService.findArtist(search);
		model.addAttribute("search", search);
		model.addAttribute("results", results);
		return "music/search.jsp";
	}
}
