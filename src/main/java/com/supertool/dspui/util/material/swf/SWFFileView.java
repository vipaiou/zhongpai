/*
 * SWFFileView.java
 * 
 * Created on Aug 12, 2007, 11:44:37 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supertool.dspui.util.material.swf;

import java.io.File;
import javax.swing.filechooser.FileView;

/**
 *
 * @author brooks
 */
public class SWFFileView extends FileView 
{

    public SWFFileView() {
    }
    
    @Override
    public String getName( File file ) 
    {
        String filename = file.getName();
        if ( filename.toLowerCase().endsWith( ".swf" ) ) 
        {
          String name = filename + " : " + file.length();
          return name;
        }
        return null;
    }
    
    @Override
    public String getTypeDescription( File file ) 
    {
        String typeDescription = null;
        String filename = file.getName().toLowerCase();

        if ( filename.endsWith( ".swf" ) ) 
        {
            typeDescription = "Adobe Flash SWF file";
        }
        return typeDescription;
    }


}
