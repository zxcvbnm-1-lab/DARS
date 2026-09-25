package com.dars.backend.controller;

import com.dars.backend.entity.DisasterEvent;
import com.dars.backend.repository.DisasterEventRepository;
import com.dars.backend.service.DisasterEventService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DisasterEventControllerTest {

    @Test
    void getAllEventsReturnsOkAndAnEmptyArrayWhenNoEventsExist() throws Exception {
        DisasterEventRepository repository = mock(DisasterEventRepository.class);
        when(repository.findAll()).thenReturn(List.of());

        MockMvc mockMvc = mockMvcFor(repository);

        mockMvc.perform(get("/api/events"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }

    @Test
    void getAllEventsReturnsTheEventResponseContract() throws Exception {
        DisasterEvent event = new DisasterEvent();
        ReflectionTestUtils.setField(event, "id", 1L);
        ReflectionTestUtils.setField(event, "externalId", "eonet-123");
        ReflectionTestUtils.setField(event, "title", "Sample event");
        ReflectionTestUtils.setField(event, "disasterType", "FLOOD");
        ReflectionTestUtils.setField(event, "latitude", 10.0d);
        ReflectionTestUtils.setField(event, "longitude", 123.0d);
        ReflectionTestUtils.setField(event, "source", "EONET");

        DisasterEventRepository repository = mock(DisasterEventRepository.class);
        when(repository.findAll()).thenReturn(List.of(event));

        MockMvc mockMvc = mockMvcFor(repository);

        mockMvc.perform(get("/api/events"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].externalId").value("eonet-123"))
                .andExpect(jsonPath("$[0].title").value("Sample event"))
                .andExpect(jsonPath("$[0].disasterType").value("FLOOD"))
                .andExpect(jsonPath("$[0].latitude").value(10.0))
                .andExpect(jsonPath("$[0].longitude").value(123.0))
                .andExpect(jsonPath("$[0].source").value("EONET"));
    }

    private MockMvc mockMvcFor(DisasterEventRepository repository) {
        DisasterEventService service = new DisasterEventService(repository);
        DisasterEventController controller = new DisasterEventController(service);
        return MockMvcBuilders.standaloneSetup(controller).build();
    }
}
