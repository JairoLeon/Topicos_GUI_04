/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio04;

/**
 *
 * @author Jairo
 */

import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame; 
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Cotizador extends JFrame implements ActionListener {
    
    private JCheckBox check[];
    private Integer   valores[]={1500,800,1000,400,550};
    private String    nombres[]={"DISCO DURO $ ","MEMORIA $ ","TARJETA DE VIDEO $ ","UNIDAD DVD $ ","TARJETA DE SONIDO $ "};
    private JButton   calcular;
    private JLabel    encabezado;
    private Integer   costo=0;
    
public Cotizador(){
  
  super("Cotizador");
  setLayout(new GridLayout(7,1,3,3));
 
  ManejadorCheckBox manejador = new ManejadorCheckBox();
  check  = new JCheckBox[5];
  calcular=new JButton("Calcular");
  calcular.addActionListener(this);
  encabezado=new JLabel("Seleccione los componentes para cotizar PC:");
  add(encabezado);
   
  for (int i = 0; i < valores.length; i++) {
        check[i]=new JCheckBox(nombres[i]+valores[i]);
        check[i].addItemListener( manejador );
        add(check[i]);
   }
  
    add(calcular);
    setVisible(true);
    setSize( 290, 310 );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
}

public void actionPerformed(ActionEvent e){
  if(e.getSource()== calcular){
  
  JOptionPane.showMessageDialog(null,"Costo total: $ "+costo);
  }
}

/**
 * Clase Manejador del JCheckBox
 */
private class ManejadorCheckBox implements ItemListener 
   {
       
      public void itemStateChanged( ItemEvent evento )
      {
         
          
         if ( evento.getSource() == check[0])
            costo = 
              check[0] .isSelected() ? costo+valores[0] : costo;
               
         
         if ( evento.getSource() == check[1] )
            costo = 
               check[1] .isSelected() ? costo+valores[1] : costo;
         
         if ( evento.getSource() == check[2] )
            costo = 
               check[2] .isSelected() ? costo+valores[2] : costo;
         
         
         if ( evento.getSource() == check[3] )
            costo = 
               check[3] .isSelected() ? costo+valores[3] : costo;
         
         if ( evento.getSource() == check[4] )
            costo = 
               check[4] .isSelected() ? costo+valores[4] : costo;
         
       } 
   }

}

