package com.asu.ser516.team47.servlet;

import com.asu.ser516.team47.database.Question;
import com.asu.ser516.team47.utils.JSONRequestParser;
import com.asu.ser516.team47.utils.ServletValidation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Endpoint for professor to create a quiz.
 *
 * @author David Lahtinen
 * @version 1.0
 * @since 02/28/19
 */
@WebServlet(name = "QuizCreationServlet")
public class QuizCreationServlet extends HttpServlet {
    private String title = null;
    private Integer course_id = null;
    private String instructions = null;
    private Boolean shuffle = null;
    private Integer time_limit = null;
    private Date date_open = null;
    private Date date_close = null;
    private String quiz_type = null;
    private Integer attempts = null;
    private String quiz_group = null;
    private Double total_points = null;
    private JSONArray jsonQuestions = null;
    private List<Question> questions = new ArrayList<>();
    private Map<Question, List<JSONObject>> choiceJsonsForQuestions = new HashMap<>();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        JSONObject jsonQuiz = null;

        //Validate all required fields are present
        try {
            jsonQuiz = JSONRequestParser.getJsonFromRequest(req);
        } catch (ParseException pe){
            res.sendError(400, "Could not parse form");
            return;
        }
        //as close date is optional, verify separately
        try {
            String dateStr = (String) jsonQuiz.get("date_open");
            Calendar cal = javax.xml.bind.DatatypeConverter.parseDateTime(dateStr);
            date_open = cal.getTime();
            dateStr = (String) jsonQuiz.get("date_close");
            cal = javax.xml.bind.DatatypeConverter.parseDateTime(dateStr);
            date_close = cal.getTime();
        } catch (ClassCastException ex) {
            res.sendError(400, "Invalid format for dates.");
        } catch (NullPointerException npe) {
            //Date not included.
        }
        if (date_open == null) date_open = new Date();
    }

    /**
     * Checks validity and presence of quiz fields
     *
     * @param jsonQuiz
     * @return whether all required fields are present and valid
     */
    private boolean validateQuizFields(JSONObject jsonQuiz){
        try{
            title = (String)jsonQuiz.get("title");
            course_id = ((Long)jsonQuiz.get("course_id")).intValue();
            instructions = (String)jsonQuiz.get("instructions");
            shuffle = (Boolean)jsonQuiz.get("shuffle");
            time_limit = ((Long)jsonQuiz.get("time_limit")).intValue();
            quiz_type = (String)jsonQuiz.get("quiz_type");
            if (!(quiz_type.equals("quiz") || quiz_type.equals("survey"))) {
                return false;
            }
            attempts = ((Long)jsonQuiz.get("attempts")).intValue();
            quiz_group = (String)jsonQuiz.get("quiz_group");
            total_points = (Double)jsonQuiz.get("totalPoints");
            jsonQuestions = (JSONArray)jsonQuiz.get("questions");
        } catch (ClassCastException ex) {
            return false;
        }
        if (title == null || course_id == null || instructions == null || shuffle == null ||
                quiz_group == null || total_points == null || questions == null){
            return false;
        }
        try {
            return ServletValidation.validateQuestionArray(jsonQuestions);
        } catch (IOException ioe) {
            return false;
        }
    }
}


