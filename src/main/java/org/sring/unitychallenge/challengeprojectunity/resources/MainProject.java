package org.sring.unitychallenge.challengeprojectunity.resources;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//import org.codehaus.jettison.json.JSONObject;
import org.sring.unitychallenge.challengeprojectunity.model.Project;
import org.sring.unitychallenge.challengeprojectunity.service.ProjectService;

//class that handles POST request. method consumes JSON and writes it on a text file. Thread safe
@Path("/createproject")

public class MainProject {
    ProjectService project = new ProjectService();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putProjects(Project proj) throws IOException {
        synchronized(this) {
        project.addProject(proj);
        try {
        FileWriter file = new FileWriter("/Users/sringarikapandey/Desktop/Projects.txt");
        file.write(project.getAllProjects().toString());
        file.write("\n");
        file.flush();
        file.close();
        System.out.println();
        
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        }
    }

}
