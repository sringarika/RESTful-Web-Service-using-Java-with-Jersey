package org.sring.unitychallenge.challengeprojectunity.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sring.unitychallenge.challengeprojectunity.model.Project;
import org.sring.unitychallenge.challengeprojectunity.model.TargetKey;
import org.sring.unitychallenge.challengeprojectunity.storage.StorageSpace;

public class ProjectService {
    private Map<Integer, Project> projService = StorageSpace.getProjects();
    
    SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy hh:mm:ss");
    Date currentDate = new Date();
    String currDate = sdf.format(currentDate);
    public ProjectService() {
        
    }
    public List<Project> getAllProjects() {
        return new ArrayList<Project>(projService.values());
    }
    public Project getProject(int id) {
        return projService.get(id);
    }
    public Project addProject (Project proj) {
        proj.setId(projService.size() + 1);
        projService.put(proj.getId(), proj);
        return proj;
    }
    public Project getHighestCostProject() throws ParseException {
        double maxCost=0;
        int maxId=0;
        for (Project key : projService.values()) {
                if (key.getProjectCost() > maxCost && key.isEnabled() 
                        && key.getExpiryDate().compareTo(currDate) > 0) {
                    maxCost = key.getProjectCost();
                    maxId = key.getId();
                }
        }
        return projService.get(maxId);
    }
    public Project getHighestCost(List<Project> list) throws ParseException {
        double maxCost=0;
        int maxId=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProjectCost() > maxCost && list.get(i).isEnabled()
                    && list.get(i).getExpiryDate().compareTo(currDate) > 0) {
                maxCost = list.get(i).getProjectCost();
                maxId = i;
            }
        }
        return list.get(maxId);
    }
    //extra methods for future implementation
    public List<Project> getByCountry(String country) throws ParseException {
        List<Project> newList = new ArrayList<Project>();
        for (int key : projService.keySet()) {
            if (projService.get(key).getTargetCountries().contains(country) && projService.get(key).isEnabled() 
                    && projService.get(key).getExpiryDate().compareTo(currDate) > 0) {
                newList.add(projService.get(key));
            }
        }
        return newList;
    }
    public List<Project> getByNumber(int number) throws ParseException {
        List<Project> newList = new ArrayList<Project>();
        for (int key : projService.keySet()) {
            List<TargetKey> keys = new ArrayList<TargetKey>();
            if (projService.get(key).isEnabled() && projService.get(key).getExpiryDate().compareTo(currDate) > 0) {
            keys = projService.get(key).getTargetKeys();
            for (int i = 0; i< keys.size(); i++) {
                if (keys.get(i).getNumber() >= number) {
                    newList.add(projService.get(key));
                    break;
                }
            }
        }
        }
        return newList;
    }
    public List<Project> getByKeyword(String keyword) throws ParseException {
        List<Project> newList = new ArrayList<Project>();
        for (int key : projService.keySet()) {
            List<TargetKey> keys = new ArrayList<TargetKey>();
            if (projService.get(key).isEnabled() && projService.get(key).getExpiryDate().compareTo(currDate) > 0) {
            keys = projService.get(key).getTargetKeys();
            for (int i = 0; i< keys.size(); i++) {
                if (keys.get(i).getKeyword().equals(keyword)) {
                    newList.add(projService.get(key));
                    break;
                }
            }
        }
        }
        return newList;
    }
    
}
