package com.jobportal.backend.service;

import com.jobportal.backend.dto.request.JobRequest;
import com.jobportal.backend.dto.response.JobResponse;
import com.jobportal.backend.entity.Job;
import com.jobportal.backend.repository.JobRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class JobService {

    private final JobRepository jobRepository;

    public JobResponse createJob(JobRequest request)
    {
        Job job = Job.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .build();


        Job savedJob = jobRepository.save(job);

        return JobResponse.builder()
                .id(savedJob.getId())
                .title(savedJob.getTitle())
                .description(savedJob.getDescription())
                .location(savedJob.getLocation())
                .build();

    }
}
