package org.sring.unitychallenge.challengeprojectunity.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

public class TargetKey {

private int number;
private String keyword;

/**
* No args constructor for use in serialization
* 
*/
public TargetKey() {
}

/**
* 
* @param keyword
* @param number
*/
public TargetKey(int number, String keyword) {
super();
this.number = number;
this.keyword = keyword;
}

public int getNumber() {
return number;
}

public void setNumber(int number) {
this.number = number;
}

public String getKeyword() {
return keyword;
}

public void setKeyword(String keyword) {
this.keyword = keyword;
}
@Override
public String toString() {
        return new StringBuffer("{\"number\":").append(this.number)
                .append(", \"keyword\":").append("\"").append(this.keyword).append("\"").append("}")
                .toString();
    }
}