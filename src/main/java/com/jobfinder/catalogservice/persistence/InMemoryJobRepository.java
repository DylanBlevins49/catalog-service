package com.jobfinder.catalogservice.persistence;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import com.jobfinder.catalogservice.domain.Job;
import com.jobfinder.catalogservice.domain.JobRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryJobRepository implements JobRepository {
    private static final Map<String, Job> jobs = new ConcurrentHashMap<>();

@Override
public Iterable<Job> findAll(){
    return jobs.values();
}
@Override
public Optional<Job> findByID(long jobID) {
    return existsByID (jobID) ? Optional.of(jobs.get(jobID)) :
            Optional.empty();
}
@Override
public boolean existsByID(long jobID){
    return jobs.get(jobID) != null;
}
@Override
public Job save (Job job){
    jobs.put(String.valueOf(job.jobID()), job);
    return job;
}
@Override
public void deleteByID(long jobID) {
    jobs.remove(jobID);
}}