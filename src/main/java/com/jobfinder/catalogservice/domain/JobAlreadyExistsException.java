package com.jobfinder.catalogservice.domain;

public class JobAlreadyExistsException extends RuntimeException {
    public JobAlreadyExistsException(long jobID) {
        super("Job with ID " + jobID + " already exists");
    }
}
