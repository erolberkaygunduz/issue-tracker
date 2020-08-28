package com.issuetracker.issuetracker.repository;

import com.issuetracker.issuetracker.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
