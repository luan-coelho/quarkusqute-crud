package handle.exceptionhandle;

import exception.ErrorResponse;
import org.jboss.resteasy.reactive.RestResponse;

public class GenericExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle(getTitle());
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(getStatus());
    }

    @Override
    public Class<? extends Exception> getExceptionType() {
        return Exception.class;
    }

    @Override
    public String getTitle() {
        return "Internal Server Error";
    }

    @Override
    public int getStatus() {
        return RestResponse.StatusCode.INTERNAL_SERVER_ERROR;
    }
}
