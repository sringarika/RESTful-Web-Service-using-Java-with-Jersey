package org.sring.unitychallenge.challengeprojectunity.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

//Project class. Holds all the information from the JSON object
public class Project {

private int id;
private String projectName;
private String creationDate;
private String expiryDate;
private boolean enabled;
private List<String> targetCountries = null;
private double projectCost;
private String projectUrl;
private List<TargetKey> targetKeys = null;

/**
* No args constructor for use in serialization
* 
*/
public Project() {
}

/**
* 
* @param id
* @param creationDate
* @param projectUrl
* @param projectCost
* @param expiryDate
* @param targetCountries
* @param targetKeys
* @param projectName
*/
public Project(int id, String projectName, String creationDate, String expiryDate, List<String> targetCountries, double projectCost, String projectUrl, List<TargetKey> targetKeys) {
super();
this.id = id;
this.projectName = projectName;
this.creationDate = creationDate;
this.expiryDate = expiryDate;
this.targetCountries = targetCountries;
this.projectCost = projectCost;
this.projectUrl = projectUrl;
this.targetKeys = targetKeys;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getProjectName() {
return projectName;
}

public void setProjectName(String projectName) {
this.projectName = projectName;
}

public String getCreationDate() {
return creationDate;
}

public void setCreationDate(String creationDate) {
this.creationDate = creationDate;
}

public String getExpiryDate() {
return expiryDate;
}

public void setExpiryDate(String expiryDate) {
this.expiryDate = expiryDate;
}

public List<String> getTargetCountries() {
return targetCountries;
}

public void setTargetCountries(List<String> targetCountries) {
this.targetCountries = targetCountries;
}

public double getProjectCost() {
return projectCost;
}

public void setProjectCost(double projectCost) {
this.projectCost = projectCost;
}

public String getProjectUrl() {
return projectUrl;
}

public void setProjectUrl(String projectUrl) {
this.projectUrl = projectUrl;
}

public List<TargetKey> getTargetKeys() {
return targetKeys;
}

public void setTargetKeys(List<TargetKey> targetKeys) {
this.targetKeys = targetKeys;
}
@Override
public String toString() {
    //StringBuffer sb = new StringBuffer();
    //sb.append("")

    return new StringBuffer("{\"id\":").append(this.id)
            .append(", \"projectName\":").append("\"").append(this.projectName).append("\"")
            .append(", \"creationDate\":").append("\"").append(this.creationDate).append("\"")
            .append(", \"expiryDate\":").append("\"").append(this.expiryDate).append("\"")
            .append(", \"targetCountries\":").append(this.targetCountries)
            .append(", \"projectCost\":").append(this.projectCost)
            .append(", \"projectUrl\":").append("\"").append(this.projectUrl).append("\"")
            .append(", \"targetKeys\":").append(this.targetKeys).append("\n")
            .toString();

}

/**
 * @return the enabled
 */
public boolean isEnabled() {
    return enabled;
}

/**
 * @param enabled the enabled to set
 */
public void setEnabled(boolean enabled) {
    this.enabled = enabled;
}

}