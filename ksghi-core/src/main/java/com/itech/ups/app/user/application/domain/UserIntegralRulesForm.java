package com.itech.ups.app.user.application.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserIntegralRulesForm implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1413312062880116199L;
    private List<UserIntegraRule> results = new ArrayList<UserIntegraRule>();

    public List<UserIntegraRule> getResults() {
        return results;
    }

    public void setResults(List<UserIntegraRule> results) {
        this.results = results;
    }
}
