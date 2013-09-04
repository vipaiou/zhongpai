/**
 * SWFDecompressor is (c) 2006 Paul Brooks Andrus and is released under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 */
package com.supertool.dspui.util.material.swf;

import java.io.*;
import java.util.zip.*;

/**
 * @author brooks
 *
 */
public class SWFDecompressor extends SWFCompression
{ 
   public SWFDecompressor() 
   {
      
   }
   
   public SWFDecompressor( String name )
   {
      File file = new File( name );
      readFile( file );
   }
   
   public SWFDecompressor( File file )
   {
      readFile( file );
   }
   
   private void readFile( File file ) 
   {
      FileInputStream fis   = null;
      FileOutputStream fout = null;
      byte[] swf            = new byte[ readFullSize( file ) ];
      try
      {
         fis = new FileInputStream( file );
         fis.read( swf );
         fis.close();
         
         byte[] decomp = uncompress( swf );
         
         fout = new FileOutputStream( file.getAbsoluteFile() );
         fout.write( decomp );
         fout.flush();
         fout.close();
         
      }
      catch ( IOException e )
      {
         System.err.println( e );
      }
      catch ( DataFormatException dfe )
      {
         System.err.println( dfe );
      }
   }
   
   public byte[] uncompress( byte[] bytes ) throws DataFormatException
   {  
      Inflater decompressor = new Inflater();
      decompressor.setInput( strip( bytes ) );//feed the Inflater the bytes
      
      ByteArrayOutputStream stream = new ByteArrayOutputStream( bytes.length - 8 );//an expandable byte array to store the uncompressed data
      
      byte[] buffer = new byte[1024];
      while ( !decompressor.finished() )//read until the end of the stream is found
      {
         try
         {
            int count = decompressor.inflate( buffer );//decompress the data into the buffer
            stream.write( buffer, 0, count );
         }
         catch( DataFormatException dfe )
         {
            dfe.printStackTrace();
         }
      }
      try
      {
         stream.close();
      }
      catch( IOException e )
      {
         e.printStackTrace();
      }
      
      //create an array to hold the header and body bytes
      byte[] swf = new byte[ 8 + stream.size() ];
      //copy the first 8 bytes which are uncompressed into the swf array
      System.arraycopy( bytes, 0, swf, 0, 8 );
      //copy the uncompressed data into the swf array
      System.arraycopy( stream.toByteArray(), 0, swf, 8, stream.size() );
      //the first byte of the swf indicates whether the swf is compressed or not
      swf[0] = 70;
      
      return swf;
   }
   
   
   public static void main( String[] args )
   {
     if ( args.length != 1 )
     {
        System.err.println( "Usage: swf_file" );
     }
     else
     {
        new SWFDecompressor( args[0] );
     }
   }
   
}
