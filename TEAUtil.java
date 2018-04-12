package com.example.libs;


import java.io.UnsupportedEncodingException;

public class TEAUtil
{
  private int[] byteToInt(byte[] arg6, int arg7)
  {
    int v4 = 2;
    int[] v1 = new int[v4];
    int v0 = 0;
    while (arg7 < arg6.length)
    {
      if (v0 >= v4) {
        return v1;
      }
      v1[v0] = (transform(arg6[(arg7 + 3)]) | transform(arg6[(arg7 + 2)]) << 8 | transform(arg6[(arg7 + 1)]) << 16 | arg6[arg7] << 24);
      v0++;
      arg7 += 4;
    }
    return v1;
  }
  
  public byte[] decrypt(byte[] arg14, int arg15, int[] arg16, int arg17)
  {
    int[] v5 = byteToInt(arg14, arg15);
    int v4 = v5[0];
    int v3 = v5[1];
    int v2 = -957401312;
    int v6 = -1640531527;
    int v7 = arg16[0];
    int v8 = arg16[1];
    int v9 = arg16[2];
    int v10 = arg16[3];
    for (int v1 = 0; v1 < arg17; v1++)
    {
      v3 -= ((v4 << 4) + v9 ^ v4 + v2 ^ (v4 >> 5) + v10);
      v4 -= ((v3 << 4) + v7 ^ v3 + v2 ^ (v3 >> 5) + v8);
      v2 -= v6;
    }
    v5[0] = v4;
    v5[1] = v3;
    return intToByte(v5, 0);
  }
  
  public String decryptByTea(byte[] arg7, int[] arg8)
  {
    int v2 = arg7.length;
    byte[] v3 = new byte[v2];
    for (int v0 = 0; v0 < arg7.length; v0 += 8) {
      System.arraycopy(decrypt(arg7, v0, arg8, 32), 0, v3, v0, 8);
    }
    return new String(v3, v3[0], v2 - v3[0]);
  }
  
  public byte[] encrypt(byte[] arg14, int arg15, int[] arg16, int arg17)
  {
    int[] v5 = byteToInt(arg14, arg15);
    int v4 = v5[0];
    int v3 = v5[1];
    int v2 = 0;
    int v6 = -1640531527;
    int v7 = arg16[0];
    int v8 = arg16[1];
    int v9 = arg16[2];
    int v10 = arg16[3];
    for (int v1 = 0; v1 < arg17; v1++)
    {
      v2 += v6;
      v4 += ((v3 << 4) + v7 ^ v3 + v2 ^ (v3 >> 5) + v8);
      v3 += ((v4 << 4) + v9 ^ v4 + v2 ^ (v4 >> 5) + v10);
    }
    v5[0] = v4;
    v5[1] = v3;
    return intToByte(v5, 0);
  }
  
  public byte[] encryptByTea(String arg7, int[] arg8)
    throws UnsupportedEncodingException
  {
    byte[] v0 = arg7.getBytes();
    int v2 = 8 - v0.length % 8;
    byte[] v3 = new byte[v0.length + v2];
    v3[0] = ((byte)v2);
    System.arraycopy(v0, 0, v3, v2, v0.length);
    byte[] v2_1 = new byte[v3.length];
    for (int v0_1 = 0; v0_1 < v2_1.length; v0_1 += 8) {
      System.arraycopy(encrypt(v3, v0_1, arg8, 32), 0, v2_1, v0_1, 8);
    }
    return v2_1;
  }
  
  private byte[] intToByte(int[] arg5, int arg6)
  {
    byte[] v1 = new byte[8];
    int v0 = 0;
    while (arg6 < v1.length)
    {
      if (v0 >= 2) {
        return v1;
      }
      v1[(arg6 + 3)] = ((byte)(arg5[v0] & 0xFF));
      v1[(arg6 + 2)] = ((byte)(arg5[v0] >> 8 & 0xFF));
      v1[(arg6 + 1)] = ((byte)(arg5[v0] >> 16 & 0xFF));
      v1[arg6] = ((byte)(arg5[v0] >> 24 & 0xFF));
      v0++;
      arg6 += 4;
    }
    return v1;
  }
  
  private int transform(byte b)
  {
    return b < 0 ? b + 256 : b;
  }
}
