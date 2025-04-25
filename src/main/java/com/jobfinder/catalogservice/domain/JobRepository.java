package com.jobfinder.catalogservice.domain;
import java.util.Optional;

public interface JobRepository {
    Iterable<Job> findAll();
    Optional<Job> findByID(long jobID);
    boolean existsByID(long jobID);
    Job save(Job job);
    void deleteByID(long jobID);

}
