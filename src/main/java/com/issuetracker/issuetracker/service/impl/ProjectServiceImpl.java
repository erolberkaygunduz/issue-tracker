package com.issuetracker.issuetracker.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.issuetracker.issuetracker.dto.ProjectDto;
import com.issuetracker.issuetracker.entity.Project;
import com.issuetracker.issuetracker.entity.User;
import com.issuetracker.issuetracker.repository.ProjectRepository;
import com.issuetracker.issuetracker.repository.UserRepository;
import com.issuetracker.issuetracker.service.ProjectService;
import com.issuetracker.issuetracker.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository, ObjectMapper objectMapper, ModelMapper modelMapper, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null)
            throw new IllegalArgumentException("Project Code Already Exist");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);

    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> respnose = new TPage<ProjectDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;

    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb =projectRepository.getOne(id);
        if (projectDb == null) throw new IllegalArgumentException("Projenin ID'si bulunamadı." + id);

        Project projectCheck =projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);

        if (projectCheck!=null )
            throw new IllegalArgumentException("Projenin Code'si zaten mevcut." + id);

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);

    }
}
