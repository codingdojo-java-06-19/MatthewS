public class StringManipulator {
  public String trimAndConcat(String string1, String string2) {
    String concat = string1.trim() + string2.trim();
    return concat;
  }

  public Integer getIndexOrNull(String str, char ch) {
    if (str.indexOf(ch) >= 0) {
      return str.indexOf(ch);
    } else {
      return null;
    }
  }

  public Integer getIndexOrNull(String str1, String str2) {
    if (str1.indexOf(str2) >= 0) {
      return str1.indexOf(str2);
    } else {
      return null;
    }
  }

  public String concatSubstring(String str1, int in1, int int2, String str2) {
    String sub = str1.substring(1, 2);
    return sub + str2;
  }
}