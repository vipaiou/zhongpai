package com.supertool.dspui.util.material.swf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SWFCompression
{
   
   public int readFullSize( File file )
   {
      byte[] temp = new byte[8];
      
      try
      {
         FileInputStream fis = new FileInputStream( file );
         fis.read( temp );
         fis.close();
      }
      catch ( IOException e )
      {
         System.err.println( e );
      }
      return readSize( temp );
   }
   
   public int readSize( byte[] bytes )
   {
      int s = 0;
      for ( int i = 0; i < 4; i++ )
      {
         s = ( s << 8 ) + bytes[i + 4];
      }

      s = Integer.reverseBytes( s ) - 1;

      return s;
   }
   
   /**
    * Strips the uncompressed header bytes from a swf file byte array
    * @param bytes
    * @return an array of bytes representing a swf file minus the uncompressed header bytes
    */
   public byte[] strip( byte[] bytes )
   {
      byte[] compressable = new byte[bytes.length - 8];
      System.arraycopy( bytes, 8, compressable, 0, bytes.length - 8 );//fills a byte array with data needing decompression
      return compressable;
   }

}
