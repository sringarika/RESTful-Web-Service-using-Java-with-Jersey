package org.sring.unitychallenge.challengeprojectunity.Bean;

import javax.ws.rs.QueryParam;

public class ParameterBean {
    @QueryParam("projectid") 
    public String id;

    @QueryParam("country") 
    public String country;

    @QueryParam("keyword") 
    public String keyword;

    @QueryParam("number") 
    public String number;
}
