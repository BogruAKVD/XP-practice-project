package com.deadline;

import com.deadline.controller.SyncController;
import com.deadline.model.DeadlineDTO;
import com.deadline.service.DeadlineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SyncControllerTest {

    private final long userId = 999L;

    private MockMvc mockMvc;

    @Mock
    private DeadlineService deadlineService;

    @InjectMocks
    private SyncController syncController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(syncController).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(get("/sync_test"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertEquals("Hello World!", result.getResponse().getContentAsString());
                });
    }

    @Test
    public void testCreateDeadlines_Success() throws Exception {
        List<DeadlineDTO> deadlines = new ArrayList<>();
        DeadlineDTO dto = new DeadlineDTO();
        dto.setName("Test Deadline");
        dto.setDeadline(OffsetDateTime.parse("2024-12-31T12:00:00Z"));
        dto.setTimeToComplete(5L);
        deadlines.add(dto);

        when(deadlineService.saveDeadlines(anyLong(), anyList())).thenReturn(deadlines);

        mockMvc.perform(post("/sync/{userId}", userId)
                        .contentType("application/json")
                        .content("[{\"name\":\"Test Deadline\",\"deadline\":\"2024-12-31T12:00:00Z\",\"timeToComplete\":5}]"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateDeadlines_BadRequest() throws Exception {

        when(deadlineService.saveDeadlines(anyLong(), anyList())).thenReturn(new ArrayList<>());

        mockMvc.perform(post("/sync/{userId}", userId)
                        .contentType("application/json")
                        .content("[{\"name\":\"Test Deadline\",\"deadline\":\"2024-12-31T12:00:00Z\",\"timeToComplete\":5}]"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetDeadlines_Success() throws Exception {
        List<DeadlineDTO> deadlines = new ArrayList<>();
        DeadlineDTO dto = new DeadlineDTO();
        dto.setName("Test Deadline");
        dto.setDeadline(OffsetDateTime.parse("2024-12-31T12:00:00Z"));
        dto.setTimeToComplete(5L);
        deadlines.add(dto);

        when(deadlineService.getDeadlinesByUserId(anyLong())).thenReturn(deadlines);

        mockMvc.perform(get("/sync/{userId}", userId))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDeadlines_BadRequest() throws Exception {

        when(deadlineService.getDeadlinesByUserId(anyLong())).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/sync/{userId}", userId))
                .andExpect(status().isBadRequest());
    }
}