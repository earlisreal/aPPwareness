package com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class Solution extends GenericModel {
    @SerializedName("shadow_me")
    private List<String> shadowMe;
    private List<String> shadows;
    @SerializedName("solution_ref")
    private String solutionRef;
    private String status;
    @SerializedName("status_cause")
    private StatusCause statusCause;

    public class StatusCause {
        @SerializedName("error_code")
        private String errorCode;
        private String message;
        private List<String> tokens;

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getMessage() {
            return this.message;
        }

        public List<String> getTokens() {
            return this.tokens;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setTokens(List<String> tokens) {
            this.tokens = tokens;
        }
    }

    public List<String> getShadowMe() {
        return this.shadowMe;
    }

    public List<String> getShadows() {
        return this.shadows;
    }

    public String getSolutionRef() {
        return this.solutionRef;
    }

    public String getStatus() {
        return this.status;
    }

    public StatusCause getStatusCause() {
        return this.statusCause;
    }

    public void setShadowMe(List<String> shadowMe) {
        this.shadowMe = shadowMe;
    }

    public void setShadows(List<String> shadows) {
        this.shadows = shadows;
    }

    public void setSolutionRef(String solutionRef) {
        this.solutionRef = solutionRef;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusCause(StatusCause statusCause) {
        this.statusCause = statusCause;
    }
}
