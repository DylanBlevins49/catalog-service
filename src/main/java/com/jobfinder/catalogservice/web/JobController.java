package com.jobfinder.catalogservice.web;

import com.jobfinder.catalogservice.domain.Job;
import com.jobfinder.catalogservice.domain.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jobs")
public class JobController {
    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping
    public Iterable<Job> get() {
        return jobService.viewJobList();
    }
    @GetMapping("{jobID}")
    public Job getByjobID(@PathVariable long jobID) {
        return jobService.viewJobDetails(jobID);
    }
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Job post(@RequestBody Job job) {
        return jobService.addJobToCatalog(job);
    }
    @DeleteMapping ("{jobID}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long jobID) {
        jobService.removeJobFromCatalog(jobID);
    }
    @PutMapping("{jobID}")
    public Job put(@PathVariable long jobID, @RequestBody Job job) {
        return jobService.editJobDetails(jobID, job);
    }
}
