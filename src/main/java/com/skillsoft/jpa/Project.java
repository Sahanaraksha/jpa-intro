package com.skillsoft.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectName;
    private LocalDate projectDeadline;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Employees> employees;

    public Project(String projectName, LocalDate projectDeadline) {

        this.projectName = projectName;
        this.projectDeadline = projectDeadline;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(LocalDate projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    @Override
    public String toString() {

        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDeadline=" + projectDeadline +
                '}';
    }
}
