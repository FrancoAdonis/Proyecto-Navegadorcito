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
</script>
</head>
<body onload="escondeBloque('bloque_buscar',${opc_bloque});">
<header>
    <img src="images/img-navegador.jpg" alt="" align="ri" width="30%" height="10%">
    <hgroup>
    <h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
    <h3>::.   CRUD Inscripciones   .::</h3>
    </hgroup>
		<nav>
                    <ul>
                        <form name="formAccionMenu" action="" method="POST"> 
                            <input type="hidden" name="usuRut"  value="${usuRut}" /> 
                            <li><a href="javascript:enviarMenu('crudAluUsuario.action')">Datos Personales</a></li>                              
                            <li><a href="javascript:enviarMenu('crudAluInscripcion.action')">Asignaturas Inscritas</a></li>                                  
                            <li><a href="index.jsp">Salir</a></li>   
                        </form>                                
                    </ul>
		</nav>
</header>
<section>                    
                <article>
                        Asignaturas Inscritas del Per&iacute;odo Actual		                 
                        <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Estudiante</b></td>
                        <td width="10%" style="text-align: center"><b>Año</b></td>
                        <td width="10%" style="text-align: center"><b>Semestre</b></td>
                        <td width="20%" style="text-align: center"><b>Asignatura</b></td>
                        <td width="10%" style="text-align: center"><b>Paralelo</b></td>
                        <td width="20%" style="text-align: center"><b>Est. Asignatura</b></td>
                        <td width="20%" style="text-align: center"><b>Est. Inscripción</b></td>
                    </tr>
                    <s:iterator value="listarAsignaturasInscritasDTO">
                    <tr>
                        <td width="20%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="10%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsAño()" /></td>
                        <td width="10%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsSemestre()"/></td>
                        <td width="20%"><s:property value="asignatura.getNomAsign()" /></td>       
                        <td width="10%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsParalelo()" /></td>
                        <td width="20%" style="text-align: center"><s:property value="inscripcionAsignatura.getEstAprobado()"/></td>
                        <td width="20%" style="text-align: center"><s:property value="inscripcionAsignatura.getEstInscripcion()" /></td>                          
                    </tr>
                    </s:iterator>
                    </table>                                                       
                </article>             
                <article>                    
                Ver Inscripciones Hist&oacute;ricas&nbsp;&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',2)"><img src="images/if_Zoom In_27888.png" alt="" width="20px" height="20px" ></a>&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',1)"><img src="images/if_Zoom Out_27889.png" alt="" width="20px" height="20px" ></a></li>			
                <div id="bloque_buscar">
                 <b>Seleccione filtro:</b>
            <form name="formAccion" action="" method="POST" class="frm_nuevo">  
                    <input type="hidden" name="usuRut"  value="${usuRut}" /> 
                    <table border ="0" style="width: 60%">
                    <tr>
                    <td width="10%" style="vertical-align: top">Año:&nbsp;                   
                        <select id="insAnnio" name="insAnnio" class="form_hint">
                            <option value="0">Seleccione...</option>
                            <option value="2016" ${2016 == insAnnio?"selected":"0"}>2016</option>
                            <option value="2017" ${2017 == insAnnio?"selected":"0"}>2017</option>
                            <option value="2018" ${2018 == insAnnio?"selected":"0"}>2018</option>
                        </select>                                                     
                        </td>
                        <td width="15%">Semestre:&nbsp;
                        <select id="insSemestre" name="insSemestre" class="form_hint">
                            <option value="0">Seleccione...</option>
                            <option value="1" ${1 == insSemestre?"selected":"0"}>1</option>
                            <option value="2" ${2 == insSemestre?"selected":"0"}>2</option>
                            <option value="3" ${3 == insSemestre?"selected":"0"}>3</option>
                        </select> 
                        </td>
                        <td width="15%">Estado:&nbsp;<select id="estAprobado" name="estAprobado" class="form_hint">
                            <option value="">Seleccione...</option>
                            <option value="PENDIENTE" ${estAprobado == 'PENDIENTE'?"selected":"0"}>PENDIENTE</option>
                            <option value="APROBADA"  ${estAprobado == 'APROBADA'?"selected":"0"}>APROBADA</option>
                            <option value="REPROBADA" ${estAprobado == 'REPROBADA'?"selected":"0"}>REPROBADA</option>
                        </select>  
                        </td>                        
                        <td width="20%">                            
                            <button class="submit" type="button" name="limpiar" value="limpiar" onClick="javascript:enviar('limpiarFiltroInsc.action')">Limpiar filtros</button>
                            <button class="submit" type="button" name="filtrar" value="filtrar" onClick="javascript:enviar('filtrarInscripcion.action')">Buscar filtros</button>
                        </td>                        
                        
                    </tr>
                 </table><br>
                </form>
                <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Estudiante</b></td>
                        <td width="10%" style="text-align: center"><b>Año</b></td>
                        <td width="10%" style="text-align: center"><b>Semestre</b></td>
                        <td width="20%" style="text-align: center"><b>Asignatura</b></td>
                        <td width="10%" style="text-align: center"><b>Paralelo</b></td>
                        <td width="20%" style="text-align: center"><b>Est. Asignatura</b></td>
                        <td width="20%" style="text-align: center"><b>Est. Inscripción</b></td>
                    </tr>
                    <s:iterator value="listarInscripcionDTO">
                    <tr>
                        <td width="20%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="10%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsAño()" /></td>
                        <td width="10%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsSemestre()"/></td>
                        <td width="20%"><s:property value="asignatura.getNomAsign()" /></td>       
                        <td width="10%" style="text-align: center"><s:property value="inscripcionAsignatura.id.getInsParalelo()" /></td>
                        <td width="20%" style="text-align: center"><s:property value="inscripcionAsignatura.getEstAprobado()"/></td>
                        <td width="20%" style="text-align: center"><s:property value="inscripcionAsignatura.getEstInscripcion()" /></td>                          
                    </tr>
                    </s:iterator>
                    </table>                                                        
                </article>          
    </section>                        
</body>
</html>