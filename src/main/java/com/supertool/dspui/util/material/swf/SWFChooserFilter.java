/*
 * SWFChooserFilter.java
 * 
 * Created on Aug 12, 2007, 9:59:39 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supertool.dspui.util.material.swf;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 *
 * @author brooks
 */
public class SWFChooserFilter extends FileFilter {

    public boolean accept(File file) {
        return file.isDirectory() || file.getName().toLowerCase().endsWith( ".swf" );
    }

    public String getDescription() {
        return ".swf files";
    }

}
