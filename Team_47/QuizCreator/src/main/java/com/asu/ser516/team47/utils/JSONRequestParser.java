package com.asu.ser516.team47.utils;

import javax.servlet.http.HttpServletRequest;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Because HttpServletRequest doesn't natively handle json forms,
 * this utility was created to parse those out.
 * Made with https://stackoverflow.com/questions/3831680/httpservletrequest-get-json-post-data as a reference
 *
 * @author David Lahtinen
 * @version 1.0
 * @since 02/26/19
 */
public class JSONRequestParser {

    /**
     *  Parses json object from HttpRequest
     *
     * @param req an HTTP request with a JSON form.
     * @return JSONObject of the form.
     * @throws IOException If there is a problem with accessing the form
     * @throws ParseException If there is a problem with parsing the form
     */
    public static JSONObject getJsonFromRequest(HttpServletRequest req) throws IOException, ParseException {
        BufferedReader bufReader = req.getReader();
        StringBuilder strBldr = new StringBuilder();
        String line;
        while ((line = bufReader.readLine()) != null) {
            strBldr.append(line);
            System.out.println(line);
        }

        return (JSONObject) new JSONParser().parse(strBldr.toString());
    }
}