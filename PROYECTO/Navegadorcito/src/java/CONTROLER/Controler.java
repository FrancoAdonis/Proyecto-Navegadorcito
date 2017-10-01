/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;

import DTO.InscripcionAlumnoDTO;
import DTO.MallaCurricularDTO;
import DTO.MatriculaDTO;
import DTO.ProgramacionProfesorDTO;
import DTO.UsuarioDTO;
import FACADE.AsignaturaFCD;
import FACADE.CarreraFCD;
import FACADE.InscripcionAsignaturaFCD;
import FACADE.MallaCurricularFCD;
import FACADE.MatriculaFCD;
import FACADE.ProgramacionProfesorFCD;
import FACADE.TipoPerfilFCD;
import FACADE.UsuarioFCD;
import POJOS.Asignatura;
import POJOS.Carrera;
import POJOS.InscripcionAsignatura;
import POJOS.MallaCurricular;
import POJOS.Matricula;
import POJOS.ProgramacionProfesor;
import POJOS.TipoPerfil;
import POJOS.Usuario;
import UTIL.UtilFCD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controler {
    
    public static List<UsuarioDTO> listarUsuarioDTO() {

        List<UsuarioDTO> listarObjDTO = new ArrayList<UsuarioDTO>();
        List<Usuario> listarUsuario = UsuarioFCD.listarUsuario();
        
        for (int i = 0; i < listarUsuario.size(); i++) {
            
            UsuarioDTO objDTO = new UsuarioDTO();
            objDTO.setUsuario(listarUsuario.get(i));
            
            TipoPerfil objTipoPerfil = TipoPerfilFCD.getTipoPerfil(listarUsuario.get(i).getTipoPerfil().getCodPerfil());
            objDTO.setTipoPerfil(objTipoPerfil);
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }
    
        public static List<MallaCurricularDTO> listarMallaCurricularDTO() {

        List<MallaCurricularDTO> listarObjDTO = new ArrayList<MallaCurricularDTO>();
        List<MallaCurricular> listarMallaCurricular = MallaCurricularFCD.listarMallaCurricular();
        
        for (int i = 0; i < listarMallaCurricular.size(); i++) {
            
            MallaCurricularDTO objDTO = new MallaCurricularDTO();
            objDTO.setMallaCurricular(listarMallaCurricular.get(i));
            
            Carrera objCarrera = CarreraFCD.getCarrera(listarMallaCurricular.get(i).getId().getCodCarrera());
            objDTO.setCarrera(objCarrera);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarMallaCurricular.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);
                        
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }   
        
    public static List<MallaCurricularDTO> listarAsignaturaMalla(int codCarrera) {

        List<MallaCurricularDTO> listarObjDTO = new ArrayList<MallaCurricularDTO>();
        List<MallaCurricular> listarAsignaturaMalla = MallaCurricularFCD.listarAsignaturaMalla(codCarrera);
        
        for (int i = 0; i < listarAsignaturaMalla.size(); i++) {
            
            MallaCurricularDTO objDTO = new MallaCurricularDTO();
            objDTO.setMallaCurricular(listarAsignaturaMalla.get(i));
            
            Carrera objCarrera = CarreraFCD.getCarrera(listarAsignaturaMalla.get(i).getId().getCodCarrera());
            objDTO.setCarrera(objCarrera);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarAsignaturaMalla.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);
                        
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }         
    
    public static List<MatriculaDTO> listarMatriculaAlumnoDTO(int usuRut) {

        List<MatriculaDTO> listarObjDTO = new ArrayList<MatriculaDTO>();
        List<Matricula> listarMatricula = MatriculaFCD.listarMatriculaAlumno(usuRut);
        
        for (int i = 0; i < listarMatricula.size(); i++) {
            
            MatriculaDTO objDTO = new MatriculaDTO();
            objDTO.setMatricula(listarMatricula.get(i));
            
            Usuario objUsuario = UsuarioFCD.getUsuario(usuRut);
            objDTO.setUsuario(objUsuario);
            
            Carrera objCarrera = CarreraFCD.getCarrera(listarMatricula.get(i).getId().getCodCarrera());
            objDTO.setCarrera(objCarrera);            
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }  
    
    public static List<InscripcionAlumnoDTO> listarInscripcionAlumnoDTO(int usuRut) {

        List<InscripcionAlumnoDTO> listarObjDTO = new ArrayList<InscripcionAlumnoDTO>();
        List<InscripcionAsignatura> listarInscripcion = InscripcionAsignaturaFCD.listarInscripcionAlumno(usuRut);
        
        for (int i = 0; i < listarInscripcion.size(); i++) {
            
            InscripcionAlumnoDTO objDTO = new InscripcionAlumnoDTO();
            objDTO.setInscripcionAsignatura(listarInscripcion.get(i));
            
            Usuario objUsuario = UsuarioFCD.getUsuario(usuRut);
            objDTO.setUsuario(objUsuario);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarInscripcion.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);         
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }   
    
    public static List<InscripcionAlumnoDTO> listarAsignaturasInscritasDTO(int usuRut, int insAño, int insSemestre, String estado) {

        List<InscripcionAlumnoDTO> listarObjDTO = new ArrayList<InscripcionAlumnoDTO>();
        List<InscripcionAsignatura> listarInscripcion = InscripcionAsignaturaFCD.listarAsignaturasInscritas(usuRut, insAño, insSemestre, estado);
        
        for (int i = 0; i < listarInscripcion.size(); i++) {
            
            InscripcionAlumnoDTO objDTO = new InscripcionAlumnoDTO();
            objDTO.setInscripcionAsignatura(listarInscripcion.get(i));
            
            Usuario objUsuario = UsuarioFCD.getUsuario(usuRut);
            objDTO.setUsuario(objUsuario);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarInscripcion.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);         
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }   
    
    public static List<InscripcionAlumnoDTO> listarCursoDTO(int insAño, int insSemestre, int codAsign) {

        List<InscripcionAlumnoDTO> listarObjDTO = new ArrayList<InscripcionAlumnoDTO>();
        List<InscripcionAsignatura> listarInscripcion = InscripcionAsignaturaFCD.listarCurso(insAño, insSemestre, codAsign);
        
        for (int i = 0; i < listarInscripcion.size(); i++) {
            
            InscripcionAlumnoDTO objDTO = new InscripcionAlumnoDTO();
            objDTO.setInscripcionAsignatura(listarInscripcion.get(i));
            
            Usuario objUsuario = UsuarioFCD.getUsuario(listarInscripcion.get(i).getId().getUsuRut());
            objDTO.setUsuario(objUsuario);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarInscripcion.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);         
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }        
    
    public static List<ProgramacionProfesorDTO> listarProgramacionProfesorDTO(int proAño, int proSemestre, int usuRut) {

        List<ProgramacionProfesorDTO> listarObjDTO = new ArrayList<ProgramacionProfesorDTO>();
        List<ProgramacionProfesor> listarProgramacion = ProgramacionProfesorFCD.listarProgramacionProfesor(proAño, proSemestre, usuRut);                
        
        for (int i = 0; i < listarProgramacion.size(); i++) {
            
            ProgramacionProfesorDTO objDTO = new ProgramacionProfesorDTO();
            objDTO.setProgramacionProfesor(listarProgramacion.get(i));
            
            Usuario objUsuario = UsuarioFCD.getUsuario(usuRut);
            objDTO.setUsuario(objUsuario);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarProgramacion.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);         
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }      
            
    public static List<ProgramacionProfesorDTO> listarProgramacionProfesorDTO(int usuRut) {

        List<ProgramacionProfesorDTO> listarObjDTO = new ArrayList<ProgramacionProfesorDTO>();
        List<ProgramacionProfesor> listarProgramacion = ProgramacionProfesorFCD.listarProgramacionProfesor(usuRut);                
        
        for (int i = 0; i < listarProgramacion.size(); i++) {
            
            ProgramacionProfesorDTO objDTO = new ProgramacionProfesorDTO();
            objDTO.setProgramacionProfesor(listarProgramacion.get(i));
            
            Usuario objUsuario = UsuarioFCD.getUsuario(usuRut);
            objDTO.setUsuario(objUsuario);
            
            Asignatura objAsignatura = AsignaturaFCD.getAsignatura(listarProgramacion.get(i).getId().getCodAsign());
            objDTO.setAsignatura(objAsignatura);         
            
            listarObjDTO.add(objDTO);            
        }        
    return listarObjDTO;        
    }      
    
            
    
    /*
    public static ArrayList<SelectItem> listarAños() {
        ArrayList<SelectItem> listarAños = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy");
        Date añoActual = UtilFCD.getSysdate();
        int año = UTIL.FuncionNumero.nvlInteger(formatoFecha.format(añoActual)) + 1;
        for (int i = año; i >= 2015; i--) {
            listarAños.add(new SelectItem(i, String.valueOf(i)));
        }
        return listarAños;
    }      
    */
    public static List<String> listarSemestres() {
        
        List<String> listarSemestres = new ArrayList<String>(); 
        listarSemestres.add("1");
        listarSemestres.add("2");        
        return listarSemestres;
    }     
    
    public static List<String> listarAñoscc() {
        
        List<String> listarSemestres = new ArrayList<String>(); 
        
        listarSemestres.add("2016");        
        listarSemestres.add("2017");
        listarSemestres.add("2018");        
        return listarSemestres;
    }      
    
    public static List<String> listarAnnios() {

        List<String> listarAnnio = new ArrayList<String>();
        listarAnnio.add("1");
        listarAnnio.add("2");
        listarAnnio.add("3");
               
    return listarAnnio;        
    }    
    
}
