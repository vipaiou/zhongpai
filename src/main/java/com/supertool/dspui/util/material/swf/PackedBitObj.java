/**
 * PackedBitObj is (c) 2006 Paul Brooks Andrus and is released under the MIT License:
 * http://www.opensource.org/licenses/mit-license.php
 */

package com.supertool.dspui.util.material.swf;

/**
 * @author brooks
 * 
 */
public class PackedBitObj
{

   public int    bitIndex         = 0;

   public int    byteIndex        = 0;

   public int    value            = 0;

   public int    nextBitIndex     = 0;

   public int    nextByteIndex    = 0;

   public int    nextByteBoundary = 0;

   /**
    * @param bitIndex
    *           The index of the last bit read
    * @param byteMarker
    *           The index of the last byte read
    * @param decimalValue
    *           The decimal value of the packed bit sequence
    * @param binaryString
    *           
    */
   public PackedBitObj( int bitMarker, int byteMarker, int decimalValue )
   {
      bitIndex = bitMarker;
      byteIndex = byteMarker;
      value = decimalValue;
      nextBitIndex = bitMarker;

      if ( bitMarker <= 7 )
      {
         nextBitIndex++;
         nextByteIndex = byteMarker;
         nextByteBoundary = byteMarker++;
      }
      else
      {
         nextBitIndex = 0;
         nextByteIndex++;
         nextByteBoundary = nextByteIndex;
      }
   }

}
