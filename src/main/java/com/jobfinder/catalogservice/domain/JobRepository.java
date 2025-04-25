package com.jobfinder.catalogservice.domain;
import java.awt.print.Book;
import java.util.Optional;

public interface JobRepository {
    Iterable<Job> findAll();
    Optional<Job> findByID(Long id);
    boolean existsByID(Long id);
    Job save(Job job);
    void deleteByID(Job jobID);
}
