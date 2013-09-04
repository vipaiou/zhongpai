package com.supertool.dspui.util.material.swf;

import java.io.File;
import java.io.FilenameFilter;

public class SWFFilter implements FilenameFilter 
{

    public boolean accept( File dir, String name )
    {
        return name.toLowerCase().endsWith( ".swf" );
    }

}
