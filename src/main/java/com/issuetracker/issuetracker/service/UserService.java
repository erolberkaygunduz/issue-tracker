package com.issuetracker.issuetracker.service;

import com.issuetracker.issuetracker.entity.Issue;
import com.issuetracker.issuetracker.entity.IssueHistory;
import com.issuetracker.issuetracker.entity.Project;
import com.issuetracker.issuetracker.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable (Pageable pageable);

    Boolean delete(User user);

    User getByUserName(String username);


}
