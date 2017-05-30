package org.sring.unitychallenge.challengeprojectunity.storage;

import java.util.HashMap;
import java.util.Map;

import org.sring.unitychallenge.challengeprojectunity.model.Project;


public class StorageSpace {
    private static Map<Integer, Project> projects = new HashMap<Integer, Project>();
    public static Map<Integer, Project> getProjects() {
        return projects;
    }
    

}
