package com.allianz.example.service;

import com.allianz.example.database.repository.CommentEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentEntityRepository commentEntityRepository;

    public CommentService(CommentEntityRepository commentEntityRepository) {
        this.commentEntityRepository = commentEntityRepository;
    }
}
