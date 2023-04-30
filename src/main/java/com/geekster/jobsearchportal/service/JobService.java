package com.geekster.jobsearchportal.service;

import com.geekster.jobsearchportal.model.Job;
import com.geekster.jobsearchportal.model.JobType;
import com.geekster.jobsearchportal.repository.IJobDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IJobDao jobDao;


    //inbuilt crudRepo method
    public Iterable<Job> getAllJobs() {
        return jobDao.findAll();
    }

    public Optional<Job> getJobById(Long id){
        return jobDao.findById(id);
    }

    public String addJob(Job job) {
        Job addedJob =jobDao.save(job);
        if(addedJob != null){
            return "Yes";
        }
        return "No";
    }

    public String addJobs(List<Job> jobsList) {
        Iterable<Job>jobs =jobDao.saveAll(jobsList);
        if(jobs != null){
            return "Yes";
        }
        return "No";
    }

    // custom finder method

    public List<Job> getJobByTitle(String title) {
        return jobDao.findByTitle(title);
    }


    public List<Job> getJobsBasedOnTitleOrDescription(String title, String description) {
        return jobDao.findByTitleOrDescription(title,description);
    }

    //custom query method
    @Transactional
    public void modifyJobTypeById(Long id, JobType jobType) {
        String job = jobType.name();
        jobDao.updateJobTypeById(id,job);
    }

    @Transactional
    public void removeJobById(String title) {
        jobDao.deleteJobByTitle(title);
    }


}
