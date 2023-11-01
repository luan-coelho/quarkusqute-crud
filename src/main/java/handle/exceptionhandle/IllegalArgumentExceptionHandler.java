package handle.exceptionhandle;

import exception.ErrorResponse;
import org.jboss.resteasy.reactive.RestResponse;

public class IllegalArgumentExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle(getTitle());
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(getStatus());
    }

    @Override
    public Class<? extends Exception> getExceptionType() {
        return IllegalArgumentException.class;
    }

    @Override
    public String getTitle() {
        return "Validation Error";
    }

    @Override
    public int getStatus() {
        return RestResponse.StatusCode.BAD_REQUEST;
    }
}
