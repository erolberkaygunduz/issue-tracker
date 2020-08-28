package com.issuetracker.issuetracker.repository;

import com.issuetracker.issuetracker.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}
