package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.dto.IssueDto;
import com.issuetracker.issuetracker.entity.Issue;
import com.issuetracker.issuetracker.entity.IssueHistory;
import com.issuetracker.issuetracker.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable (Pageable pageable);

    Boolean delete(Long issue);



}
