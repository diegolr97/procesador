package Controlador;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.FontSizeAction;
//se importa modelo e interfaz
import Vista.Principal;
import Modelo.FileTypeFilter;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.text.StyledEditorKit;


/**
 * @author Diego
 * @version 07/10/2016, diego lucas romero
 */ 




public class controlador implements ActionListener,MouseListener{

    /** instancia a nuestra interfaz de usuario*/
    
    Principal Vista ;
    // tipos, fuente, tamaño letra por defecto
   
    FileTypeFilter f;
    
    
    
    /** instancia a nuestro modelo */
    

    
    /** Constrcutor de clase
     * @param vista Instancia de clase interfaz
     */
    public controlador( Principal Vista)
    {
        
        this.Vista = Vista;
        
        
    }
    
    //Enum que se le asigna a cad auno de los botones
    
   public enum ProAction{
       btnArial,
       btnSerif,
       btnVerdana,
       btnNegrita,
       btnCursiva,
       btn12,
       btn16,
       btn18,
       btn20,
       btnGuardar,
       btnAbrir,
       
       
   }
   //metodo que inicia todos los elementos de la vista, e inicia la vista
   public void iniciar(){
       
       Vista.setVisible(true);
       System.out.println("vista arrancada");
       
       this.Vista.Arial.setActionCommand("btnArial");
       this.Vista.Arial.addActionListener(new StyledEditorKit.FontFamilyAction("Arial", "Arial"));
       
       this.Vista.Serif.setActionCommand("btnSerif");
        this.Vista.Serif.addActionListener(new StyledEditorKit.FontFamilyAction("Serif", "Serif"));
        
        this.Vista.Verdana.setActionCommand("btnVerdana");
        this.Vista.Verdana.addActionListener(new StyledEditorKit.FontFamilyAction("Verdana", "Verdana"));
        
        this.Vista.Negrita.setActionCommand("btnNegrita");
        this.Vista.Negrita.addActionListener(new StyledEditorKit.BoldAction());
        
        this.Vista.Cursiva.setActionCommand("btnCursiva");
        this.Vista.Cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        
        this.Vista.Texto12.setActionCommand("btn12");
        this.Vista.Texto12.addActionListener(new StyledEditorKit.FontSizeAction("12", 12));
        
        this.Vista.Texto16.setActionCommand("btn16");
        this.Vista.Texto16.addActionListener(new StyledEditorKit.FontSizeAction("16", 16));;
        
        this.Vista.Texto18.setActionCommand("btn18");
        this.Vista.Texto18.addActionListener(new StyledEditorKit.FontSizeAction("18", 18));
        
        this.Vista.Texto20.setActionCommand("btn20");
        this.Vista.Texto20.addActionListener(new StyledEditorKit.FontSizeAction("20", 20));
        
        this.Vista.Guardar.setActionCommand("btnGuardar");
        this.Vista.Guardar.addActionListener(this);
       
        this.Vista.Abrir.setActionCommand("btnAbrir");
        this.Vista.Abrir.addActionListener(this);
        
        
        
    }
    
//action performe, le asigna una funcion de click a cada boton para ejecutar cualquier Acción
    @Override
    public void actionPerformed(ActionEvent e) {
         switch ( ProAction.valueOf( e.getActionCommand() ) ){
             //boton guardar
             case btnGuardar:
                 
                 JFileChooser fs = new JFileChooser( new File("c:\\"));
                 
                // fs.setDialogTitle("Save a File");  <- codigo comentado(no hace falta)
                 fs.setFileFilter(new FileTypeFilter (".txt", "Text File"));
                 int result =fs.showSaveDialog(null);
                 if(result==JFileChooser.APPROVE_OPTION){
                    String content = this.Vista.Texto.getText();
                    File fi = fs.getSelectedFile();
                    try{
                        FileWriter fw = new FileWriter(fi.getPath());
                        fw.write(content);
                        fw.flush();
                        fw.close();
                    }catch(Exception e2){
                JOptionPane.showMessageDialog(null, e2.getMessage() );
                                        
                                }
                        
                    }
                 
             break;
                //boton abrir 
             case btnAbrir:
                 JFileChooser fr = new JFileChooser( new File("c:\\"));
                 fr.setDialogTitle("OPEN A FILE");
                 fr.setFileFilter(new FileTypeFilter(".txt", "TextFile"));
                 fr.setFileFilter(new FileTypeFilter(".doc", "Word File"));
                 fr.setFileFilter(new FileTypeFilter(".docx", "Word File"));
                 fr.setFileFilter(new FileTypeFilter(".jpg", "JPEG File"));
                 fr.setFileFilter(new FileTypeFilter(".rtf", "Word File"));
                 fr.setFileFilter(new FileTypeFilter(".pdf", "PDF File"));
                 int resultado = fr.showOpenDialog(null);
                 
                 if (resultado==JFileChooser.APPROVE_OPTION){
                     try{
                         File fi = fr.getSelectedFile();
                     
                     BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
                        String linea = "";
                        String s= "";
                        while ((linea=br.readLine()) !=null){
                          s += linea;  
                        }
                        this.Vista.Texto.setText(s);
                        if (br !=null)
                            br.close();
                     }catch(Exception e2){
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                         
                     }
                     
                     
                 }
                 break;
         }
         
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
}