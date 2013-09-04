/**
 * SWFCompressor is (c) 2006 Paul Brooks Andrus and is released under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 */
package com.supertool.dspui.util.material.swf;

import java.io.*;
import java.util.zip.*;

/**
 * @author brooks
 *
 */
public class SWFCompressor extends SWFCompression
{

   /**
    * 
    */
   public SWFCompressor()
   {
      
   }
   
   public SWFCompressor( String name )
   {
      File file = new File( name );
      readFile( file );
   }
   
   public SWFCompressor( File file )
   {
      readFile( file );
   }
   
   private void readFile( File file )
   {
      FileInputStream fis = null;
      FileOutputStream fout = null;
      
      byte[] swf  = new byte[ readFullSize( file ) ];
      
      try
      {
         fis = new FileInputStream( file );
         fis.read( swf );
         fis.close();

         byte[] temp = compress( swf );

         fout = new FileOutputStream( file.getAbsoluteFile() );
         fout.write( temp );
         fout.flush();
         fout.close();
      }
      catch ( IOException e )
      {
         e.printStackTrace();
      }
   }
   
   public byte[] compress( byte[] bytes )
   {
      Deflater compressor = new Deflater( Deflater.BEST_COMPRESSION );
      compressor.setInput( strip( bytes ) );
      compressor.finish();
      
      ByteArrayOutputStream stream = new ByteArrayOutputStream( bytes.length - 8 );//create an expandable byte array container
      
      byte[] buffer = new byte[1024];
      while( !compressor.finished() )
      {
         int count = compressor.deflate( buffer );
         stream.write( buffer, 0, count );
      }
      try
      {
         stream.close();
      }
      catch( IOException e )
      {
         e.printStackTrace();
      }
      
      //create a byte array that will contain the uncompressed header and the compressed data
      byte[] swf = new byte[8 + stream.size()];
      //the first 8 bytes of the header are uncompressed
      System.arraycopy( bytes, 0, swf, 0, 8 );
      //copy the compressed data from the temporary byte array to its new byte array
      System.arraycopy( stream.toByteArray(), 0, swf, 8, stream.size() );
      //the first byte of the swf indicates whether the swf is compressed or not
      swf[0] = 67;
      
      return swf;
   }

   /**
    * @param args
    */
   public static void main( String[] args )
   {
      if ( args.length != 1 )
      {
         System.err.println( "Usage: swf_file" );
      }
      else
      {
         new SWFCompressor( args[0] );  
      }
   }

}
