package com.jobfinder.catalogservice.domain;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(long jobID) {
        super("Could not find job with ID " + jobID);
    }
}
