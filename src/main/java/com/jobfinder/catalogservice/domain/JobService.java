package com.jobfinder.catalogservice.domain;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;
    public JobService (JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public Iterable<Job> viewJobList() {
        return jobRepository.findAll();
    }
    public Job viewJobDetails(String jobID) {
        return jobRepository.findByID(jobID)
                .orElseThrow(() -> new JobNotFoundException(jobID));
    }
    public Job addJobToCatalog(Job job){
        if (jobRepository.existsByID(job.jobID())){
            throw new JobAlreadyExistsException(job.jobID());
        }
        return jobRepository.save(job);
    }
    public void removeJobFromCatalog(String jobID){
        jobRepository.deleteByID(jobID);
    }
    public Job editJobDetails(String jobID,Job job){
        return jobRepository.findByID(String.valueOf(jobID))
                .map (existingJob -> {
                    var jobToUpdate = new Job(
                            existingJob.jobID(),
                            job.title(),
                            job.description(),
                            job.companyName(),
                            job.skill1(),
                            job.skill2());
                            return jobRepository.save(jobToUpdate);
        })
                .orElseGet(() -> addJobToCatalog(job));
    }
}
