package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.service.TagService;

@RestController
@RequestMapping("/api/tag")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	// Create
	@PostMapping
	public Tag addTag(@RequestBody Tag tag) {
		return tagService.createTag(tag);
	}
	
	// Get All
	@GetMapping
	public List<Tag> getAllTag(){
		return tagService.getAllTag();
	}
	
	// Get tag by Id
	/*@GetMapping("/{id}")
	public Tag getTagById(@PathVariable Long id) {
		return tagService.getTagById(id);
	}*/
	
	// Update
	/*@PutMapping("/{id}")
	public Tag updateTag(@PathVariable Long id, @RequestBody Tag updatedTag) {
		return tagService.updateTag(id, updatedTag);
	}*/
	
	// Delete
	@DeleteMapping("/{id}")
	public void deleteTag(@PathVariable Long id) {
		tagService.deleteTag(id);
	}



}
