package helper;

import java.io.File;

public class Utility extends BaseTest {

  public static File getListJsonSchema(String schema) {
    return new File("src/test/java/helper/JSONSchema/" + schema);
  }
}
