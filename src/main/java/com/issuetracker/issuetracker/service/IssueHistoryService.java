package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.entity.Issue;
import com.issuetracker.issuetracker.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistory save(IssueHistory issueHistory);

    IssueHistory getById(Long id);

    Page<IssueHistory> getAllPageable (Pageable pageable);

    Boolean delete(IssueHistory issueHistory);



}
