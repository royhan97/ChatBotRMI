/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotrmi.translate;

/**
 *
 * @author roy
 */
public enum Language {
    
  ALBANIAN("sq"),
  ARMENIAN("hy"),
  AZERBAIJANI("az"),
  BELARUSIAN("be"),
  BULGARIAN("bg"),
  CATALAN("ca"),
  CROATIAN("hr"),
  CZECH("cs"),
  DANISH("da"),
  DUTCH("nl"),
  ENGLISH("en"),
  ESTONIAN("et"),
  FINNISH("fi"),
  FRENCH("fr"),
  GERMAN("de"),
  GEORGIAN("ka"),
  GREEK("el"),
  HUNGARIAN("hu"),
  INDONESIA("id"),
  ITALIAN("it"),
  LATVIAN("lv"),
  LITHUANIAN("lt"),
  MACEDONIAN("mk"),
  NORWEGIAN("no"),
  POLISH("pl"),
  PORTUGUESE("pt"),
  ROMANIAN("ro"),
  RUSSIAN("ru"),
  SERBIAN("sr"),
  SLOVAK("sk"),
  SLOVENIAN("sl"),
  SPANISH("es"),
  SWEDISH("sv"),
  TURKISH("tr"),
  UKRAINIAN("uk");

  /**
   * String representation of this language.
   */
  private final String language;

  /**
   * Enum constructor.
   * @param pLanguage The language identifier.
   */
  private Language(final String pLanguage) {
    language = pLanguage;
  }

  public static Language fromString(final String pLanguage) {
    for (Language l : values()) {
      if (l.toString().equals(pLanguage)) {
        return l;
      }
    }
    return null;
  }

  /**
   * Returns the String representation of this language.
   * @return The String representation of this language.
   */
  @Override
  public String toString() {
    return language;
  }
    
}
