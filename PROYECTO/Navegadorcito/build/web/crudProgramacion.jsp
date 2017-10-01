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
                <article>
                    Programaci&oacute;n Semestral del Per&iacute;odo Actual	                 
                        <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Profesor</b></td>
                        <td width="10%" style="text-align: center"><b>Año</b></td>
                        <td width="10%" style="text-align: center"><b>Semestre</b></td>
                        <td width="20%" style="text-align: center"><b>Asignatura</b></td>
                        <td width="10%" style="text-align: center"><b>Paralelo</b></td>
                    </tr>
                    <s:iterator value="listarProgramacionSemestralDTO">
                    <tr>
                        <td width="20%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="10%" style="text-align: center"><s:property value="programacionProfesor.id.getProAño()" /></td>
                        <td width="10%" style="text-align: center"><s:property value="programacionProfesor.id.getProSemestre()"/></td>
                        <td width="20%"><s:property value="asignatura.getNomAsign()" /></td>       
                        <td width="10%" style="text-align: center"><s:property value="programacionProfesor.id.getProParalelo()" /></td>                      
                    </tr>
                    </s:iterator>
                    </table>                                                       
                </article>             
                <article>                    
                Ver Programaciones Hist&oacute;ricas&nbsp;&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',2)"><img src="images/if_Zoom In_27888.png" alt="" width="20px" height="20px" ></a>&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',1)"><img src="images/if_Zoom Out_27889.png" alt="" width="20px" height="20px" ></a></li>			
                <div id="bloque_buscar">
                 <b>Seleccione filtro:</b>
                <form name="formAccion" action="" method="POST" class="frm_nuevo">
                    <input type="hidden" name="usuRut"  value="${usuRut}" /> 
                    <table border ="1" style="width: 60%">
                    <tr>
                        <td width="10%" style="vertical-align: top">Año:&nbsp;                   
                        <select id="proAnnio" name="proAnnio" class="form_hint">
                            <option value="0">Seleccione...</option>
                            <option value="2016" ${2016 == proAnnio?"selected":"0"}>2016</option>
                            <option value="2017" ${2017 == proAnnio?"selected":"0"}>2017</option>
                            <option value="2018" ${2018 == proAnnio?"selected":"0"}>2018</option>
                        </select>                                                     
                        </td>
                        <td width="10%">Semestre:&nbsp;
                        <select id="proSemestre" name="proSemestre" class="form_hint">
                            <option value="0">Seleccione...</option>
                            <option value="1" ${1 == proSemestre?"selected":"0"}>1</option>
                            <option value="2" ${2 == proSemestre?"selected":"0"}>2</option>
                            <option value="3" ${3 == proSemestre?"selected":"0"}>3</option>
                        </select> 
                        </td>
                        
                        <td width="20%"  style="text-align: left">                            
                            <button class="submit" type="button" name="limpiar" value="limpiar" onClick="javascript:enviar('limpiarFiltro.action')">Limpiar filtros</button>
                            <button class="submit" type="button" name="filtrar" value="filtrar" onClick="javascript:enviar('filtrarProgramacion.action')">Buscar filtros</button>
                        </td>
                        
                    </tr>
                 </table><br>                
                <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Profesor</b></td>
                        <td width="10%" style="text-align: center"><b>Año</b></td>
                        <td width="10%" style="text-align: center"><b>Semestre</b></td>
                        <td width="20%" style="text-align: center"><b>Asignatura</b></td>
                        <td width="10%" style="text-align: center"><b>Paralelo</b></td>
                    </tr>
                    <s:iterator value="listarProgramacionDTO">
                    <tr>                       
                        <td width="20%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="10%" style="text-align: center"><s:property value="programacionProfesor.id.getProAño()" /></td>
                        <td width="10%" style="text-align: center"><s:property value="programacionProfesor.id.getProSemestre()"/></td>
                        <td width="20%"><s:property value="asignatura.getNomAsign()" /></td>       
                        <td width="10%" style="text-align: center"><s:property value="programacionProfesor.id.getProParalelo()" /></td>                     
                    </tr>
                    </s:iterator>
                    </table>   
                 </form>
                </div>
                </article>          
    </section>                        
</body>
</html>