package content.creator.constants;

import java.util.Arrays;
import java.util.List;

public final class Constants {

  private Constants() {}

  public static final List<String> colNames =
      Arrays.asList(
          "quizId",
          "quesId",
          "quesType",
          "quesDesc",
          "ansId",
          "ansDesc",
          "isCorrect",
          "maxScore");
}
