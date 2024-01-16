package org.equipe.utils;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;



@ApplicationScoped
public class UtilsHelpers {
    public static String decodeURLParameter(String parameter) {
        try {
            return URLDecoder.decode(parameter, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Erro ao decodificar o parâmetro da URL", e);
        }
    }
}
