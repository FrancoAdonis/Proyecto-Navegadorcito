/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApp;

import CONTROLER.Controler;
import DTO.InscripcionAlumnoDTO;
import DTO.MallaCurricularDTO;
import DTO.MatriculaDTO;
import DTO.ProgramacionProfesorDTO;
import DTO.UsuarioDTO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import FACADE.*;
import POJOS.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class Action extends ActionSupport {
    
    private String usuRut;
    private String dv;
    private String password;
    public  String mensaje = "";
    private int codPerfil;
    public String accion = "";
    public int opc_bloque;
    
    public Usuario usuario;
        
    public String nombreUsuario = "";
    public String paternoUsuario = "";
    public String maternoUsuario = "";
    public String dvUsuario = "";
    public String direccionUsuario = "";
    public String correoUsuario = "";
    public String claveUsuario = "";
    public int    rutUsuario;
    
    public int    codTipoPerfil;
    public int    nomTipoPerfil;  
    public List<TipoPerfil> listarTipoPerfil;
    public List<UsuarioDTO> listarUsuarioDTO;
    public List<Asignatura> listarAsignatura;
    public List<Asignatura> listarAsignaturaMalla;
    public List<Carrera> listarCarrera;
    public List<MallaCurricular> listarAsignaturaNoInsc;
    public List<MallaCurricularDTO> listarMallaDTO;
    public List<MallaCurricularDTO> listarAsignaturaMallaDTO;
    public List<MatriculaDTO> listarMatriculaDTO;    
    public List<InscripcionAlumnoDTO> listarInscripcionDTO;
    public List<InscripcionAsignatura> listarInscripcion;
    public List<InscripcionAlumnoDTO> listarAsignaturasInscritasDTO;    
    public List<InscripcionAlumnoDTO> listarCursoDTO;           
    public List<ProgramacionProfesorDTO> listarProgramacionDTO;
    public List<ProgramacionProfesorDTO> listarProgramacionSemestralDTO; 
    
    private ArrayList<String> listarAnnios;
    private ArrayList<String> listarSemestre;
    
    public int    codAsignV;
    public String nomAsign;
    public String sigla;
    
    public int    codCarreraV;
    public String nomCarrera;
    
    public int    insAnnio;
    public int    insSemestre;
    public int    insParalelo;
    public String estAprobado;
    public String estInscripcion;
    
    public int    proAnnio;
    public int    proSemestre;
    public int    proParalelo;    
    
    public int    añoMalla;
    public String vigente;
    public int    codPlan;
    
    public int    matAnnio;
    public int    matSemestre;
    
    public int asignaturaMalla = 0;
    
    HttpServletRequest request = ServletActionContext.getRequest();
    
    public String crudCurso() {
        
        this.usuRut  = request.getParameter("usuRut") != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.opc_bloque  = 1;
        this.proAnnio    = 2017;
        this.proSemestre = 2;  
        this.listarProgramacionSemestralDTO = Controler.listarProgramacionProfesorDTO(proAnnio, proSemestre, Integer.parseInt(usuRut));        
        this.codAsignV    = 0;
        return "crudCurso";       
    }    
    
    public String buscarCurso() {
        
        this.usuRut    = request.getParameter("usuRut") != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.codAsignV = request.getParameter("codAsignV") != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;
        this.proAnnio    = 2017;
        this.proSemestre = 2;   
        this.listarProgramacionSemestralDTO = Controler.listarProgramacionProfesorDTO(proAnnio, proSemestre, Integer.parseInt(usuRut));                
        this.listarCursoDTO = Controler.listarCursoDTO(proAnnio, proSemestre, codAsignV); 
        if(listarCursoDTO.size() > 0){
            this.opc_bloque  = 2;
            return "success";   
        }
        else return "error";
    
    }     
    
    public String limpiarFiltro() {
        
        this.usuRut = request.getParameter("usuRut")      != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.listarProgramacionSemestralDTO = Controler.listarProgramacionProfesorDTO(2017, 2, Integer.parseInt(usuRut));
        this.listarProgramacionDTO = Controler.listarProgramacionProfesorDTO(Integer.parseInt(usuRut));
        this.proAnnio    = 0;
        this.proSemestre = 0;
        return "success";  
    }
    
    public String verFicha() {
        System.out.println("entra a verFicha: ");
        String rutFicha = request.getParameter("rutFicha") != null && !request.getParameter("rutFicha").trim().equals("") ? request.getParameter("rutFicha") : "0";           
        System.out.println("rutFicha: "+rutFicha);      
        Usuario objUsuario = UsuarioFCD.getUsuario(Integer.parseInt(rutFicha)); 
        if (objUsuario != null) {
            this.nombreUsuario    = objUsuario.getUsuNombre();
            this.paternoUsuario   = objUsuario.getUsuPaterno();
            this.maternoUsuario   = objUsuario.getUsuMaterno();
            this.direccionUsuario = objUsuario.getDireccion();
            this.correoUsuario    = objUsuario.getCorreo();              
        }        
        return "success";  
    }    
    
    
    public String filtrarProgramacion() {
        
        this.usuRut         = request.getParameter("usuRut")      != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        String proAnnioF    = request.getParameter("proAnnio")    != null && !request.getParameter("proAnnio").trim().equals("") ? request.getParameter("proAnnio") : "0";                
        String proSemestreF = request.getParameter("proSemestre") != null && !request.getParameter("proSemestre").trim().equals("") ? request.getParameter("proSemestre") : "0";               
        this.opc_bloque  = 2;
        this.proAnnio    = Integer.parseInt(proAnnioF);
        this.proSemestre = Integer.parseInt(proSemestreF);
        if(Integer.parseInt(usuRut) > 0 && proAnnio > 0 && proSemestre > 0){
        this.listarProgramacionDTO = Controler.listarProgramacionProfesorDTO(proAnnio, proSemestre, Integer.parseInt(usuRut));
        }
        else{
            this.listarProgramacionDTO = Controler.listarProgramacionProfesorDTO(Integer.parseInt(usuRut));
        }                
        this.listarProgramacionSemestralDTO = Controler.listarProgramacionProfesorDTO(2017, 2, Integer.parseInt(usuRut));        
        return "success";       
    }   
        
    public String crudProgramacion() {
        
        this.usuRut  = request.getParameter("usuRut") != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.opc_bloque  = 1;
        this.proAnnio    = 2017;
        this.proSemestre = 2;
        this.listarAnnios  = (ArrayList<String>) Controler.listarAnnios();
        this.listarProgramacionSemestralDTO = Controler.listarProgramacionProfesorDTO(proAnnio, proSemestre, Integer.parseInt(usuRut));
        this.listarProgramacionDTO         = Controler.listarProgramacionProfesorDTO(Integer.parseInt(usuRut));
        this.proAnnio    = 0;
        this.proSemestre = 0;
        return "crudProgramacion";       
    }  
    
    public String limpiarFiltroInsc() {
        
        this.usuRut = request.getParameter("usuRut")      != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.listarAsignaturasInscritasDTO = Controler.listarAsignaturasInscritasDTO(Integer.parseInt(usuRut), insAnnio, insSemestre, "PENDIENTE");
        this.listarInscripcionDTO = Controler.listarInscripcionAlumnoDTO(Integer.parseInt(usuRut));         
        this.insAnnio    = 0;
        this.insSemestre = 0;
        this.estAprobado = "";
        return "success";  
    }
        
    public String crudAluUsuario() {
        
        this.usuRut  = request.getParameter("usuRut") != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";       
        this.mensaje = "";      
        Usuario objUsuario = UsuarioFCD.getUsuario(Integer.parseInt(usuRut));        
        if (objUsuario != null) {
            this.rutUsuario       = objUsuario.getUsuRut();
            this.dvUsuario        = objUsuario.getUsuDv();
            this.nombreUsuario    = objUsuario.getUsuNombre();
            this.paternoUsuario   = objUsuario.getUsuPaterno();
            this.maternoUsuario   = objUsuario.getUsuMaterno();
            this.direccionUsuario = objUsuario.getDireccion();
            this.correoUsuario    = objUsuario.getCorreo();  
            this.claveUsuario     = objUsuario.getClave();
        }
        return "crudAluUsuario";       
    }    
    
    public String crudAluInscripcion() {
        
        this.usuRut  = request.getParameter("usuRut") != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.opc_bloque  = 1;
        this.insAnnio    = 2017;
        this.insSemestre = 2;
        this.listarAsignaturasInscritasDTO = Controler.listarAsignaturasInscritasDTO(Integer.parseInt(usuRut), insAnnio, insSemestre, "PENDIENTE");
        this.listarInscripcionDTO = Controler.listarInscripcionAlumnoDTO(Integer.parseInt(usuRut));         
        this.insAnnio    = 0;
        this.insSemestre = 0;
        return "crudAluInscripcion";       
    }    
    
    public String modificarAluUsuario() {
        
        this.usuRut  = request.getParameter("usuRut") != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        this.nombreUsuario    = request.getParameter("nombreUsuario") != null && !request.getParameter("nombreUsuario").trim().equals("") ? request.getParameter("nombreUsuario") : "";
        this.paternoUsuario   = request.getParameter("paternoUsuario") != null && !request.getParameter("paternoUsuario").trim().equals("") ? request.getParameter("paternoUsuario") : "";
        this.maternoUsuario   = request.getParameter("maternoUsuario") != null && !request.getParameter("maternoUsuario").trim().equals("") ? request.getParameter("maternoUsuario") : "";
        this.direccionUsuario = request.getParameter("direccionUsuario") != null && !request.getParameter("nombreUsuario").trim().equals("") ? request.getParameter("direccionUsuario") : "";
        this.correoUsuario    = request.getParameter("correoUsuario") != null && !request.getParameter("correoUsuario").trim().equals("") ? request.getParameter("correoUsuario") : "";            
        this.claveUsuario     = request.getParameter("claveUsuario") != null && !request.getParameter("claveUsuario").trim().equals("") ? request.getParameter("claveUsuario") : "";                     
        accion = "";
        mensaje = "";
        System.out.println("en modificarAluUsuario usuRut: "+usuRut+" nombreUsuario: "+nombreUsuario+" paternoUsuario: "+paternoUsuario);
        System.out.println("maternoUsuario: "+maternoUsuario+" direccionUsuario: "+direccionUsuario+" correoUsuario: "+correoUsuario+" claveUsuario: "+claveUsuario);
        Usuario objUsuario = UsuarioFCD.getUsuario(Integer.parseInt(usuRut)); 
        if (objUsuario != null) {
            objUsuario.setUsuNombre(nombreUsuario);
            objUsuario.setUsuPaterno(paternoUsuario);
            objUsuario.setUsuMaterno(maternoUsuario);
            objUsuario.setCorreo(correoUsuario);
            objUsuario.setDireccion(direccionUsuario);
            objUsuario.setClave(claveUsuario);  
            boolean modificar = AbstractFCD.ingresarModificarEntidad(objUsuario); 
            if (modificar) {                  
                mensaje = "Datos personales modificados correctamente!!";
                accion = "success";
            }   
        }
        else{            
            mensaje = "NO se puede modificar";
            accion = "success";            
        }      
        return accion;
    }
    
    public String filtrarInscripcion() {

        this.usuRut         = request.getParameter("usuRut")      != null && !request.getParameter("usuRut").trim().equals("") ? request.getParameter("usuRut") : "0";           
        String insAnnioF    = request.getParameter("insAnnio")    != null && !request.getParameter("insAnnio").trim().equals("") ? request.getParameter("insAnnio") : "0";                
        String insSemestreF = request.getParameter("insSemestre") != null && !request.getParameter("insSemestre").trim().equals("") ? request.getParameter("insSemestre") : "0";       
        this.estAprobado    = request.getParameter("estAprobado") != null && !request.getParameter("estAprobado").trim().equals("") ? request.getParameter("estAprobado") : "";                 
        this.opc_bloque  = 2;
        this.insAnnio    = Integer.parseInt(insAnnioF);
        this.insSemestre = Integer.parseInt(insSemestreF);        
        if(Integer.parseInt(usuRut) > 0 && insAnnio > 0 && insSemestre > 0 && estAprobado.length() > 0){
        this.listarInscripcionDTO = Controler.listarAsignaturasInscritasDTO(Integer.parseInt(usuRut), insAnnio, insSemestre, estAprobado);
        }
        else{
            this.listarInscripcionDTO = Controler.listarInscripcionAlumnoDTO(Integer.parseInt(usuRut));         
        }
        this.listarAsignaturasInscritasDTO = Controler.listarAsignaturasInscritasDTO(Integer.parseInt(usuRut), 2017, 2, "PENDIENTE");
        return "success";       
    }      
     
    public String crudUsuario() {
        limpiarVariables();
        this.mensaje  = "";           
        this.listarTipoPerfil = TipoPerfilFCD.listarTipoPerfil();         
        this.listarUsuarioDTO = Controler.listarUsuarioDTO(); 
       System.out.println("listarUsuarioDTO: "+listarUsuarioDTO);
        return "crudUsuario";       
    }
    
    public String crudAsignatura() {
        limpiarVariables();
        this.mensaje  = "";        
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();          
        return "crudAsignatura";       
    }

    public String crudCarreras() {
        limpiarVariables();
        this.mensaje  = "";           
        this.listarCarrera = CarreraFCD.listarCarrera();              
        return "crudCarreras";       
    }
        
    public String crudInscripcion() {
        limpiarVariables();
        this.mensaje  = "";     
        this.opc_bloque = 1;
        this.listarAsignaturaMalla = AsignaturaFCD.listarAsignatura();  
        return "crudInscripcion";       
    }
    
    public String crudMalla() {
        limpiarVariables();
        this.mensaje  = "";   
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        this.listarCarrera    = CarreraFCD.listarCarrera();
        this.listarMallaDTO   = Controler.listarMallaCurricularDTO();
        return "crudMalla";       
    }    

    public String crudMatricula() {
        limpiarVariables();
        this.mensaje  = "";        
        this.opc_bloque = 1;
        this.listarCarrera = CarreraFCD.listarCarrera(); 
        return "crudMatricula";       
    }
    
    public String doLogin() {        
        accion = "";
        this.mensaje  = "";                  
        if (this.usuRut != null && !this.usuRut.equals("") /*&& isUsuarioLogeado()*/) {             
            usuario = UsuarioFCD.getUsuario(Integer.parseInt(usuRut));
            if(!password.equals(usuario.getClave())){
                System.out.println("****** CLAVE NO COINCIDE: ");
                this.password = "";
                accion = "error";
            }       
            else if (this.usuario.getUsuRut() > 0) {
                System.out.println("[Sesion Iniciada] " + this.usuario.getUsuNombre()+" "+this.usuario.getUsuPaterno());
                Map session = ActionContext.getContext().getSession();
                session.put("usuario", this.usuario); // codPerfil por sesión para manejar los JSP
                codPerfil = usuario.getTipoPerfil().getCodPerfil();
                if (codPerfil > 0){
                    TipoPerfil tipoPerfil = TipoPerfilFCD.getTipoPerfil(codPerfil);
                    accion = tipoPerfil.getNomPerfil();   
                    if(codPerfil == 1){
                        this.usuRut   = "";
                        this.codPerfil = 0;
                    }
                }
                else{
                    this.mensaje = "Usuario no tiene perfil asignado.";
                    accion = "error";           
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
        return accion;        
    }
       
    public void limpiarVariables() {
       
            //this.mensaje = "";
            this.rutUsuario       = 0;
            this.dvUsuario        = "";
            this.nombreUsuario    = "";
            this.paternoUsuario   = "";
            this.maternoUsuario   = "";
            this.direccionUsuario = "";
            this.correoUsuario    = "";  
            this.codTipoPerfil    = 0;  
            this.claveUsuario     = "";

            this.codAsignV = 0;
            this.nomAsign = "";
            this.sigla    = "";           

            this.codCarreraV = 0;
            this.nomCarrera = "";    
            
            this.insAnnio = 0;
            this.insSemestre = 0;
            this.insParalelo = 0;  
    
            this.proAnnio = 0;
            this.proSemestre = 0;
    
            this.añoMalla = 0;
            this.vigente = "";
            this.codPlan = 0;
    
            this.matAnnio = 0;
            this.matSemestre = 0;            
         
    } 
    
    public String buscarUsuario() {
        
        this.rutUsuario  = request.getParameter("rutUsuario") != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;               
        accion = "";
        this.mensaje = "";
        this.listarTipoPerfil = TipoPerfilFCD.listarTipoPerfil();  
        this.listarUsuarioDTO = Controler.listarUsuarioDTO();        
        Usuario objUsuario = UsuarioFCD.getUsuario(rutUsuario);        
        if (objUsuario != null) {
            this.listarTipoPerfil = TipoPerfilFCD.listarTipoPerfil(); 
            this.nombreUsuario    = objUsuario.getUsuNombre();
            this.paternoUsuario   = objUsuario.getUsuPaterno();
            this.maternoUsuario   = objUsuario.getUsuMaterno();
            this.direccionUsuario = objUsuario.getDireccion();
            this.correoUsuario    = objUsuario.getCorreo();  
            this.claveUsuario     = objUsuario.getClave();
            this.codTipoPerfil    = objUsuario.getTipoPerfil().getCodPerfil();               
            accion = "success";
            mensaje = "Usuario existe, debe modificar o eliminar!!";
        }
        else{            
             accion = "success";
             mensaje = "Usuario no existe, debe insertar nuevo usuario!!";
        }  
        return accion;
    }  
    
    public String agregarUsuario() {
           
        this.rutUsuario       = request.getParameter("rutUsuario") != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;
        this.dvUsuario        = request.getParameter("dvUsuario") != null && !request.getParameter("dvUsuario").trim().equals("") ? request.getParameter("dvUsuario") : "";    
        this.nombreUsuario    = request.getParameter("nombreUsuario") != null && !request.getParameter("nombreUsuario").trim().equals("") ? request.getParameter("nombreUsuario") : "";
        this.paternoUsuario   = request.getParameter("paternoUsuario") != null && !request.getParameter("paternoUsuario").trim().equals("") ? request.getParameter("paternoUsuario") : "";
        this.maternoUsuario   = request.getParameter("maternoUsuario") != null && !request.getParameter("maternoUsuario").trim().equals("") ? request.getParameter("maternoUsuario") : "";
        this.direccionUsuario = request.getParameter("direccionUsuario") != null && !request.getParameter("nombreUsuario").trim().equals("") ? request.getParameter("direccionUsuario") : "";
        this.correoUsuario    = request.getParameter("correoUsuario") != null && !request.getParameter("correoUsuario").trim().equals("") ? request.getParameter("correoUsuario") : "";    
        this.claveUsuario     = request.getParameter("claveUsuario") != null && !request.getParameter("claveUsuario").trim().equals("") ? request.getParameter("claveUsuario") : "";                    
        this.codTipoPerfil    = request.getParameter("codTipoPerfil") != null && !request.getParameter("codTipoPerfil").trim().equals("") ? Integer.parseInt(request.getParameter("codTipoPerfil")) : 0;    
        this.listarTipoPerfil = TipoPerfilFCD.listarTipoPerfil(); 
        accion = "";
        mensaje = "";
        Usuario objUsuarioAux = UsuarioFCD.getUsuario(rutUsuario);
        if (objUsuarioAux == null) {        
            Usuario objUsuario = new Usuario();
            objUsuario.setUsuRut(rutUsuario);
            objUsuario.setUsuNombre(nombreUsuario);
            objUsuario.setUsuPaterno(paternoUsuario);
            objUsuario.setUsuMaterno(maternoUsuario);
            objUsuario.setUsuDv(dvUsuario);
            objUsuario.setCorreo(correoUsuario);                   
            objUsuario.setDireccion(direccionUsuario);
            objUsuario.setClave(claveUsuario);                 
            TipoPerfil objTipoPerfil = new TipoPerfil();
            objTipoPerfil.setCodPerfil(codTipoPerfil);
            objUsuario.setTipoPerfil(objTipoPerfil);       
            boolean agregar = AbstractFCD.ingresarModificarEntidad(objUsuario);
            if (agregar) {                
                mensaje = "Usuario insertardo correctamente!!";
                accion = "success";
            }      
        }
        else{            
            mensaje = "Usuario ya existe, NO debe insertar nuevo usuario!!";
            accion = "error";
        }
        this.listarUsuarioDTO = Controler.listarUsuarioDTO(); 
       // limpiarVariables();
        return accion;
    }
    
    public String modificarUsuario() {
        
        this.rutUsuario       = request.getParameter("rutUsuario") != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;       
        this.nombreUsuario    = request.getParameter("nombreUsuario") != null && !request.getParameter("nombreUsuario").trim().equals("") ? request.getParameter("nombreUsuario") : "";
        this.paternoUsuario   = request.getParameter("paternoUsuario") != null && !request.getParameter("paternoUsuario").trim().equals("") ? request.getParameter("paternoUsuario") : "";
        this.maternoUsuario   = request.getParameter("maternoUsuario") != null && !request.getParameter("maternoUsuario").trim().equals("") ? request.getParameter("maternoUsuario") : "";
        this.direccionUsuario = request.getParameter("direccionUsuario") != null && !request.getParameter("nombreUsuario").trim().equals("") ? request.getParameter("direccionUsuario") : "";
        this.correoUsuario    = request.getParameter("correoUsuario") != null && !request.getParameter("correoUsuario").trim().equals("") ? request.getParameter("correoUsuario") : "";            
        this.claveUsuario     = request.getParameter("claveUsuario") != null && !request.getParameter("claveUsuario").trim().equals("") ? request.getParameter("claveUsuario") : "";                    
        this.codTipoPerfil    = request.getParameter("codTipoPerfil") != null && !request.getParameter("codTipoPerfil").trim().equals("") ? Integer.parseInt(request.getParameter("codTipoPerfil")) : 1;    
        this.listarTipoPerfil = TipoPerfilFCD.listarTipoPerfil(); 
        accion = "";
        mensaje = "";
        Usuario objUsuario = UsuarioFCD.getUsuario(rutUsuario); 
        if (objUsuario != null) {
            objUsuario.setUsuNombre(nombreUsuario);
            objUsuario.setUsuPaterno(paternoUsuario);
            objUsuario.setUsuMaterno(maternoUsuario);
            objUsuario.setCorreo(correoUsuario);
            objUsuario.setDireccion(direccionUsuario);
            objUsuario.setClave(claveUsuario);
            TipoPerfil objTipoPerfil = new TipoPerfil();
            objTipoPerfil.setCodPerfil(codTipoPerfil);
            objUsuario.setTipoPerfil(objTipoPerfil);     
            boolean modificar = AbstractFCD.ingresarModificarEntidad(objUsuario); 
            if (modificar) {                  
                mensaje = "Usuario MODIFICADO correctamente!!";
                accion = "success";
            }   
        }
        else{            
            mensaje = "Usuario NO existe, NO se puede MODIFICAR!!";
            accion = "success";            
        }        
        this.listarUsuarioDTO = Controler.listarUsuarioDTO(); 
      //  limpiarVariables();
        return accion;
    }
            
    public String eliminarUsuario() {
        
        this.rutUsuario = request.getParameter("rutUsuario") != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;
        Usuario objUsuario = UsuarioFCD.getUsuario(rutUsuario); //valido usuario
        if (objUsuario != null) { // Si existe entonces eliminar usuario                
            boolean eliminar = AbstractFCD.eliminarEntidad(objUsuario);
            if (eliminar) {  
                mensaje = "Usuario ELIMINADO correctamente!!";
                accion = "success";    
         }   
        }
        else{            
            mensaje = "Usuario NO existe, NO se puede ELIMINAR!!";
            accion = "success";               
        }
        this.listarUsuarioDTO = Controler.listarUsuarioDTO(); 
        limpiarVariables();
        return accion;        
    }
    
    public String buscarAsignatura() {
                   
        this.codAsignV = request.getParameter("codAsignV") != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;
        accion = "";
        this.mensaje = "";
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        Asignatura objAsignatura = AsignaturaFCD.getAsignatura(codAsignV);
        if (objAsignatura != null) { 
            this.nomAsign = objAsignatura.getNomAsign();
            this.sigla    = objAsignatura.getSigla();
            this.codAsignV = objAsignatura.getCodAsign();
            accion = "success";
            mensaje = "Asignatura existe, debe modificar o eliminar!!";
        }
        else{            
             accion = "success";
             mensaje = "Asignatura no existe, debe insertar nueva asignatura!!";
        }  
        return accion;
    }  
        
    public String agregarAsignatura() {
        
        
        this.nomAsign = request.getParameter("nomAsign") != null && !request.getParameter("nomAsign").trim().equals("") ? request.getParameter("nomAsign") : "";    
        this.sigla    = request.getParameter("sigla") != null && !request.getParameter("sigla").trim().equals("") ? request.getParameter("sigla") : "";        
        accion = "";
        mensaje = "";
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        Asignatura objAsignaturaAux = AsignaturaFCD.getAsignatura(codAsignV); //valido asignatura
        if (objAsignaturaAux == null) { // Si no existe entonces agrega asignatura            
            Asignatura objAsignatura = new Asignatura();
            objAsignatura.setCodAsign(codAsignV);
            objAsignatura.setNomAsign(nomAsign);
            objAsignatura.setSigla(sigla);            
            boolean agregar = AbstractFCD.ingresarModificarEntidad(objAsignatura);
            if (agregar) {       
                this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
                mensaje = "Asignatura insertarda correctamente!!";
                accion = "success";             
            }      
        }
        else{
            mensaje = "Asignatura ya existe, NO debe insertar nueva asignatura!!";
            accion = "success";                        
        }
       // limpiarVariables();
        return accion;
    }
    
    public String modificarAsignatura() {
        
        this.codAsignV = request.getParameter("codAsignV") != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;
        this.nomAsign = request.getParameter("nomAsign") != null && !request.getParameter("nomAsign").trim().equals("") ? request.getParameter("nomAsign") : "";    
        this.sigla    = request.getParameter("sigla") != null && !request.getParameter("sigla").trim().equals("") ? request.getParameter("sigla") : "";                
        accion = "";
        mensaje = "";        
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        Asignatura objAsignatura = AsignaturaFCD.getAsignatura(codAsignV); //valido asignatura
        if (objAsignatura != null) { // Si existe entonces modifico asignatura            
            objAsignatura.setNomAsign(nomAsign);
            objAsignatura.setSigla(sigla);                     
            boolean modificar = AbstractFCD.ingresarModificarEntidad(objAsignatura);
            if (modificar) {    
                this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
                mensaje = "Asignatura modificada correctamente!!";
                accion = "success";
            }
        }  
        else{
            mensaje = "Asignatura NO existe, NO se puede MODIFICAR!!";
            accion = "success";              
            
        }
      //  limpiarVariables();
        return accion;        
    }
    
    public String eliminarAsignatura() {

        this.codAsignV = request.getParameter("codAsignV") != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        accion = "";
        mensaje = "";   
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        Asignatura objAsignatura = AsignaturaFCD.getAsignatura(codAsignV); //valido asignatura
        if (objAsignatura != null) { // Si existe entonces eliminar asignatura               
            boolean eliminar = AbstractFCD.eliminarEntidad(objAsignatura);            
            if (eliminar) {              
                 mensaje = "Asignatura eliminada correctamente!!";
                 accion = "success";             
         }   
        }
        else{            
             mensaje = "La asignatura no existe";
             accion = "success";            
        }
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();         
        limpiarVariables();
        return accion;        
    }    
       
    public String buscarCarrera() {
                      
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;
        accion = "";
        this.mensaje = "";
        this.listarCarrera = CarreraFCD.listarCarrera(); 
        Carrera objCarrera = CarreraFCD.getCarrera(codCarreraV);
        if (objCarrera != null) { 
            this.codCarreraV = objCarrera.getCodCarrera();
            this.nomCarrera    = objCarrera.getNomCarrera();
            accion = "success";
            mensaje = "Carrera existe, debe modificar o eliminar!!";
        }
        else{            
             accion = "success";
             mensaje = "Carrera no existe, debe insertar nueva asignatura!!";
        }  
        return accion;
    }  
    
    public String agregarCarrera() {

        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;
        this.nomCarrera = request.getParameter("nomCarrera") != null && !request.getParameter("nomCarrera").trim().equals("") ? request.getParameter("nomCarrera") : "";    
        accion = "";
        mensaje = "";  
        this.listarCarrera = CarreraFCD.listarCarrera(); 
        Carrera objCarreraAux = CarreraFCD.getCarrera(1234); //valido carrera
        if (objCarreraAux == null) { // Si no existe entonces agrega carrera            
            Carrera objCarrera = new Carrera();
            objCarrera.setCodCarrera(codCarreraV);
            objCarrera.setNomCarrera(nomCarrera);
            boolean agregar = AbstractFCD.ingresarModificarEntidad(objCarrera);
            if (agregar) {
                this.listarCarrera = CarreraFCD.listarCarrera(); 
                mensaje = "Carrera insertarda correctamente!!";
                accion = "success";   
            }      
        }
        else{
            mensaje = "Carrera ya existe, NO debe insertar nueva carrera!!";
            accion = "success"; 
        }
        //limpiarVariables();
        return accion;        
    }
    
    public String modificarCarrera() {

        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;
        this.nomCarrera = request.getParameter("nomCarrera") != null && !request.getParameter("nomCarrera").trim().equals("") ? request.getParameter("nomCarrera") : "";    
        accion = "";
        mensaje = "";
        this.listarCarrera = CarreraFCD.listarCarrera(); 
        Carrera objCarrera = CarreraFCD.getCarrera(codCarreraV); //valido carrera
        if (objCarrera != null) { // Si existe entonces modifico carrera            
            objCarrera.setNomCarrera(nomCarrera);   
            boolean modificar = AbstractFCD.ingresarModificarEntidad(objCarrera);
            if (modificar) { 
                this.listarCarrera = CarreraFCD.listarCarrera(); 
                mensaje = "Carrera modificada correctamente!!";
                accion = "success";              
           }              
        } 
        else{
            mensaje = "Carrera NO existe, NO puede modificar la carrera!!";
            accion = "success"; 
        }
        //limpiarVariables();
        return accion;        
    }
    
    public String eliminarCarrera() {
        
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;        
        accion = "";
        mensaje = "";                
        Carrera objCarrera = CarreraFCD.getCarrera(codCarreraV);
        if (objCarrera != null) {              
            boolean eliminar = AbstractFCD.eliminarEntidad(objCarrera);            
            if (eliminar) {
                mensaje = "Carrera eliminada correctamente!!";
                accion = "success";               
            }   
        }
        else{            
            mensaje = "Carrera No existe, no se puede eliminar";
            accion = "success";              
        }
        this.listarCarrera = CarreraFCD.listarCarrera();         
        limpiarVariables();
        return accion;        
    }    
    
    public String saveOrUpdateCarreraEstudiante() { //Metodo que agrega y omdifica si existe...
      
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;                
        this.rutUsuario = request.getParameter("rutUsuario") != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;
        accion = "";
        mensaje = "";  
        CarreraEstudiante objCarreraEstudiante = new CarreraEstudiante();
        CarreraEstudianteId objCarreraEstudianteId = new CarreraEstudianteId();
        objCarreraEstudianteId.setCodCarrera(codCarreraV);
        objCarreraEstudianteId.setUsuRut(rutUsuario);            
        objCarreraEstudiante.setId(objCarreraEstudianteId);
        boolean agregar = AbstractFCD.ingresarModificarEntidad(objCarreraEstudiante);
        if (agregar) {  
            mensaje = "Carrera del esudiante agregada correctamente!!";
            accion = "success";               
        }      
       // limpiarVariables();
        return accion;        
    }
    
    public String eliminarCarreraEstudiante(){  // [Error][AbstractDAO][eliminarEntidad][Exception]: Unknown entity: java.lang.Integer
        
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;                
        this.rutUsuario = request.getParameter("rutUsuario") != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;        
        accion = "";
        mensaje = "";  
        CarreraEstudiante objCarreraEstudiante = CarreraEstudianteFCD.getCarreraEstudiante(rutUsuario,codCarreraV); //valido carrera
        if (objCarreraEstudiante != null) {
            boolean eliminar = AbstractFCD.eliminarEntidad(objCarreraEstudiante);
            if (eliminar) {             
                mensaje = "Carrera del estudiante eliminada correctamente.";
                accion = "success";              
            }   
        }
        else {            
                mensaje = "Carrera del estudiante No existe, No se puede eliminar";
                accion = "success";                     
        }
        limpiarVariables();
        return accion;        
    }     
    
    public String buscarInscripcionAsignatura() {
                      
        this.insAnnio    = request.getParameter("insAnnio")    != null && !request.getParameter("insAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("insAnnio")) : 0;                
        this.insSemestre = request.getParameter("insSemestre") != null && !request.getParameter("insSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("insSemestre")) : 0;       
        this.insParalelo = request.getParameter("insParalelo") != null && !request.getParameter("insParalelo").trim().equals("") ? Integer.parseInt(request.getParameter("insParalelo")) : 0;       
        this.codAsignV   = request.getParameter("codAsignV")   != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;               
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;               
      //  System.out.println("en buscarInscripcionAsignatura: insAnnio: "+insAnnio +" insSemestre: "+insSemestre+" insParalelo: "+insParalelo );
        accion = "";
        this.mensaje = "";  
        this.listarInscripcionDTO = Controler.listarInscripcionAlumnoDTO(rutUsuario);         
        CarreraEstudiante objCarreraEstudiante = CarreraEstudianteFCD.getCarreraEstudiante(rutUsuario);        
        if (objCarreraEstudiante != null) { 
          //  System.out.println("entra objCarreraEstudiante");
            asignaturaMalla = 1;
            this.codCarreraV  = objCarreraEstudiante.getId().getCodCarrera();
            this.listarAsignaturaMalla = AsignaturaFCD.listarAsignatura();  
           // this.listarAsignaturaNoInsc = MallaCurricularFCD.listarAsignaturaNoInscrita(codCarreraV, rutUsuario);
          //  System.out.println("en buscarInscripcionAsignatura listarAsignaturaNoInsc: "+listarAsignaturaNoInsc);
            //this.listarAsignaturaMalla = AsignaturaFCD.listarAsignaturaMalla(codCarreraV);  --
           // this.listarAsignaturaMallaDTO = Controler.listarAsignaturaMalla(codCarreraV);
            //System.out.println("en buscarInscripcionAsignatura listarAsignaturaMallaDTO: "+listarAsignaturaMallaDTO);
        } 
        if (listarInscripcionDTO.size() > 0) {
            this.opc_bloque = 2;                
            accion = "success";
        }
        else{            
             accion = "success";
             mensaje = "Alumno no existe!";
        }         
        if(insAnnio > 0 && insSemestre > 0 && codAsignV > 0 && insParalelo > 0){
            InscripcionAsignatura objInscripcionAsignatura = InscripcionAsignaturaFCD.getInscripcionAsignatura(insAnnio, insSemestre, codAsignV, insParalelo, rutUsuario);
            if (objInscripcionAsignatura != null) { 
                this.insAnnio       = objInscripcionAsignatura.getId().getInsAño();
                this.insSemestre    = objInscripcionAsignatura.getId().getInsSemestre();
                this.codAsignV      = objInscripcionAsignatura.getId().getCodAsign();
                this.insParalelo    = objInscripcionAsignatura.getId().getInsParalelo();
                this.rutUsuario     = objInscripcionAsignatura.getId().getUsuRut();    
                this.estAprobado    = objInscripcionAsignatura.getEstAprobado();
                this.estInscripcion = objInscripcionAsignatura.getEstInscripcion();

                accion = "success";
                mensaje = "Inscripción asignatura existe, debe modificar o eliminar!!";
            }
            else{            
                 accion = "success";
                 mensaje = "Inscripción asignatura no existe, debe insertar nueva inscripción!!";
             }  
        }
        return accion;
    }
        
    public String saveOrUpdateInscripcionAsignatura() {
        
        this.insAnnio       = request.getParameter("insAnnio")       != null && !request.getParameter("insAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("insAnnio")) : 0;                
        this.insSemestre    = request.getParameter("insSemestre")    != null && !request.getParameter("insSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("insSemestre")) : 0;       
        this.insParalelo    = request.getParameter("insParalelo")    != null && !request.getParameter("insParalelo").trim().equals("") ? Integer.parseInt(request.getParameter("insParalelo")) : 0;       
        this.codAsignV      = request.getParameter("codAsignV")      != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        this.rutUsuario     = request.getParameter("rutUsuario")     != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;     
        this.estAprobado    = request.getParameter("estAprobado")    != null && !request.getParameter("estAprobado").trim().equals("") ? request.getParameter("estAprobado") : "";            
        this.estInscripcion = request.getParameter("estInscripcion") != null && !request.getParameter("estInscripcion").trim().equals("") ? request.getParameter("estInscripcion") : "";            
        accion  = "";
        mensaje = "";     
        InscripcionAsignatura objInscripcionAsignatura = new InscripcionAsignatura();
        InscripcionAsignaturaId objInscripcionAsignaturaId = new InscripcionAsignaturaId();
        objInscripcionAsignaturaId.setInsAño(insAnnio);
        objInscripcionAsignaturaId.setInsSemestre(insSemestre);
        objInscripcionAsignaturaId.setCodAsign(codAsignV);
        objInscripcionAsignaturaId.setInsParalelo(insParalelo);
        objInscripcionAsignaturaId.setUsuRut(rutUsuario);
        objInscripcionAsignatura.setId(objInscripcionAsignaturaId);
        objInscripcionAsignatura.setEstAprobado(estAprobado);
        objInscripcionAsignatura.setEstInscripcion(estInscripcion);
        boolean agregar = AbstractFCD.ingresarModificarEntidad(objInscripcionAsignatura);
        if (agregar) {       
            mensaje = "La operación fue realizada con éxito.";
            accion = "success";               
        }   
        this.opc_bloque = 2; 
        this.listarInscripcionDTO = Controler.listarInscripcionAlumnoDTO(rutUsuario);          
        CarreraEstudiante objCarreraEstudiante = CarreraEstudianteFCD.getCarreraEstudiante(rutUsuario);
        if (objCarreraEstudiante != null) {
            asignaturaMalla = 1;
            this.codCarreraV  = objCarreraEstudiante.getId().getCodCarrera();
            this.listarAsignaturaMalla = AsignaturaFCD.listarAsignatura();  
          //  this.listarAsignaturaNoInsc = MallaCurricularFCD.listarAsignaturaNoInscrita(codCarreraV, rutUsuario); 
         //   System.out.println("en saveOrUpdateInscripcionAsignatura listarAsignaturaNoInsc: "+listarAsignaturaNoInsc);
            //this.listarAsignaturaMalla = AsignaturaFCD.listarAsignaturaMalla(codCarreraV);
            //this.listarAsignaturaMallaDTO = Controler.listarAsignaturaMalla(codCarreraV);
           // System.out.println("en saveOrUpdateInscripcionAsignatura listarAsignaturaMallaDTO: "+listarAsignaturaMallaDTO);
        }       
       // limpiarVariables();
        return accion;
    }    
    
    public String eliminarInscripcionAsignatura() {  // [Error][AbstractDAO][eliminarEntidad][Exception]: Unknown entity: java.lang.Integer
        
        this.insAnnio      = request.getParameter("insAnnio")      != null && !request.getParameter("insAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("insAnnio")) : 0;                
        this.insSemestre = request.getParameter("insSemestre") != null && !request.getParameter("insSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("insSemestre")) : 0;       
        this.insParalelo = request.getParameter("insParalelo") != null && !request.getParameter("insParalelo").trim().equals("") ? Integer.parseInt(request.getParameter("insParalelo")) : 0;       
        this.codAsignV    = request.getParameter("codAsignV")    != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;               
        accion  = "";
        mensaje = "";  
        InscripcionAsignatura objInscripcionAsignatura = InscripcionAsignaturaFCD.getInscripcionAsignatura(insAnnio, insSemestre, codAsignV, insParalelo, rutUsuario);
        if (objInscripcionAsignatura == null) {            
            mensaje = "Inscripción No existe, No se puede eliminar";
            accion  = "success";              
        }
        else{
            boolean eliminar = AbstractFCD.eliminarEntidad(objInscripcionAsignatura);
            if (eliminar) {            
                mensaje = "Inscripción de Asignatura eliminada correctamente";
                accion = "success";     
            }   
        }
        this.opc_bloque = 2; 
        this.listarInscripcionDTO = Controler.listarInscripcionAlumnoDTO(rutUsuario);         
        CarreraEstudiante objCarreraEstudiante = CarreraEstudianteFCD.getCarreraEstudiante(rutUsuario);
        if (objCarreraEstudiante != null) { 
            asignaturaMalla = 1;
            this.codCarreraV  = objCarreraEstudiante.getId().getCodCarrera();
            this.listarAsignaturaMalla = AsignaturaFCD.listarAsignatura();  
        //    this.listarAsignaturaNoInsc = MallaCurricularFCD.listarAsignaturaNoInscrita(codCarreraV, rutUsuario); 
             //System.out.println("en eliminarInscripcionAsignatura listarAsignaturaNoInsc: "+listarAsignaturaNoInsc);
           // this.listarAsignaturaMalla = AsignaturaFCD.listarAsignaturaMalla(codCarreraV);
           // this.listarAsignaturaMallaDTO = Controler.listarAsignaturaMalla(codCarreraV);
             //System.out.println("en eliminarInscripcionAsignatura listarAsignaturaMallaDTO: "+listarAsignaturaMallaDTO);
        }   
        limpiarVariables();
        return accion;    
    }          
    
    public String buscarMallaCurricular() {
                      
        this.codPlan    = request.getParameter("codPlan")    != null && !request.getParameter("codPlan").trim().equals("") ? Integer.parseInt(request.getParameter("codPlan")) : 0;        
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;        
        this.codAsignV   = request.getParameter("codAsignV")   != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        

        accion = "";
        this.mensaje = "";
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        this.listarCarrera    = CarreraFCD.listarCarrera();  
        this.listarMallaDTO   = Controler.listarMallaCurricularDTO();
        MallaCurricular objMallaCurricular = MallaCurricularFCD.getMallaCurricular(codPlan, codCarreraV, codAsignV);
        if (objMallaCurricular != null) { 
            this.codCarreraV = objMallaCurricular.getId().getCodCarrera();
            this.codAsignV   = objMallaCurricular.getId().getCodAsign();
            this.codPlan    = objMallaCurricular.getId().getCodPlan();
            this.añoMalla   = objMallaCurricular.getAñoMalla();
            this.vigente    = objMallaCurricular.getVigente();
            accion = "success";
            mensaje = "Malla Curricular existe, debe modificar o eliminar!!";
        }
        else{            
             accion = "success";
             mensaje = "Malla Curricular no existe, debe insertar nueva malla!!";
        }  
        return accion;
    } 
    
    public String saveOrUpdateMallaCurricular() {
        
        this.codPlan    = request.getParameter("codPlan")    != null && !request.getParameter("codPlan").trim().equals("") ? Integer.parseInt(request.getParameter("codPlan")) : 0;        
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;        
        this.codAsignV   = request.getParameter("codAsignV")   != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        this.añoMalla   = request.getParameter("añoMalla")   != null && !request.getParameter("añoMalla").trim().equals("") ? Integer.parseInt(request.getParameter("añoMalla")) : 0;        
        this.vigente    = request.getParameter("vigente") != null && !request.getParameter("vigente").trim().equals("") ? request.getParameter("vigente") : "";    
        accion = "";
        mensaje = "";   
        System.out.println("saveOrUpdateMallaCurricular codCarreraV: "+codCarreraV +" codAsignV: "+codAsignV);
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        this.listarCarrera    = CarreraFCD.listarCarrera();
        MallaCurricular objMallaCurricular = new MallaCurricular();
        MallaCurricularId objMallaCurricularId = new MallaCurricularId();
        objMallaCurricularId.setCodPlan(codPlan);
        objMallaCurricularId.setCodCarrera(codCarreraV);
        objMallaCurricularId.setCodAsign(codAsignV);
        objMallaCurricular.setId(objMallaCurricularId);
        objMallaCurricular.setAñoMalla(añoMalla);
        objMallaCurricular.setVigente(vigente);
        boolean agregar = AbstractFCD.ingresarModificarEntidad(objMallaCurricular);
        if (agregar) {
            this.listarMallaDTO   = Controler.listarMallaCurricularDTO();
            mensaje = "La operación fue realizada con éxito.";
            accion = "success";              
        }                    
        //limpiarVariables();
        return accion;
    }  
    
    public String eliminarMallaCurricular() { 
        
        this.codPlan    = request.getParameter("codPlan")    != null && !request.getParameter("codPlan").trim().equals("") ? Integer.parseInt(request.getParameter("codPlan")) : 0;        
        this.codCarreraV = request.getParameter("codCarreraV") != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;        
        this.codAsignV   = request.getParameter("codAsignV")   != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        accion  = "";
        mensaje = "";  
        this.listarAsignatura = AsignaturaFCD.listarAsignatura();  
        this.listarCarrera    = CarreraFCD.listarCarrera();
        MallaCurricular objMallaCurricular = MallaCurricularFCD.getMallaCurricular(codPlan, codCarreraV, codAsignV);
        if (objMallaCurricular == null) {            
            mensaje = "Malla Curricular No existe, No se puede eliminar";
            accion  = "success";              
        }
        else{
            boolean eliminar = AbstractFCD.eliminarEntidad(objMallaCurricular);
            if (eliminar) {   
                mensaje = "Malla Curricular eliminada correctamente";
                accion = "success";     
            }   
        }
        this.listarMallaDTO   = Controler.listarMallaCurricularDTO();        
        limpiarVariables();
        return accion;    
    }         
    
    public String buscarMatricula() {
 
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;                               accion = "";
        this.mensaje = "";
        this.listarCarrera = CarreraFCD.listarCarrera(); 
         this.listarMatriculaDTO =  Controler.listarMatriculaAlumnoDTO(rutUsuario);                          
        if (listarMatriculaDTO.size() > 0) {
            this.opc_bloque = 2;
            CarreraEstudiante objCarreraEstudiante = CarreraEstudianteFCD.getCarreraEstudiante(rutUsuario);
            if (objCarreraEstudiante != null) { 
               this.codCarreraV  = objCarreraEstudiante.getId().getCodCarrera();
            }
                  
            accion = "success";
            mensaje = "Alumno existe";
        }
        else{            
             accion = "success";
             mensaje = "Alumno no existe!";
        }  
        return accion;
    }    
    
    public String saveOrUpdateMatricula() {
    
        this.matAnnio      = request.getParameter("matAnnio")      != null && !request.getParameter("matAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("matAnnio")) : 0;        
        this.matSemestre = request.getParameter("matSemestre") != null && !request.getParameter("matSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("matSemestre")) : 0;                
        this.codCarreraV  = request.getParameter("codCarreraV")  != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;        
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;                       
        accion = "";
        mensaje = "";        
        this.listarCarrera = CarreraFCD.listarCarrera(); 
        Matricula objMatricula = new Matricula();
        MatriculaId objMatriculaId = new MatriculaId();
        objMatriculaId.setMatAño(matAnnio);
        objMatriculaId.setMatSemestre(matSemestre);
        objMatriculaId.setCodCarrera(codCarreraV);
        objMatriculaId.setUsuRut(rutUsuario);
        objMatricula.setId(objMatriculaId);
        boolean agregar = AbstractFCD.ingresarModificarEntidad(objMatricula);
        if (agregar) {
            mensaje = "La operación fue realizada con éxito.";
            accion = "success"; 
        }  
        this.listarMatriculaDTO = Controler.listarMatriculaAlumnoDTO(rutUsuario);
        this.opc_bloque = 2;
        //limpiarVariables();
        return accion;        
    }  
    
    public String eliminarMatricula() { 
        
        this.matAnnio      = request.getParameter("matAnnio")      != null && !request.getParameter("matAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("matAnnio")) : 0;        
        this.matSemestre = request.getParameter("matSemestre") != null && !request.getParameter("matSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("matSemestre")) : 0;                
        this.codCarreraV  = request.getParameter("codCarreraV")  != null && !request.getParameter("codCarreraV").trim().equals("") ? Integer.parseInt(request.getParameter("codCarreraV")) : 0;        
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;                       
        accion  = "";
        mensaje = "";  
        this.listarCarrera = CarreraFCD.listarCarrera(); 
        Matricula objMatricula = MatriculaFCD.getMatricula(matAnnio, matSemestre, codCarreraV, rutUsuario);
        if (objMatricula == null) {            
            mensaje = "Matrícula No existe, No se puede eliminar, debe indicar datos de matrícula a eliminar ";
            accion  = "success";              
        }
        else{
            boolean eliminar = AbstractFCD.eliminarEntidad(objMatricula);
            if (eliminar) {            
                mensaje = "Matrícula eliminada correctamente";
                accion = "success";     
            }   
        }
        this.listarMatriculaDTO = Controler.listarMatriculaAlumnoDTO(rutUsuario);
        this.opc_bloque = 2;        
        limpiarVariables();
        return accion;    
    }     
        
    public String saveOrUpdateProgramacionProfesor() {

        this.proAnnio      = request.getParameter("proAnnio")      != null && !request.getParameter("proAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("proAnnio")) : 0;                
        this.proSemestre = request.getParameter("proSemestre") != null && !request.getParameter("proSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("proSemestre")) : 0;       
        this.proParalelo = request.getParameter("proParalelo") != null && !request.getParameter("proParalelo").trim().equals("") ? Integer.parseInt(request.getParameter("proParalelo")) : 0;       
        this.codAsignV    = request.getParameter("codAsignV")    != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;                       
        accion = "";
        mensaje = "";        
      /*  List<ProgramacionProfesor> listarProgramacionProfesorCount = ProgramacionProfesorFCD.listarProgramacionProfesor(proAnnio,proSemestre,codAsign,proParalelo,rutUsuario);
        if (listarProgramacionProfesorCount.size() > 0) {
                mensaje = "La programacion del profesor ya existe, no puede ser agregada";
                accion = "success"; 
        }
        else{*/
            ProgramacionProfesor objProgramacionProfesor = new ProgramacionProfesor();
            ProgramacionProfesorId objProgramacionProfesorId = new ProgramacionProfesorId();
            objProgramacionProfesorId.setProAño(proAnnio);
            objProgramacionProfesorId.setProSemestre(proSemestre);
            objProgramacionProfesorId.setCodAsign(codAsignV);
            objProgramacionProfesorId.setProParalelo(proParalelo);
            objProgramacionProfesorId.setUsuRut(rutUsuario);
            objProgramacionProfesor.setId(objProgramacionProfesorId);
            boolean agregar = AbstractFCD.ingresarModificarEntidad(objProgramacionProfesor);
            if (agregar) {
                mensaje = "La operación fue realizada con éxito.";
                accion = "success";               
            }    
    //    }
       // limpiarVariables();
        return accion;            
    }  
  
    public String eliminarProgramacionProfesor() { 
        
        this.proAnnio      = request.getParameter("proAnnio")      != null && !request.getParameter("proAnnio").trim().equals("") ? Integer.parseInt(request.getParameter("proAnnio")) : 0;                
        this.proSemestre = request.getParameter("proSemestre") != null && !request.getParameter("proSemestre").trim().equals("") ? Integer.parseInt(request.getParameter("proSemestre")) : 0;       
        this.proParalelo = request.getParameter("proParalelo") != null && !request.getParameter("proParalelo").trim().equals("") ? Integer.parseInt(request.getParameter("proParalelo")) : 0;       
        this.codAsignV    = request.getParameter("codAsignV")    != null && !request.getParameter("codAsignV").trim().equals("") ? Integer.parseInt(request.getParameter("codAsignV")) : 0;        
        this.rutUsuario  = request.getParameter("rutUsuario")  != null && !request.getParameter("rutUsuario").trim().equals("") ? Integer.parseInt(request.getParameter("rutUsuario")) : 0;                       
        accion  = "";
        mensaje = "";  
        ProgramacionProfesor objProgramacionProfesor = ProgramacionProfesorFCD.getProgramacionProfesor(proAnnio, proSemestre, codAsignV, proParalelo, rutUsuario);
        if (objProgramacionProfesor == null) {            
            mensaje = "Programación Profesor No existe, No se puede eliminar";
            accion  = "success";              
        }
        else{
            boolean eliminar = AbstractFCD.eliminarEntidad(objProgramacionProfesor);
            if (eliminar) {            
                mensaje = "Programación Profesor eliminada correctamente";
                accion = "success";     
            }   
        }
        limpiarVariables();
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPaternoUsuario() {
        return paternoUsuario;
    }

    public void setPaternoUsuario(String paternoUsuario) {
        this.paternoUsuario = paternoUsuario;
    }

    public String getDvUsuario() {
        return dvUsuario;
    }

    public void setDvUsuario(String dvUsuario) {
        this.dvUsuario = dvUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public int getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(int rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public int getCodTipoPerfil() {
        return codTipoPerfil;
    }

    public void setCodTipoPerfil(int codTipoPerfil) {
        this.codTipoPerfil = codTipoPerfil;
    }

    public int getNomTipoPerfil() {
        return nomTipoPerfil;
    }

    public void setNomTipoPerfil(int nomTipoPerfil) {
        this.nomTipoPerfil = nomTipoPerfil;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public List<TipoPerfil> getListarTipoPerfil() {
        return listarTipoPerfil;
    }

    public int getInsAnnio() {
        return insAnnio;
    }

    public void setInsAnnio(int insAnnio) {
        this.insAnnio = insAnnio;
    }

    public String getEstAprobado() {
        return estAprobado;
    }

    public void setEstAprobado(String estAprobado) {
        this.estAprobado = estAprobado;
    }

    public String getEstInscripcion() {
        return estInscripcion;
    }

    public void setEstInscripcion(String estInscripcion) {
        this.estInscripcion = estInscripcion;
    }

    public int getProAnnio() {
        return proAnnio;
    }

    public void setProAnnio(int proAnnio) {
        this.proAnnio = proAnnio;
    }

    public int getMatAnnio() {
        return matAnnio;
    }

    public void setMatAnnio(int matAnnio) {
        this.matAnnio = matAnnio;
    }

    public void setListarTipoPerfil(List<TipoPerfil> listarTipoPerfil) {
        this.listarTipoPerfil = listarTipoPerfil;
    }

    public String getMaternoUsuario() {
        return maternoUsuario;
    }

    public void setMaternoUsuario(String maternoUsuario) {
        this.maternoUsuario = maternoUsuario;
    }

    public List<Asignatura> getListarAsignatura() {
        return listarAsignatura;
    }

    public void setListarAsignatura(List<Asignatura> listarAsignatura) {
        this.listarAsignatura = listarAsignatura;
    }

    public List<Carrera> getListarCarrera() {
        return listarCarrera;
    }

    public void setListarCarrera(List<Carrera> listarCarrera) {
        this.listarCarrera = listarCarrera;
    }

    public String getNomAsign() {
        return nomAsign;
    }

    public void setNomAsign(String nomAsign) {
        this.nomAsign = nomAsign;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomCarrera() {
        return nomCarrera;
    }

    public void setNomCarrera(String nomCarrera) {
        this.nomCarrera = nomCarrera;
    }

    public int getInsAño() {
        return insAnnio;
    }

    public void setInsAño(int insAnnio) {
        this.insAnnio = insAnnio;
    }

    public int getInsSemestre() {
        return insSemestre;
    }

    public void setInsSemestre(int insSemestre) {
        this.insSemestre = insSemestre;
    }

    public int getInsParalelo() {
        return insParalelo;
    }

    public void setInsParalelo(int insParalelo) {
        this.insParalelo = insParalelo;
    }

    public int getProAño() {
        return proAnnio;
    }

    public void setProAño(int proAnnio) {
        this.proAnnio = proAnnio;
    }

    public int getProSemestre() {
        return proSemestre;
    }

    public void setProSemestre(int proSemestre) {
        this.proSemestre = proSemestre;
    }

    public int getProParalelo() {
        return proParalelo;
    }

    public void setProParalelo(int proParalelo) {
        this.proParalelo = proParalelo;
    }

    public int getAñoMalla() {
        return añoMalla;
    }

    public void setAñoMalla(int añoMalla) {
        this.añoMalla = añoMalla;
    }

    public String getVigente() {
        return vigente;
    }

    public void setVigente(String vigente) {
        this.vigente = vigente;
    }

    public int getCodPlan() {
        return codPlan;
    }

    public void setCodPlan(int codPlan) {
        this.codPlan = codPlan;
    }

    public int getMatAño() {
        return matAnnio;
    }

    public void setMatAño(int matAnnio) {
        this.matAnnio = matAnnio;
    }

    public int getMatSemestre() {
        return matSemestre;
    }

    public void setMatSemestre(int matSemestre) {
        this.matSemestre = matSemestre;
    }

    public List<MallaCurricularDTO> getListarMallaDTO() {
        return listarMallaDTO;
    }

    public void setListarMallaDTO(List<MallaCurricularDTO> listarMallaDTO) {
        this.listarMallaDTO = listarMallaDTO;
    }    

    public List<MatriculaDTO> getListarMatriculaDTO() {
        return listarMatriculaDTO;
    }

    public void setListarMatriculaDTO(List<MatriculaDTO> listarMatriculaDTO) {
        this.listarMatriculaDTO = listarMatriculaDTO;
    }

    public int getCodAsignV() {
        return codAsignV;
    }

    public void setCodAsignV(int codAsignV) {
        this.codAsignV = codAsignV;
    }

    public int getCodCarreraV() {
        return codCarreraV;
    }

    public void setCodCarreraV(int codCarreraV) {
        this.codCarreraV = codCarreraV;
    }

    public int getOpc_bloque() {
        return opc_bloque;
    }

    public void setOpc_bloque(int opc_bloque) {
        this.opc_bloque = opc_bloque;
    }

    public List<InscripcionAsignatura> getListarInscripcion() {
        return listarInscripcion;
    }

    public void setListarInscripcion(List<InscripcionAsignatura> listarInscripcion) {
        this.listarInscripcion = listarInscripcion;
    }

    public List<InscripcionAlumnoDTO> getListarInscripcionDTO() {
        return listarInscripcionDTO;
    }

    public void setListarInscripcionDTO(List<InscripcionAlumnoDTO> listarInscripcionDTO) {
        this.listarInscripcionDTO = listarInscripcionDTO;
    }
    
    public List<Asignatura> getListarAsignaturaMalla() {
        return listarAsignaturaMalla;
    }

    public void setListarAsignaturaMalla(List<Asignatura> listarAsignaturaMalla) {
        this.listarAsignaturaMalla = listarAsignaturaMalla;
    }

    public List<InscripcionAlumnoDTO> getListarAsignaturasInscritasDTO() {
        return listarAsignaturasInscritasDTO;
    }

    public void setListarAsignaturasInscritasDTO(List<InscripcionAlumnoDTO> listarAsignaturasInscritasDTO) {
        this.listarAsignaturasInscritasDTO = listarAsignaturasInscritasDTO;
    }   

    public List<ProgramacionProfesorDTO> getListarProgramacionDTO() {
        return listarProgramacionDTO;
    }

    public void setListarProgramacionDTO(List<ProgramacionProfesorDTO> listarProgramacionDTO) {
        this.listarProgramacionDTO = listarProgramacionDTO;
    }

    public List<ProgramacionProfesorDTO> getListarProgramacionSemestralDTO() {
        return listarProgramacionSemestralDTO;
    }

    public void setListarProgramacionSemestralDTO(List<ProgramacionProfesorDTO> listarProgramacionSemestralDTO) {
        this.listarProgramacionSemestralDTO = listarProgramacionSemestralDTO;
    }

    public List<UsuarioDTO> getListarUsuarioDTO() {
        return listarUsuarioDTO;
    }

    public void setListarUsuarioDTO(List<UsuarioDTO> listarUsuarioDTO) {
        this.listarUsuarioDTO = listarUsuarioDTO;
    }

    public List<InscripcionAlumnoDTO> getListarCursoDTO() {
        return listarCursoDTO;
    }

    public void setListarCursoDTO(List<InscripcionAlumnoDTO> listarCursoDTO) {
        this.listarCursoDTO = listarCursoDTO;
    }

    public ArrayList<String> getListarAnnios() {
        return listarAnnios;
    }

    public void setListarAnnios(ArrayList<String> listarAnnios) {
        this.listarAnnios = listarAnnios;
    }

    public ArrayList<String> getListarSemestre() {
        return listarSemestre;
    }

    public void setListarSemestre(ArrayList<String> listarSemestre) {
        this.listarSemestre = listarSemestre;
    }

    public List<MallaCurricularDTO> getListarAsignaturaMallaDTO() {
        return listarAsignaturaMallaDTO;
    }

    public void setListarAsignaturaMallaDTO(List<MallaCurricularDTO> listarAsignaturaMallaDTO) {
        this.listarAsignaturaMallaDTO = listarAsignaturaMallaDTO;
    }

    public int getAsignaturaMalla() {
        return asignaturaMalla;
    }

    public void setAsignaturaMalla(int asignaturaMalla) {
        this.asignaturaMalla = asignaturaMalla;
    }

    public List<MallaCurricular> getListarAsignaturaNoInsc() {
        return listarAsignaturaNoInsc;
    }

    public void setListarAsignaturaNoInsc(List<MallaCurricular> listarAsignaturaNoInsc) {
        this.listarAsignaturaNoInsc = listarAsignaturaNoInsc;
    }

     
}