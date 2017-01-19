package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import java.util.List;

public class VisualRecognitionGenericModel<T extends ImageProcessed> extends GenericModel {
    private List<T> images;
    @SerializedName("images_processed")
    private Integer imagesProcessed;
    private List<ImageProcessingWarning> warnings;

    public Integer getImagesProcessed() {
        return this.imagesProcessed;
    }

    public void setImagesProcessed(Integer imagesProcessed) {
        this.imagesProcessed = imagesProcessed;
    }

    public List<T> getImages() {
        return this.images;
    }

    public void setImages(List<T> images) {
        this.images = images;
    }

    public List<ImageProcessingWarning> getWarnings() {
        return this.warnings;
    }

    public void setWarnings(List<ImageProcessingWarning> warnings) {
        this.warnings = warnings;
    }
}
