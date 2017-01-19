package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.Date;
import java.util.List;

public class Answers extends GenericModel {
    @SerializedName("answer_units")
    private List<AnswerUnits> answerUnits;
    @SerializedName("source_document_id")
    private String sourceDocumentId;
    private Date timestamp;

    public class AnswerUnits extends GenericModel {
        private List<Content> content;
        private String direction;
        private String id;
        @SerializedName("parent_id")
        private String parentId;
        private String title;
        private String type;

        public class Content extends GenericModel {
            @SerializedName("media_type")
            private String mediaType;
            private String text;

            public String getMediaType() {
                return this.mediaType;
            }

            public String getText() {
                return this.text;
            }

            public void setMediaType(String mediaType) {
                this.mediaType = mediaType;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public String getDirection() {
            return this.direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getParentId() {
            return this.parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<Content> getContent() {
            return this.content;
        }

        public String getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public List<AnswerUnits> getAnswerUnits() {
        return this.answerUnits;
    }

    public String getSourceDocumentId() {
        return this.sourceDocumentId;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setAnswerUnits(List<AnswerUnits> answerUnits) {
        this.answerUnits = answerUnits;
    }

    public void setSourceDocumentId(String sourceDocumentId) {
        this.sourceDocumentId = sourceDocumentId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
