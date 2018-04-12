package com.example.libs;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64
{
  public String bytesToHex(byte[] bytes)
  {
    StringBuffer md5str = new StringBuffer();
    for (int i = 0; i < bytes.length; i++)
    {
      int digital = bytes[i];
      if (digital < 0) {
        digital += 256;
      }
      if (digital < 16) {
        md5str.append("0");
      }
      md5str.append(Integer.toHexString(digital));
    }
    return md5str.toString().toUpperCase();
  }
  
  public static byte[] decryptBASE64(String key)
    throws Exception
  {
    return new BASE64Decoder().decodeBuffer(key);
  }
  
  public static String encryptBASE64(byte[] key)
    throws Exception
  {
    BASE64Encoder encoder = new BASE64Encoder();
    
    return encoder.encodeBuffer(key);
  }
  
  public static String encryptCode(String code)
  {
    try
    {
      byte[] codeByte = code.getBytes();
      return encryptBASE64(codeByte);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public static String deciphering(String code)
  {
    try
    {
      byte[] deciphering = decryptBASE64(code);
      return new String(deciphering);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "";
  }
}
