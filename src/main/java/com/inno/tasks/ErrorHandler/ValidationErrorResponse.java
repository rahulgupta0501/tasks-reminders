package com.inno.tasks.ErrorHandler;

import com.inno.tasks.Entity.Violation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<Violation> violations = new ArrayList<>();

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    public void add(Violation v){
        violations.add(v);
    }
}
