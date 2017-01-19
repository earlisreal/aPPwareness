package com.ibm.watson.developer_cloud.dialog.v1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationData;
import com.ibm.watson.developer_cloud.dialog.v1.model.ConversationDataOptions;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.dialog.v1.model.DialogContent;
import com.ibm.watson.developer_cloud.dialog.v1.model.NameValue;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import java.io.File;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;

@Deprecated
public class DialogService extends WatsonService {
    private static final String CLIENT_ID = "client_id";
    private static final String CONVERSATIONS = "conversations";
    private static final String CONVERSATION_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String CONVERSATION_ID = "conversation_id";
    private static final SimpleDateFormat DATE_FORMATTER;
    private static final String DATE_FROM = "date_from";
    private static final String DATE_TO = "date_to";
    private static final String DIALOGS = "dialogs";
    private static final String FILE = "file";
    private static final Gson GSON;
    private static final String INPUT = "input";
    private static final String ITEMS = "items";
    private static final String LIMIT = "limit";
    private static final String NAME = "name";
    private static final String NAME_VALUES = "name_values";
    private static final String OFFSET = "offset";
    private static final String PATH_DIALOG = "/v1/dialogs/%s";
    private static final String PATH_DIALOGS = "/v1/dialogs";
    private static final String PATH_DIALOG_CONTENT = "/v1/dialogs/%s/content";
    private static final String PATH_DIALOG_CONVERSATION = "/v1/dialogs/%s/conversation";
    private static final String PATH_PROFILE = "/v1/dialogs/%s/profile";
    private static final String SERVICE_NAME = "dialog";
    private static final String URL = "https://gateway.watsonplatform.net/dialog/api";
    private static final Type listConversationDataType;
    private static final Type listDialogContentType;
    private static final Type listDialogType;
    private static final Type listNameValueType;

    static {
        DATE_FORMATTER = new SimpleDateFormat(CONVERSATION_DATE_FORMAT);
        GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
        listConversationDataType = new 1().getType();
        listDialogContentType = new 2().getType();
        listDialogType = new 3().getType();
        listNameValueType = new 4().getType();
    }

    public DialogService() {
        super(SERVICE_NAME);
        setEndPoint(URL);
    }

    public DialogService(String username, String password) {
        this();
        setUsernameAndPassword(username, password);
    }

    private Map<String, String> fromNameValues(List<NameValue> nameValues) {
        Map<String, String> profile = new HashMap();
        for (NameValue nameValue : nameValues) {
            profile.put(nameValue.getName(), nameValue.getValue());
        }
        return profile;
    }

    private List<NameValue> toNameValue(Map<String, String> profile) {
        List<NameValue> nameValues = new ArrayList();
        for (String key : profile.keySet()) {
            nameValues.add(new NameValue(key, (String) profile.get(key)));
        }
        return nameValues;
    }

    public ServiceCall<Conversation> converse(Conversation conversation, String newMessage) {
        boolean z;
        Validator.notNull(conversation, "conversation cannot be null");
        if (conversation.getDialogId() == null || conversation.getDialogId().isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "conversation.dialogId cannot be null or empty");
        RequestBuilder requestBuilder = RequestBuilder.post(String.format(PATH_DIALOG_CONVERSATION, new Object[]{conversation.getDialogId()}));
        requestBuilder.form(new Object[]{CONVERSATION_ID, conversation.getId()});
        requestBuilder.form(new Object[]{CLIENT_ID, conversation.getClientId()});
        requestBuilder.form(new Object[]{INPUT, newMessage});
        return createServiceCall(requestBuilder.build(), new 5(this, conversation));
    }

    public ServiceCall<Conversation> createConversation(String dialogId) {
        Conversation conversation = new Conversation();
        conversation.setDialogId(dialogId);
        return converse(conversation, null);
    }

    public ServiceCall<Dialog> createDialog(String name, File dialogFile) {
        boolean z;
        boolean z2 = true;
        if (name == null || name.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "name cannot be null or empty");
        if (dialogFile == null || !dialogFile.exists()) {
            z2 = false;
        }
        Validator.isTrue(z2, "dialogFile cannot be null or inexistent");
        return createServiceCall(RequestBuilder.post(PATH_DIALOGS).body(new Builder().setType(MultipartBody.FORM).addFormDataPart(FILE, dialogFile.getName(), RequestBody.create(HttpMediaType.BINARY_FILE, dialogFile)).addFormDataPart(NAME, name).build()).build(), ResponseConverterUtils.getObject(Dialog.class));
    }

    public ServiceCall<Void> deleteDialog(String dialogId) {
        boolean z;
        if (dialogId == null || dialogId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "dialogId cannot be null or empty");
        return createServiceCall(RequestBuilder.delete(String.format(PATH_DIALOG, new Object[]{dialogId})).build(), ResponseConverterUtils.getVoid());
    }

    public ServiceCall<List<DialogContent>> getContent(String dialogId) {
        boolean z;
        if (dialogId == null || dialogId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "dialogId cannot be null or empty");
        return createServiceCall(RequestBuilder.get(String.format(PATH_DIALOG_CONTENT, new Object[]{dialogId})).build(), ResponseConverterUtils.getGenericObject(listDialogContentType, ITEMS));
    }

    public ServiceCall<List<ConversationData>> getConversationData(ConversationDataOptions options) {
        Validator.notNull(options, "options cannot be null");
        boolean z = (options.dialogId() == null || options.dialogId().isEmpty()) ? false : true;
        Validator.isTrue(z, "options.dialogId cannot be null or empty");
        Validator.notNull(options.from(), "options.from cannot be null");
        Validator.notNull(options.to(), "options.to cannot be null");
        if (options.from().after(options.to())) {
            throw new IllegalArgumentException("options.from is greater than options.to");
        }
        String fromString = DATE_FORMATTER.format(options.from());
        String toString = DATE_FORMATTER.format(options.to());
        RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_DIALOG_CONVERSATION, new Object[]{options.dialogId()})).query(new Object[]{DATE_FROM, fromString, DATE_TO, toString});
        if (options.offset() != null) {
            requestBuilder.query(new Object[]{OFFSET, options.offset()});
        }
        if (options.limit() != null) {
            requestBuilder.query(new Object[]{LIMIT, options.limit()});
        }
        return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getGenericObject(listConversationDataType, CONVERSATIONS));
    }

    public ServiceCall<List<Dialog>> getDialogs() {
        return createServiceCall(RequestBuilder.get(PATH_DIALOGS).build(), ResponseConverterUtils.getGenericObject(listDialogType, DIALOGS));
    }

    public ServiceCall<Map<String, String>> getProfile(Conversation conversation, String... names) {
        Validator.notNull(conversation, "conversation cannot be null");
        return getProfile(conversation.getDialogId(), conversation.getClientId(), names);
    }

    public ServiceCall<Map<String, String>> getProfile(String dialogId, Integer clientId, String... names) {
        boolean z;
        if (dialogId == null || dialogId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "dialogId cannot be null or empty");
        Validator.notNull(clientId, "clientId cannot be null");
        RequestBuilder requestBuilder = RequestBuilder.get(String.format(PATH_PROFILE, new Object[]{dialogId})).query(new Object[]{CLIENT_ID, clientId});
        if (names != null) {
            for (String name : names) {
                requestBuilder.query(new Object[]{NAME, name});
            }
        }
        return createServiceCall(requestBuilder.build(), new 6(this));
    }

    public ServiceCall<Void> updateDialog(String dialogId, File dialogFile) {
        boolean z;
        if (dialogId == null || dialogId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "dialogId cannot be null or empty");
        if (dialogFile == null || !dialogFile.exists()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "dialogFile cannot be null or inexistent");
        return createServiceCall(RequestBuilder.put(String.format(PATH_DIALOG, new Object[]{dialogId})).body(new Builder().setType(MultipartBody.FORM).addFormDataPart(FILE, dialogFile.getName(), RequestBody.create(HttpMediaType.BINARY_FILE, dialogFile)).build()).build(), ResponseConverterUtils.getVoid());
    }

    public ServiceCall<Void> updateProfile(Conversation conversation, Map<String, String> profile) {
        Validator.notNull(conversation, "conversation cannot be null");
        return updateProfile(conversation.getDialogId(), conversation.getClientId(), profile);
    }

    public ServiceCall<Void> updateProfile(String dialogId, Integer clientId, Map<String, String> profile) {
        boolean z;
        if (dialogId == null || dialogId.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "dialogId cannot be null or empty");
        if (profile == null || profile.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Validator.isTrue(z, "profile cannot be null or empty");
        JsonObject contentJson = new JsonObject();
        if (clientId != null) {
            contentJson.addProperty(CLIENT_ID, clientId);
        }
        contentJson.add(NAME_VALUES, GSON.toJsonTree(toNameValue(profile)));
        return createServiceCall(RequestBuilder.put(String.format(PATH_PROFILE, new Object[]{dialogId})).bodyJson(contentJson).build(), ResponseConverterUtils.getVoid());
    }
}
