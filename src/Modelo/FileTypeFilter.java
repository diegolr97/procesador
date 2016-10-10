/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import javax.swing.filechooser.*;

/**
 *
 * @author Diego
 */
public class FileTypeFilter extends FileFilter {
private final String extension;
private final String descripcion;

public FileTypeFilter(String extension, String descripcion){
    this.extension=extension;
    this.descripcion=descripcion;
    
}

    
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()){
            return true;
        }
        return file.getName().endsWith(extension);
    }

    @Override
    public String getDescription() {
        return descripcion + String.format(" (*%s)", extension);
    }
    
    
}
