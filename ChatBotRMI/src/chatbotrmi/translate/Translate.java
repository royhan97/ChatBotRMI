/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotrmi.translate;

import static chatbotrmi.translate.YandexTranslatorAPI.ENCODING;
import static chatbotrmi.translate.YandexTranslatorAPI.PARAM_API_KEY;
import static chatbotrmi.translate.YandexTranslatorAPI.PARAM_LANG_PAIR;
import static chatbotrmi.translate.YandexTranslatorAPI.PARAM_TEXT;
import static chatbotrmi.translate.YandexTranslatorAPI.apiKey;
import static chatbotrmi.translate.YandexTranslatorAPI.retrievePropArrString;
import common.SaySomething;
import java.net.URL;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roy
 */
  public class Translate extends UnicastRemoteObject implements SaySomething {
  private static final String SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
  private static final String TRANSLATION_LABEL = "text";

  //prevent instantiation
  public Translate() throws RemoteException{};
  
    /**
   * Sets the API key.
   * @param pKey The API key.
   */
  public static void setKey(final String pKey) {
    apiKey = pKey;
  }

  /**
   * Translates text from a given Language to another given Language using Yandex.
   * 
   * @param text The String to translate.
   * @param from The language code to translate from.
   * @param to The language code to translate to.
   * @return The translated String.
   * @throws Exception on error.
   */
  public static String execute(final String text, final Language from, final Language to) throws Exception {
    validateServiceState(text); 
    final String params = 
        PARAM_API_KEY + URLEncoder.encode(apiKey,ENCODING) 
        + PARAM_LANG_PAIR + URLEncoder.encode(from.toString(),ENCODING) + URLEncoder.encode("-",ENCODING) + URLEncoder.encode(to.toString(),ENCODING) 
        + PARAM_TEXT + URLEncoder.encode(text,ENCODING);
    final URL url = new URL(SERVICE_URL + params);
    System.out.println(url);
    return retrievePropArrString(url, TRANSLATION_LABEL).trim();
  }

    //Check if ready to make request, if not, throw a RuntimeException
  protected static void validateServiceState() throws Exception {
    if(apiKey==null||apiKey.length()<27) {
      throw new RuntimeException("INVALID_API_KEY - Please set the API Key with your Yandex API Key");
    }
  } 
  
  private static void validateServiceState(final String text) throws Exception {
    final int byteLength = text.getBytes(ENCODING).length;
    if(byteLength>10240) { // TODO What is the maximum text length allowable for Yandex?
      throw new RuntimeException("TEXT_TOO_LARGE");
    }
    validateServiceState();
  }
  
  
    @Override
    public String saySomething(String text) throws RemoteException {
      try {
          Translate.setKey(ApiKeys.YANDEX_API_KEY);
          String translate = execute(text, Language.ENGLISH, Language.INDONESIA);
          return translate;
      } catch (Exception ex) {
          Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
      }
      return "terjadi ksalahan";
    }

}
