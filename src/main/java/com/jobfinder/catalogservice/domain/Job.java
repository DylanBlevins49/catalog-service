package com.jobfinder.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record Job(
       @NotBlank (message = "The Job ID must be defined.")
       @Pattern(
               regexp = "[0-9a-zA-Z]",
               message = "The Job ID must be valid."
       )
       String jobID,

       @NotBlank(
               message = "The Job title must be defined."
       )
       String title,
       @NotBlank(
               message = "The job description must be defined."
       )
       String description,
       @NotBlank(
               message = "The company name must be defined."
       )
       String companyName,
       @NotBlank(
               message = "Skill 1 must be defined."
       )
       String skill1,
       @NotBlank(
               message = "Skill 2 must be defined."
       )
       String skill2

) {}
