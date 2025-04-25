package com.jobfinder.catalogservice.domain;
import java.util.Optional;

public interface JobRepository {
    Iterable<Job> findAll();
    Optional<Job> findByID(String jobID);
    boolean existsByID(String jobID);
    Job save(Job job);
    void deleteByID(String jobID);

}
