public interface Counter {

  /**
   * @param input String to count the words
   * @return number of words filtered by [a-zA-Z]+ OR zero if input is null or blank
   * */
  long getCount(String input);

}
