package com.example.libs;


import java.io.PrintStream;
import java.util.Arrays;
import com.example.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class myClass
{
  //设置秘钥
  private static final int[] key = { null };
  static TEAUtil teaUtil = new TEAUtil();

  public static String decryCode(String str)
  {
    System.out.println(Arrays.toString(key));
    String str2 = null;
    try
    {
      byte[] decryptBASE64 = Base64.decryptBASE64(str);
      if (decryptBASE64 != null) {
        str2 = teaUtil.decryptByTea(decryptBASE64, key);

      }
    }
    catch (Exception localException) {}
    return str2;
  }

  public static String encryCode(String str)
  {
    try
    {
      str = Base64.encryptBASE64(teaUtil.encryptByTea(str, key)).replaceAll("\n|\r", "");

    }
    catch (Exception localException) {}
    return str;
  }
  public static String decode(String url)
	{
			try {
				String prevURL="";
				String decodeURL=url;
				while(!prevURL.equals(decodeURL))
				{
					prevURL=decodeURL;
					decodeURL=URLDecoder.decode( decodeURL, "UTF-8" );
				}
				return decodeURL;
			} catch (UnsupportedEncodingException e) {
				return "Issue while decoding" +e.getMessage();
			}
	}

	public static String encode(String url)
	{
			try {
				String encodeURL=URLEncoder.encode( url, "UTF-8" );
				return encodeURL;
			} catch (UnsupportedEncodingException e) {
				return "Issue while encoding" +e.getMessage();
			}
	}
  public static void main(String[] args)
  {
    //String str = "123456";

  //  String s1 = encryCode(str);

    //System.out.println(s1);

    //String s2 = "1LN2lnXSe8IlpyUe3rJRVnvf1Wgr94FH9JGDTJvQNKGszZHZjwRd7SOnG8iCpyk9r93j3/6RGE3ZJWhUbXbN+8UElDQ+3TdgBfieohqcK0dEfjDlwM9RoBB5Dl4VFWb8Tn8Itaypni4QlTnvTD202WZsuwujlbxFzefT0RI/u7o7cOtpiCNf5CVRJzKemMjWAWuMCDZ3Sa1AlBSPbFOGD0OJ/OAGU/fkY6UifzHlEMrhKwOOP7O5X6Bn/lRECLqlpK+5gD1pOQBNBMd+k0fYkxgRpd9dw09HYv7cbkY8APIQlTnvTD202VYnWNZWJ0uXVouhB79wGw0BGC1Y4tTpCPeESN+adhn8YmZrROPKakfnGurTh/QlLUdFO0jgJCcpZsHRhOCCZbONMDlHevcR32h0gUqQiiM6k637+/rVnroUCI4uLGPg+MXbQZAxYUJwgiBF0OrakDw3av4Q3RGIn1hilADiW+25pA3umROUXxXZgojf9/SbhN5SX4/o/ptoNSzollKH7gMXtDNOp0H3NCBKrYVj0tN5/3XcxPVp5lQDaeHuSLaIeW+jZbNQ8/xPMNanMNYD0lOPKOusTMWmWkaeV5skVM2AeFIv/uNDjXlwRpdsLQJ9ZQ==";

    //String str3 = decryCode(s2);
   // System.out.print(str3);

    //String utf8 = new String(result.getBytes( "UTF-8"));
    //String url="https%3A%2F%2Fr1---sn-ci5gup-cags.googlevideo.com%2Fvideoplayback%3Fpcm2cms%3Dyes%26mime%3Dvideo%252Fmp4%26pl%3D21%26itag%3D22%26\u0026itag=43\u0026type=video%2Fwebm%3B+codecs%3D%22vp8.0%2C+vorbis%22\u0026quality=medium";
    //String decodeURL = decode(url);
    //System.out.print(decodeURL);

  }

}