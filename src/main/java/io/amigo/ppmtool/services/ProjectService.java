package io.amigo.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.amigo.ppmtool.domain.Project;
import io.amigo.ppmtool.exceptions.ProjectIdExeption;
import io.amigo.ppmtool.repositories.ProjectRepository;
import lombok.Data;

@Service
@Data
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        try {
            project.getProjectIdentifier().toUpperCase();
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdExeption(
                    "Project Id " + project.getProjectIdentifier().toUpperCase() + " Already exists!");

        }
    }

}
