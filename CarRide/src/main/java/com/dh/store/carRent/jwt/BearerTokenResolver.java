package com.dh.store.carRent.jwt;

import jakarta.servlet.http.HttpServletRequest;

public interface BearerTokenResolver {
    String resolve(HttpServletRequest request);
}