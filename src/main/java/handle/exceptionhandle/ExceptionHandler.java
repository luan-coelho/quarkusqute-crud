package handle.exceptionhandle;

import exception.ErrorResponse;

public interface ExceptionHandler {

    void handleException(Exception exception, ErrorResponse errorResponse);

    Class<? extends Exception> getExceptionType();

    String getTitle();

    int getStatus();
}
