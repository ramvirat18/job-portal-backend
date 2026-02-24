package com.jobportal.backend.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@Builder
public class JobRequest {
    private String title;
    private String description;
    private String location;
}
