/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import POJOS.ProgramacionProfesor;
import POJOS.Usuario;
import POJOS.Asignatura;
import java.io.Serializable;


public class ProgramacionProfesorDTO implements Serializable {    
    
    private Usuario usuario;
    private ProgramacionProfesor programacionProfesor;
    private Asignatura asignatura;

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ProgramacionProfesor getProgramacionProfesor() {
        return programacionProfesor;
    }

    public void setProgramacionProfesor(ProgramacionProfesor programacionProfesor) {
        this.programacionProfesor = programacionProfesor;
    }
    
}
