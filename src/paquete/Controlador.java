/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;
//importo el menu principal
import Vista.Principal;
//importo los JPanel del menu AYUDA
import Vista.Acerca_de;
import Vista.Instructivo;
//Importo los jPanel del menu OPCIONES
import Vista.Crear_Vector;
import Vista.Ingresar_Datos;
import Vista.Mostrar_Mayor;
import Vista.Mostrar_Listado;
//importo ActionEvent
import java.awt.event.ActionEvent;
//importo ActionListener para poder escuchar lo que hace
import java.awt.event.ActionListener;
    
public class Controlador implements ActionListener{
    //se encarga de recibir desde la vista y enviar al modelo
    //ATRIBUTOS
    //Objeto Vista para la Vista MVC
    private Principal $Principal;
    private Acerca_de $Acerca;
    private Instructivo $Instructivo;
    private Crear_Vector $Crear;
    private Ingresar_Datos $Ingresar;
    private Mostrar_Mayor $MostrarM;
    private Mostrar_Listado $MostrarL;
    
    //Objeto Modelo para el Modelo MVC
    private Modelo $objModelo;
    String r;
    
    public Controlador(Acerca_de $Acerca,Principal $Principal, Modelo $objModelo,Instructivo $Instructivo,
                        Crear_Vector $Crear, Ingresar_Datos $Ingresar,Mostrar_Mayor $MostrarM,Mostrar_Listado $MostrarL) {
        this.$Principal = $Principal;
        this.$Acerca = $Acerca;
        this.$Instructivo = $Instructivo;
        this.$Crear = $Crear;
        this.$Ingresar = $Ingresar;
        this.$MostrarM = $MostrarM;
        this.$MostrarL = $MostrarL;
        this.$objModelo = $objModelo;
        this.$Principal.mCrear.addActionListener(this);
        this.$Principal.mIngresar.addActionListener(this);
        this.$Principal.mMostrarM.addActionListener(this);
        this.$Principal.mMostrarL.addActionListener(this);
        this.$Principal.mSalir.addActionListener(this);
        this.$Principal.mInstructivo.addActionListener(this);
        this.$Principal.mAcercade.addActionListener(this);
        this.$Acerca.btnCerrar.addActionListener(this);
        this.$Instructivo.btnCerrar.addActionListener(this);
        this.$Crear.btnCerrar.addActionListener(this);
        this.$Crear.btnEnviar.addActionListener(this);
        this.$Ingresar.btnCerrar.addActionListener(this);
        this.$MostrarM.btnCerrar.addActionListener(this);
        this.$MostrarM.btnMostrarM.addActionListener(this);
        this.$MostrarL.btnCerrar.addActionListener(this);
        this.$MostrarL.btnMostrar.addActionListener(this);
        this.$Ingresar.btnGuardar.addActionListener(this);
    } 

   
@Override
    public void actionPerformed(ActionEvent e){
        Object botonPresionado = e.getSource();
        //frmAcercade
        if (botonPresionado == this.$Principal.mAcercade) { 
            this.$Acerca.setVisible(true);
        }
        if (botonPresionado == this.$Acerca.btnCerrar) {
            this.$Acerca.setVisible(false);          
        }
        //Instructivo
        if (botonPresionado == this.$Principal.mInstructivo) { 
            this.$Instructivo.setVisible(true);
        }
        if (botonPresionado == this.$Instructivo.btnCerrar) {
            this.$Instructivo.setVisible(false);          
        }
        //Mostrar listado
        if (botonPresionado == this.$Principal.mMostrarL) { 
            this.$MostrarL.setVisible(true);
        }
        if (botonPresionado == this.$MostrarL.btnMostrar){
            String listado = $objModelo.obtenerListado();
            $MostrarL.txaMostrar.setText(listado);
        }
        if (botonPresionado == this.$MostrarL.btnCerrar) {
            this.$MostrarL.setVisible(false);          
        }
        //Mostrar Mayor
        if (botonPresionado == this.$Principal.mMostrarM) { 
            this.$MostrarM.setVisible(true);
        }
        if (botonPresionado == this.$MostrarM.btnMostrarM){
            int mayor = $objModelo.encontrarMayor();
            $MostrarM.lblMostrar.setText(""+mayor);
        }
        if (botonPresionado == this.$MostrarM.btnCerrar) {
            this.$MostrarM.setVisible(false);          
        }
        //ingresar datos
         // Abrir el panel de Ingresar Datos
        if (botonPresionado == this.$Principal.mIngresar) { 
            this.$Ingresar.setVisible(true);
            this.$Principal.mMostrarM.setEnabled(true);
            this.$Principal.mMostrarL.setEnabled(true);
        }

        // Botón Agregar (Ingreso de datos al Modelo)
        if (e.getSource() == $Ingresar.btnGuardar) {
            
            String texto = $Ingresar.txtDato.getText().trim(); // Eliminamos espacios en blanco
            if (!texto.isEmpty()) { // Aseguramos que no esté vacío
            try {
                int numero = Integer.parseInt(texto);
                $objModelo.ingresarDato(numero);
                $Ingresar.lblMensaje.setText("Dato ingresado correctamente.");
                System.out.println(java.util.Arrays.toString($objModelo.getVector())); // Muestra el vector en consola
            } catch (NumberFormatException ex) {
            $Ingresar.lblMensaje.setText("Error: Ingresa un número válido.");
            }
        } else {
            $Ingresar.lblMensaje.setText(" Error: El campo está vacío.");
        }
            $Ingresar.txtDato.setText(""); // Limpiamos el campo después de procesar
        }
        if (botonPresionado == this.$Ingresar.btnCerrar) {
            this.$Ingresar.setVisible(false);          
        }
        //crear vector
        if (botonPresionado == this.$Principal.mCrear) { 
            this.$Crear.setVisible(true);
            this.$Principal.mIngresar.setEnabled(true); 
        }
        //Crear_vvector
        if (botonPresionado == this.$Crear.btnEnviar){
            int tamaño = Integer.parseInt(this.$Crear.txtTamaño.getText());
            $objModelo.setTamaño(tamaño);
            $objModelo.crear();
            this.$Crear.txtTamaño.setText("");
        }
        if (botonPresionado == this.$Crear.btnCerrar) {
            this.$Crear.setVisible(false);          
        }
        //salir
        if (botonPresionado == this.$Principal.mSalir) {
            System.exit(0);
        }
    }
    
}
        
