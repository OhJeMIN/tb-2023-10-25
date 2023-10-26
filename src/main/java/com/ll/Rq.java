package com.ll;

import java.util.ArrayList;
import java.util.List;

public class Rq {
    String cmd;
    String action;
    String queryString;

    List<String> paramNames;
    List<String> paramValues;
    Rq(String cmd){
        this.cmd =cmd;
        paramNames = new ArrayList<>();
        paramValues = new ArrayList<>();

        String[] cmdBits = cmd.split("\\?",2);
        action = cmdBits[0].trim();
        queryString = cmdBits[1].trim();

        String[] queryStringBits = queryString.split("&");

        for(int i=0;i< queryStringBits.length;i++){
            String queryParamSt = queryStringBits[i];
            String[] queryParamStrBits = queryParamSt.split("=");
            paramNames.add(queryParamStrBits[0]);
            paramValues.add(queryParamStrBits[1]);
        }
    }

    String getAction(){
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue){
        int index = paramNames.indexOf(paramName);

        if (index == -1) return defaultValue;
        try{
            return Integer.parseInt(paramValues.get(index));
        }
        catch (NumberFormatException  e){
            return defaultValue;
        }
    }
}
