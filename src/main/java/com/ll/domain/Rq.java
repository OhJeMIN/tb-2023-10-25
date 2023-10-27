package com.ll.domain;

import com.ll.standard.util.Ut;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String cmd;
    private String action;
    private String queryString;
    private Map<String, String> param;

    public Rq(String cmd) {
        this.cmd = cmd;
        param = new HashMap<String, String>();
        String[] cmdBits = cmd.split("\\?", 2);
        action = cmdBits[0].trim();

        if (cmdBits.length == 1) {
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

    public String getAction() {
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        return Ut.str.parseInt(param.get(paramName), defaultValue);
    }
}
