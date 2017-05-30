package org.sring.unitychallenge.challengeprojectunity.response;

import org.sring.unitychallenge.challengeprojectunity.model.Project;
//class that handles the response for GET methods
public class Response {
    private String projectName;
    private double projectCost;
    private String projectUrl;
    private String message;
    public Response() {
        
    }
    public Response(Project p) {
        this.projectCost = p.getProjectCost();
        this.projectName = p.getProjectName();
        this.projectUrl = p.getProjectUrl();
    }
    public Response(String s) {
        this.message = s;
    }
    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }
    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    /**
     * @return the projectCost
     */
    public double getProjectCost() {
        return projectCost;
    }
    /**
     * @param projectCost the projectCost to set
     */
    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }
    /**
     * @return the projectUrl
     */
    public String getProjectUrl() {
        return projectUrl;
    }
    /**
     * @param projectUrl the projectUrl to set
     */
    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
/**
 * @return the message
 */
public String getMessage() {
    return message;
}
/**
 * @param message the message to set
 */
public void setMessage(String message) {
    this.message = message;
}
}
