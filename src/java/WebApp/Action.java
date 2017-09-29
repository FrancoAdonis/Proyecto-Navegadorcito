/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import FACADE.UsuarioFCD;
import POJOS.Usuario;
import UTIL.Log;
/**
 *
 * @author karina.pasten
 */
public class Action extends ActionSupport {
    
    private String usuRut;
    private String dv;
    private String password;
    public  String mensaje = "";
    private int codPerfil;
    private Log log = Log.getInstance();
    public String accion = "";
    
    private boolean debug;
    public Usuario usuario;
    
    
    public Action() {
        this.debug = true;
    }
    
    public String doLogin() {
        accion = "";
        this.mensaje  = "";        
        System.out.println("Ver retorno - Inicio doLogin rut: "+usuRut+" password: "+password);  
        //ACA VALIDAR PASSWORD Y SI ESTA CORRECTA IR A BUSCAR USUARIO     
        if (this.usuRut != null && !this.usuRut.equals("") /*&& isUsuarioLogeado()*/) {
            usuario = UsuarioFCD.getUsuario(Integer.parseInt(usuRut));
            if(!password.equals(usuario.getClave())){
                System.out.println("****** CLAVE NO COINCIDE: ");
                this.password = "";
                accion = "error";
            }       
            else if (this.usuario.getUsuRut() > 0) {
                this.usuRut   = "";
                this.codPerfil = 0;
                System.out.println("[Sesion Iniciada] " + this.usuario.getUsuNombre()+" "+this.usuario.getUsuPaterno());
                Map session = ActionContext.getContext().getSession();
                session.put("usuario", this.usuario); // codPErfil por sesión para manejar los JSP
                codPerfil = usuario.getTipoPerfil().getCodPerfil();
                System.out.println("****** PERFIL: "+codPerfil );
                switch (codPerfil) {
                    case 1:
                        accion = "ADMINISTRADOR";
                        break;
                    case 2:
                        accion = "PROFESOR";
                        break;
                    case 3:
                        accion = "ESTUDIANTE";
                        break;
                    default:
                        accion = "error";
                        break;
                 }
                } 
                else {
                    this.mensaje = "Usuario y contraseña inválida.";
                    accion = "error";
                }
        } 
        else {
            accion = "error";
        }
      //  accion = "CONTENEDOR";
        return accion;        
    }
    
    
    
    private boolean isUsuarioLogeado() {
        
        Map session = ActionContext.getContext().getSession();
        if (session.get("usuario") == null) {
            System.out.println("Usuario no logeado");
            return false;
        } else {
            this.usuario = (Usuario) session.get("usuario");
            return true;
        }
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    } 

    public String getUsuRut() {
        return usuRut;
    }

    public void setUsuRut(String usuRut) {
        this.usuRut = usuRut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(int codPerfil) {
        this.codPerfil = codPerfil;
    }
     
}
