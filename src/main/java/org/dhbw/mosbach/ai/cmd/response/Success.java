package org.dhbw.mosbach.ai.cmd.response;

import javax.ws.rs.core.Response;

public class Success extends ResponseObject {

    public Success() {
        super(Response.Status.OK);
    }
}
