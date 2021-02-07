package com.github.ramonrz.config;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.github.ramonrz.dto.ErrorDto;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return Response.status(INTERNAL_SERVER_ERROR)
                .entity(ErrorDto.builder().message(e.getMessage())
                .code(INTERNAL_SERVER_ERROR.getStatusCode())
                .build())
                .build();
    }

}