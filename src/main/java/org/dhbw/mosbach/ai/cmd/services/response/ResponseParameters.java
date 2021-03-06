package org.dhbw.mosbach.ai.cmd.services.response;

/**
 * @author 6694964
 * @version 1.1
 */
public abstract class ResponseParameters {

    private ResponseParameters() {
    }

    public static final String HTTP_STATUS = "status";

    public static final String STATUS_CODE = "code";

    public static final String STATUS_DESCRIPTION = "description";

    public static final String MESSAGE = "message";

    public static final String DOCUMENT = "document";

    public static final String DOCUMENT_LIST = "documents";

    public static final String DOCUMENT_ICON = "icon";

    public static final String COLLABORATOR_LIST = "collaborators";

    public static final String USER = "user";
}
