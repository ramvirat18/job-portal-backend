package com.jobportal.backend.controller;

import com.jobportal.backend.dto.request.JobRequest;
import com.jobportal.backend.dto.response.JobResponse;
import com.jobportal.backend.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public JobResponse createJob(@Valid @RequestBody JobRequest request)
    {
        return jobService.createJob(request);
    }

}
