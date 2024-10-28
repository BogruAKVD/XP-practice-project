package com.deadline.service;

import com.deadline.model.DeadlineDTO;
import com.deadline.model.DeadlineEntity;
import com.deadline.repository.DeadlineRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeadlineService {
    @Autowired
    private DeadlineRepository deadlineRepository;

    public List<DeadlineDTO> getDeadlinesByUserId(Long userId) {
        return getDeadlinesByUserId(userId).stream()
                .map(entity -> {
                    DeadlineDTO dto = new DeadlineDTO();
                    dto.setName(entity.getName());
                    dto.setDeadline(entity.getDeadline());
                    dto.setTimeToComplete(entity.getTimeToComplete());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<DeadlineDTO> saveDeadlines(Long userId, List<DeadlineDTO> deadlines) {

        deadlines.forEach(dto -> {
                    DeadlineEntity entity = new DeadlineEntity();
                    entity.setName(dto.getName());
                    entity.setDeadline(dto.getDeadline());
                    entity.setTimeToComplete(dto.getTimeToComplete());
                    entity.setUserId(userId);
                    deadlineRepository.save(entity);
                }
        );

        return getDeadlinesByUserId(userId).stream()
                .map(entity -> {
                    DeadlineDTO dto = new DeadlineDTO();
                    dto.setName(entity.getName());
                    dto.setDeadline(entity.getDeadline());
                    dto.setTimeToComplete(entity.getTimeToComplete());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
