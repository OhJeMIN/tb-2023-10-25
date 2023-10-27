package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String cmd;
    String action;
    String queryString;
    Map<String, String> param;

    Rq(String cmd) {
        this.cmd = cmd;
        param = new HashMap<String, String>();
        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0].trim();

        if (cmdBits.length == 1){
            return;
        }
        queryString = cmdBits[1].trim();

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamSt = queryStringBits[i];
            String[] queryParamStrBits = queryParamSt.split("=");
            param.put(queryParamStrBits[0], queryParamStrBits[1]);
        }
    }

    String getAction() {
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        String paramValue = param.get(paramName);

        if (paramValue != null) {
            try {
                return Integer.parseInt(paramValue);
            } catch (NumberFormatException e) { }
        }
        return defaultValue;
    }
}
