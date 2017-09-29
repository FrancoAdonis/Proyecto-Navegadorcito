<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenidos a Navegadorcito</title>
    <link type="text/css" rel="stylesheet" href="css/theme.css" />
    <link type="text/css" rel="stylesheet" href="css/estilo.css" />         
    <link type="text/css" rel="stylesheet" href="css/enc_estilo.css" />
    <link href="css/datePicker.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/alertas.css" />
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>        
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
<script language="JavaScript">    
    function enviar(accion){
        document.formAccion.action = accion.valueOf();        
        document.formAccion.submit();        
    }
    
    function enviarMenu(accion){
        document.formAccionMenu.action = accion.valueOf();   
        document.formAccionMenu.submit();        
    }     
    
  function escondeBloque(idBloque, opcion){
    var accion = 'block';
    if (opcion == 1) accion = 'none';
    if (document.layers && document.layers[idBloque] != null)
      document.layers[idBloque].display = accion;
    else if (document.all && document.all[idBloque] != null)
      document.all[idBloque].style.display = accion;
    else if (document.getElementById && document.getElementById(idBloque) != null)
      document.getElementById(idBloque).style.display = accion;
}      

    function enviarFicha(f){      
        f.submit();        
    }
</script>
</head>
<body onload="escondeBloque('bloque_buscar',${opc_bloque});">
<header>
    <img src="img/img-navegador.jpg" alt="" align="ri">
    <hgroup>
    <h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
    <h3>::.   CRUD Programaci&oacute;n   .::</h3>
    </hgroup>
		<nav>
                    <ul>
                        <form name="formAccionMenu" action="" method="POST">
                        <input type="hidden" name="usuRut"  value="${usuRut}" />                            
                            <li><a href="javascript:enviarMenu('crudProgramacion.action')">Programaci&oacute;n</a></li>                              
                            <li><a href="javascript:enviarMenu('crudCurso.action')">Alumnos Inscritos</a></li>                                  
                            <li><a href="index.jsp">Salir</a></li>   
                        </form>                                
                    </ul> 
		</nav>
</header>
<section>              
           <form name="formAccion" action="" method="POST" class="frm_nuevo">
           <input type="hidden" name="usuRut"  value="${usuRut}" /> 
                <article>
                    Seleccione Asignatura del Per&iacute;odo Actual<br>
                   <table border ="0" style="width: 60%">
                    <tr>
                        <td width="70%" style="vertical-align: top">Asignatura:&nbsp;
                        <select id="codAsignV" name="codAsignV" class="form_hint" required>
                            <option value="0">Seleccione...</option>
                         <s:iterator value="listarProgramacionSemestralDTO">
                             <option value="${asignatura.getCodAsign()}" ${asignatura.getCodAsign() == codAsignV?'selected="selected"':'0'}>${asignatura.getSigla()} - ${asignatura.getNomAsign()}</option>
                             </s:iterator>
                        </select>  
                        <td width="10%">                            
                        <button class="submit" type="button" name="buscarCurso" value="buscarCurso" onClick="javascript:enviar('buscarCurso.action')">Ver Curso</button>                                                                            
                        </td>  
                        <td>&nbsp;</td>                         
                    </tr>
                 </table><br>                
                </article> 
                   </form>   
                <div id="bloque_buscar">                 
                <article>                    
                Lista de Curso&nbsp;&nbsp		                                
                    <br>                
                <table border ="1">
                    <tr>
                        <td width="5%" style="text-align: center"><b>Año</b></td>
                        <td width="5%" style="text-align: center"><b>Semestre</b></td>                        
                        <td width="20%" style="text-align: center"><b>Estudiante</b></td>
                        <td width="20%" style="text-align: center"><b>Asignatura</b></td>
                        <td width="5%" style="text-align: center"><b>Paralelo</b></td>
                        <td width="15%" style="text-align: center"><b>Est. Asignatura</b></td>
                        <td width="15%" style="text-align: center"><b>Est. Inscripción</b></td>                        
                        <td width="5%" style="text-align: center"><b>Ver Ficha</b></td> 
                    </tr>
                    <s:iterator value="listarCursoDTO">
                    <form name="formFicha${inscripcionAsignatura.id.usuRut}" action="verFicha.action" method="POST" class="frm_nuevo" target="_new">
                        <input type="hidden" name="rutFicha"  value="${inscripcionAsignatura.id.usuRut}" /> 
                    <tr>
                        <td width="5%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsAño()" /></td>
                        <td width="5%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsSemestre()"/></td>
                        <td width="20%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="20%"><s:property value="asignatura.getNomAsign()" /></td>       
                        <td width="5%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsParalelo()" /></td>
                        <td width="15%" style="text-align: center"><s:property value="inscripcionAsignatura.getEstAprobado()"/></td>
                        <td width="15%" style="text-align: center"><s:property value="inscripcionAsignatura.getEstInscripcion()" /></td>      
                        <td width="5%" style="text-align: center">                           
                            <a href="javascript:enviarFicha(document.formFicha${inscripcionAsignatura.id.usuRut})" title="Ver ficha del estudiante"><img src="images/icon_accion_search.png" alt="" width="25px" height="25px" ></a>
                        </td>                        
                    </tr>
                    </form>
                    </s:iterator>
                    </table>                                     
                </article>   
                    </div>
                      
    </section>                        
</body>
</html>