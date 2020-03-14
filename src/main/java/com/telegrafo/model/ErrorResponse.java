package com.telegrafo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    public ErrorResponse(String error, String errorDescription){
        this.error = error;
        this.errorDescription = errorDescription;
    }

    private String error;
    @JsonProperty("error_description")
    private String errorDescription;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
