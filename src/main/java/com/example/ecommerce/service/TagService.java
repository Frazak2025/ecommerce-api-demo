package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.repository.TagRepository;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;
	
	// Create
	// Latest Edition, Promotional, Editor's choice, Normal
	public Tag createTag (Tag tag){
		return tagRepository.save(tag);
	}
	
	// Read
	public List<Tag> getAllTag() {
		return tagRepository.findAll();
	}
	
	// Read by ID
	/*public Tag getTagById (Long id) {
		return tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
	}*/
	public List<Tag> getByIds(List<Long> ids) {
        return tagRepository.findAllById(ids);
    }


	
	// Update
	/*public Tag updateTag(Long id, Tag updatedTag) {
		Tag existing = getTagById(id);
        existing.setName(updatedTag.getName());
        return tagRepository.save(existing);
    }*/
	
	// Delete
	public void deleteTag(Long id) {
        if (!tagRepository.existsById(id)) {
            throw new RuntimeException("Tag not found");
        }
        tagRepository.deleteById(id);
    }

}
