package com.issuetracker.issuetracker.api;

import com.issuetracker.issuetracker.dto.ProjectDto;
import com.issuetracker.issuetracker.entity.Project;
import com.issuetracker.issuetracker.service.impl.ProjectServiceImpl;
import com.issuetracker.issuetracker.util.ApiPaths;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImpl.update(id,projectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));


    }
}
