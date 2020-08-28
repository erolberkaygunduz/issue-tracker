package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project Project);

    Project getById(Long id);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable (Pageable pageable);

    Boolean delete(Project project);




}
