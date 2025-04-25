package com.jobfinder.catalogservice.domain;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;
    public JobService (JobService jobService) {
        this.jobRepository = jobService.jobRepository;
    }
    public Iterable<Job> viewJobList() {
        return jobRepository.findAll();
    }
    public Job viewJobById(Long id) {
        return jobRepository.findbyID(jobID)
                .orElseThrow(() -> new JobNotFoundException(jobID));
    }
    public Job addJobToCatalog(Job job){
        if (jobRepository.existsByID(job.jobID())){
            throw new JobAlreadyExistsException(job.jobID());
        }
        return jobRepository.save(job);
    }
    public void removeJobFromCatalog(long jobID){
        jobRepository.deleteByID(jobID);
    }
    public Job editJobDetails(long jobID,Job job){
        return jobRepository.findbyID(jobID)
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
                .orElseGet(() -> addJobToCatalog(Job));
    }
}
