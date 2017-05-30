package org.sring.unitychallenge.challengeprojectunity.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.sring.unitychallenge.challengeprojectunity.Bean.ParameterBean;
import org.sring.unitychallenge.challengeprojectunity.model.Project;
import org.sring.unitychallenge.challengeprojectunity.model.TargetKey;
import org.sring.unitychallenge.challengeprojectunity.response.ErrorResponse;
import org.sring.unitychallenge.challengeprojectunity.response.Response;
import org.sring.unitychallenge.challengeprojectunity.service.ProjectService;

// class that handles GET request. it takes query parameters that is stored in ParameterBean.
//method returns a Response type object.
@Path("/requestproject")
public class RequestProject {
    
    ProjectService project = new ProjectService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@BeanParam ParameterBean paramBean) throws ParseException {
        if (paramBean.country == null && paramBean.keyword== null && paramBean.id == null && paramBean.number == null) {
            //return highest price project
            Project p = project.getHighestCostProject();
            return new Response(p);
        }
        else if (paramBean.id != null && project.getProject(Integer.parseInt(paramBean.id)).isEnabled()) {
            return new Response(project.getProject(Integer.parseInt(paramBean.id)));
        }
        else if (paramBean.id == null) {
            //select all the matching projects based on url parameters and return the one with highest cost
            Map<String, String> queryStr = new HashMap<String, String>();
            queryStr.put("country", paramBean.country);
            queryStr.put("number", paramBean.number);
            queryStr.put("keyword", paramBean.keyword);
            queryStr.values().removeIf(Objects::isNull);
            List<Project> newList = new ArrayList<Project>(project.getAllProjects());
            List<Project> finalList = new ArrayList<Project>();
            for (int i = 0; i< newList.size(); i++) {
                Project p = newList.get(i);
                int flag = 0;
                for (String key : queryStr.keySet()) {
                    if (key.equals("country") && p.getTargetCountries().contains(queryStr.get(key))) {
                        flag++;
                    }
                    else if (key.equals("number")) {
                        List<TargetKey> temp = new ArrayList<TargetKey>(p.getTargetKeys());
                        for (TargetKey tk : temp) {
                            if (tk.getNumber() == Integer.parseInt(queryStr.get(key))) {
                                flag++;
                                break;
                            }
                        }
                    }
                    else if (key.equals("keyword")) {
                        List<TargetKey> temp = new ArrayList<TargetKey>(p.getTargetKeys());
                        for (TargetKey tk : temp) {
                            if (tk.getKeyword().equals(queryStr.get(key))) {
                                flag++;
                                break;
                            }
                        }
                    }
                }
                if (flag == queryStr.size() && p.isEnabled()) {
                    finalList.add(p);
                }
            }
            return new Response(project.getHighestCost(finalList));
        }
        return null;
        
    }

}
