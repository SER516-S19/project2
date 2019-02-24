package content.creator.constants;

import java.util.Arrays;
import java.util.List;

public final class Constants {

  private Constants() {}

  public static final List<String> colNames =
      Arrays.asList(
          "quiz_id",
          "ques_id",
          "ques_type",
          "ques_desc",
          "ans_id",
          "ans_desc",
          "is_correct",
          "max_score");
}
