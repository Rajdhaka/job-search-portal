package com.geekster.jobsearchportal.repository;

import com.geekster.jobsearchportal.model.Job;
import com.geekster.jobsearchportal.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobDao extends CrudRepository<Job,Long>{

    //custom finder method
    public List<Job>findByTitle(String title);
    public List<Job> findByTitleOrDescription(String title, String description);

    //custom query
    @Modifying
    @Query(value = "update Job Set job_type=:jobType where ID =:id",nativeQuery = true)
    public void updateJobTypeById( Long id,String jobType);
    @Modifying
    @Query(value = "delete from Job where TITLE =:title",nativeQuery = true)
    public void deleteJobByTitle(String title);


}
