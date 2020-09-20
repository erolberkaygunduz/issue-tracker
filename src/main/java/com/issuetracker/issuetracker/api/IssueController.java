package com.issuetracker.issuetracker.api;

import com.issuetracker.issuetracker.dto.IssueDto;
import com.issuetracker.issuetracker.dto.ProjectDto;
import com.issuetracker.issuetracker.service.impl.IssueServiceImpl;
import com.issuetracker.issuetracker.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = "Issue API")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id){
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);

    }
    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue){
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id, @Valid @RequestBody IssueDto issueDto){
        return ResponseEntity.ok(issueServiceImpl.update(id,issueDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Id Operation",response = ProjectDto.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));


    }
}
