package com.geekster.jobsearchportal.controller;

import com.geekster.jobsearchportal.model.Job;
import com.geekster.jobsearchportal.model.JobType;
import com.geekster.jobsearchportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    JobService jobService;
    @GetMapping(value = "/jobs/all")
    public Iterable<Job>getAllJobs(){
        return jobService.getAllJobs();
    }
    @GetMapping(value = "/job/{id}")
    public Optional<Job> getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @GetMapping(value = "/jobs/title/{title}")
    public List<Job>getJobByTitle(@PathVariable String title){
        return jobService.getJobByTitle(title);
    }

    @GetMapping(value = "/jobs/title/{title}/description/{description}")
    public List<Job>getJobsBasedOnTitleOrDescription(@PathVariable String title,@PathVariable String description){
        return jobService.getJobsBasedOnTitleOrDescription(title,description);
    }

    @PostMapping(value = "/job/add")
    public String addJob(@RequestBody Job job){
        return jobService.addJob(job);
    }


    @PostMapping(value = "/jobs/add")
    public String addJobs(@RequestBody List<Job>jobsList){
        return jobService.addJobs(jobsList);
    }



    @PutMapping(value = "/job/update/{id}/{jobType}")
    public void modifyJobTypeById(@PathVariable Long id, @PathVariable JobType jobType){
           jobService.modifyJobTypeById(id,jobType);
    }

    @DeleteMapping(value ="/jobs/{title}")
    public void removeJobById(@PathVariable String title){
        jobService.removeJobById(title);
    }

}
