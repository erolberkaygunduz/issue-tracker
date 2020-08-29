package com.issuetracker.issuetracker.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project DTO")
public class ProjectDto {
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "Projenin Isimi")
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true,value = "Projenin Kodu")
    private String projectCode;
}
