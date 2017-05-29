package com.xenenergy.projects.entities.arm;

import java.util.Map;

/**
 * Created by Daryll Sabate on 5/22/2017.
 */
public class ErrorJson {

    public Integer status;
    public String error;
    public String message;
    public String timeStamp;
    public String trace;

    public ErrorJson(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

}