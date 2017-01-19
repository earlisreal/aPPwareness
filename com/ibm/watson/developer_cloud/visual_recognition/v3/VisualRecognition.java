package com.ibm.watson.developer_cloud.visual_recognition.v3;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.RecognizedText;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class VisualRecognition extends WatsonService {
    private static final String PARAM_API_KEY = "api_key";
    private static final String PARAM_CLASSIFIERS = "classifiers";
    private static final String PARAM_CLASSIFIER_IDS = "classifier_ids";
    private static final String PARAM_IMAGES_FILE = "images_file";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_NEGATIVE_EXAMPLES = "negative_examples";
    private static final String PARAM_PARAMETERS = "parameters";
    private static final String PARAM_POSITIVE_EXAMPLES = "positive_examples";
    private static final String PARAM_THRESHOLD = "threshold";
    private static final String PARAM_URL = "url";
    private static final String PATH_CLASSIFIER = "/v3/classifiers/%s";
    private static final String PATH_CLASSIFIERS = "/v3/classifiers";
    private static final String PATH_CLASSIFY = "/v3/classify";
    private static final String PATH_DETECT_FACES = "/v3/detect_faces";
    private static final String PATH_RECOGNIZE_TEXT = "/v3/recognize_text";
    private static final String SERVICE_NAME = "watson_vision_combined";
    private static final Type TYPE_LIST_CLASSIFIERS;
    private static final String URL = "https://gateway-a.watsonplatform.net/visual-recognition/api";
    private static final String VERBOSE = "verbose";
    public static final String VERSION_DATE_2016_05_20 = "2016-05-20";
    private String versionDate;

    static {
        TYPE_LIST_CLASSIFIERS = new 1().getType();
    }

    public VisualRecognition(String versionDate) {
        super(SERVICE_NAME);
        if (getEndPoint() == null || getEndPoint().isEmpty()) {
            setEndPoint(URL);
        }
        Validator.notNull(versionDate, "versionDate cannot be null. Use '2016-05-19'");
        this.versionDate = versionDate;
    }

    public VisualRecognition(String versionDate, String apiKey) {
        this(versionDate);
        setApiKey(apiKey);
    }

    private void addApiKeyToRequest(Builder builder, String apiKey) {
        HttpUrl url = HttpUrl.parse(builder.build().url().toString());
        if (url.query() == null || url.query().isEmpty()) {
            builder.url(builder.build().url() + "?" + apiKey);
        } else {
            builder.url(builder.build().url() + "&" + apiKey);
        }
    }

    private JsonObject getParametersAsJson(ClassifyImagesOptions options) {
        JsonObject ret = new JsonObject();
        if (options.url() != null && options.images() == null) {
            ret.addProperty(PARAM_URL, options.url().toString());
        }
        if (!(options.classifierIds() == null || options.classifierIds().isEmpty())) {
            JsonArray array = new JsonArray();
            for (String cId : options.classifierIds()) {
                array.add(new JsonPrimitive(cId));
            }
            ret.add(PARAM_CLASSIFIER_IDS, array);
        }
        if (options.threshold() != null) {
            ret.addProperty(PARAM_THRESHOLD, options.threshold());
        }
        return ret;
    }

    private JsonObject getParametersAsJson(VisualRecognitionOptions options) {
        JsonObject ret = new JsonObject();
        ret.addProperty(PARAM_URL, options.url().toString());
        return ret;
    }

    protected void setAuthentication(Builder builder) {
        if (getApiKey() == null) {
            throw new IllegalArgumentException("api_key needs to be specified. Use setApiKey()");
        }
        addApiKeyToRequest(builder, "api_key=" + getApiKey());
    }

    public ServiceCall<VisualClassification> classify(ClassifyImagesOptions options) {
        Validator.notNull(options, "'options' cannot be null");
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (options.images() != null) {
            bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.images().getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.images()));
        }
        if (options.imagesBinary() != null) {
            bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.imageName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.imagesBinary()));
        }
        bodyBuilder.addFormDataPart(PARAM_PARAMETERS, getParametersAsJson(options).toString());
        RequestBuilder requestBuilder = RequestBuilder.post(PATH_CLASSIFY);
        requestBuilder.query(new Object[]{"version", this.versionDate}).body(bodyBuilder.build());
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassification.class));
    }

    public ServiceCall<VisualClassifier> createClassifier(ClassifierOptions options) {
        Validator.notNull(options, " options cannot be null");
        validateClassifierOptions(options);
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        bodyBuilder.addFormDataPart(PARAM_NAME, options.classifierName());
        for (String className : options.classNames()) {
            bodyBuilder.addFormDataPart(className + "_" + PARAM_POSITIVE_EXAMPLES, options.positiveExamplesByClassName(className).getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.positiveExamplesByClassName(className)));
        }
        if (options.negativeExamples() != null) {
            bodyBuilder.addFormDataPart(PARAM_NEGATIVE_EXAMPLES, options.negativeExamples().getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.negativeExamples()));
        }
        RequestBuilder requestBuilder = RequestBuilder.post(PATH_CLASSIFIERS);
        requestBuilder.query(new Object[]{"version", this.versionDate}).body(bodyBuilder.build());
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassifier.class));
    }

    private void validateClassifierOptions(ClassifierOptions options) {
        boolean z;
        boolean hasExamples;
        String errorMessage = "To create a classifier, you must supply at least 2 zip files - either 2 positive example sets, or 1 positive and 1 negative set";
        Validator.notNull(options.classifierName(), "'classifierName' cannot be null");
        if (options.classNames().isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "There are no classes. " + errorMessage);
        if (options.classNames().size() > 1 || (options.negativeExamples() != null && options.classNames().size() == 1)) {
            hasExamples = true;
        } else {
            hasExamples = false;
        }
        Validator.isTrue(hasExamples, errorMessage);
    }

    public ServiceCall<VisualClassifier> updateClassifier(String classifierId, ClassifierOptions options) {
        boolean z;
        Validator.notNull(classifierId, "classifierId cannot be null");
        Validator.notNull(options, " options cannot be null");
        String errorMessage = "To update a classifier, you must supply at least 1 zip file - either a positive or negative zip file.";
        if (options.classNames().isEmpty() && options.negativeExamples() == null) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, errorMessage);
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (String className : options.classNames()) {
            bodyBuilder.addFormDataPart(className + "_" + PARAM_POSITIVE_EXAMPLES, options.positiveExamplesByClassName(className).getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.positiveExamplesByClassName(className)));
        }
        if (options.negativeExamples() != null) {
            bodyBuilder.addFormDataPart(PARAM_NEGATIVE_EXAMPLES, options.negativeExamples().getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.negativeExamples()));
        }
        RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_CLASSIFIER, new Object[]{classifierId}));
        requestBuilder.query(new Object[]{"version", this.versionDate}).body(bodyBuilder.build());
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassifier.class));
    }

    public ServiceCall<Void> deleteClassifier(String classifierId) {
        boolean z;
        if (classifierId == null || classifierId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "classifierId cannot be null or empty");
        RequestBuilder requestBuilder = RequestBuilder.delete(String.format(PATH_CLASSIFIER, new Object[]{classifierId}));
        requestBuilder.query(new Object[]{"version", this.versionDate});
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getVoid());
    }

    public ServiceCall<DetectedFaces> detectFaces(VisualRecognitionOptions options) {
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (options.url() != null) {
            bodyBuilder.addFormDataPart(PARAM_PARAMETERS, getParametersAsJson(options).toString());
        } else {
            bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.images().getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.images()));
        }
        RequestBuilder requestBuilder = RequestBuilder.post(PATH_DETECT_FACES);
        requestBuilder.query(new Object[]{"version", this.versionDate}).body(bodyBuilder.build());
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(DetectedFaces.class));
    }

    public ServiceCall<VisualClassifier> getClassifier(String classifierId) {
        boolean z;
        if (classifierId == null || classifierId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "classifierId cannot be null or empty");
        RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_CLASSIFIER, new Object[]{classifierId}));
        requestBuilder.query(new Object[]{"version", this.versionDate});
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(VisualClassifier.class));
    }

    public ServiceCall<List<VisualClassifier>> getClassifiers() {
        RequestBuilder requestBuilder = RequestBuilder.get(PATH_CLASSIFIERS).query(new Object[]{"version", this.versionDate}).query(new Object[]{VERBOSE, Boolean.valueOf(true)});
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getGenericObject(TYPE_LIST_CLASSIFIERS, PARAM_CLASSIFIERS));
    }

    public ServiceCall<RecognizedText> recognizeText(VisualRecognitionOptions options) {
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (options.url() != null) {
            bodyBuilder.addFormDataPart(PARAM_PARAMETERS, getParametersAsJson(options).toString());
        } else {
            bodyBuilder.addFormDataPart(PARAM_IMAGES_FILE, options.images().getName(), RequestBody.create(HttpMediaType.BINARY_FILE, options.images()));
        }
        RequestBuilder requestBuilder = RequestBuilder.post(PATH_RECOGNIZE_TEXT);
        requestBuilder.query(new Object[]{"version", this.versionDate}).body(bodyBuilder.build());
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(RecognizedText.class));
    }

    @Deprecated
    public void setUsernameAndPassword(String username, String password) {
        throw new IllegalArgumentException("This service requires an api_key. Use the setApiKey() method instead");
    }
}
