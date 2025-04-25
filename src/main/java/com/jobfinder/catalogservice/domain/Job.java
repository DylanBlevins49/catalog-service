package com.jobfinder.catalogservice.domain;

public record Job(
       long jobID,
       String title,
       String description,
       String companyName,
       String skill1,
       String skill2

) {
}
