package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.dto.ProjectDto;
import com.issuetracker.issuetracker.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto project);
}