package com.deadline.controller;

import com.deadline.model.DeadlineDTO;
import com.deadline.service.DeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SyncController {

    @Autowired
    private DeadlineService deadlineService;

    @GetMapping("/sync_test")
    public String test() {
        return "Hello World!";
    }

    @GetMapping("/sync/{userId}")
    public ResponseEntity<List<DeadlineDTO>> createDeadlines(@PathVariable Long userId) {
        List<DeadlineDTO> savedDeadlines = deadlineService.getDeadlinesByUserId(userId);
        if (savedDeadlines == null || savedDeadlines.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedDeadlines);
    }

    @PostMapping("/sync/{userId}")
    public ResponseEntity<List<DeadlineDTO>> createDeadlines(@PathVariable Long userId, @RequestBody List<DeadlineDTO> deadlines) {
        List<DeadlineDTO> savedDeadlines = deadlineService.saveDeadlines(userId, deadlines);
        if (savedDeadlines == null || savedDeadlines.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedDeadlines);
    }


}
