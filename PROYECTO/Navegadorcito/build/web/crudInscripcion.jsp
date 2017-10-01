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
    <h3>::.   CRUD Inscripción Asignatura   .::</h3>
    </hgroup>
		<nav>
                    <ul>
                        <form name="formAccionMenu" action="" method="POST"> 
                            <li><a href="javascript:enviarMenu('crudUsuario.action')">Usuarios</a></li>   
                            <li><a href="javascript:enviarMenu('crudCarreras.action')">Carreras</a></li>
                            <li><a href="javascript:enviarMenu('crudAsignatura.action')">Asignaturas</a></li>                            
                            <li><a href="javascript:enviarMenu('crudMalla.action')">Mallas Curriculares</a></li>   
                            <li><a href="javascript:enviarMenu('crudMatricula.action')">Matr&iacute;cula</a></li>                            
                            <li><a href="javascript:enviarMenu('crudInscripcion.action')">Inscripción Asignatura</a></li>                                  
                            <li><a href="index.jsp">Salir</a></li>  
                        </form>                                
                    </ul>
		</nav>
</header>
<section>
    <article>
        <form name="formBuscar" id="formBuscar" action="buscarInscripcionAsignatura.action" method="POST" class="frm_nuevo">                               
                <ul>
                    <li>
			<p id="modificarP"></p>
			<h2>Ingrese Rut estudiante a buscar o datos de Inscripción a modificar</h2>
			<span class="required_notification">* Datos requeridos</span>
                    </li>
                    <li>                                                                                       		                    
			<label for="lblRut">Rut:</label>
			<input value="${rutUsuario}" type="text" placeholder="134582056" name="rutUsuario" id="rutUsuario" required />
		        <input value="${dvUsuario}" type="text" placeholder="k" class="txtDv" name="dvUsuario" id="dvUsuario" required />                                  
		  
		    </li>
		                <li>
                                    <label for="lblAño">Año</label>
                          <select id="insAnnio" name="insAnnio" class="form_hint">
                            <option value="0">Seleccione...</option>
                            <option value="2016" ${2016 == insAnnio?"selected":"0"}>2016</option>
                            <option value="2017" ${2017 == insAnnio?"selected":"0"}>2017</option>
                            <option value="2018" ${2018 == insAnnio?"selected":"0"}>2018</option>
                        </select> 
		                </li>                                
		                <li>
		        <label for="lblSemestre">Semestre</label>
                        <select id="insSemestre" name="insSemestre" class="form_hint">
                            <option value="0">Seleccione...</option>
                            <option value="1" ${1 == insSemestre?"selected":"0"}>1</option>
                            <option value="2" ${2 == insSemestre?"selected":"0"}>2</option>
                            <option value="3" ${3 == insSemestre?"selected":"0"}>3</option>
                        </select> 
		        </li>
			<li>
                        <label for="Asignatura">Asignatura</label>
                        <select id="codAsignV" name="codAsignV" class="form_hint" >
                            <option value="0">Seleccione...</option>  
                                <s:iterator value="listarAsignaturaMalla">
                                 <option value="${codAsign}" ${codAsign == codAsignV?'selected="selected"':'0'}>${sigla} - ${nomAsign}</option>
                                </s:iterator>
                        </select>                                    		                    
		        </li>
                        <li>
                        <label for="Paralelo">Paralelo</label>
                         <input value="${insParalelo}" type="text" placeholder="1" name="insParalelo" id="insParalelo" />                                    		                    		                                    
		        <button class="submit" type="submit">Buscar Inscripción</button>                    
                </ul>
        </form>  
        <div align="left" class="letra13" style="color: #D8000C"><div id="mensaje">${mensaje}</div></div>                        
    </article>  
                <article>
                    <div id="bloque_buscar">
                   Lista de Inscripciones actuales del Alumno&nbsp;&nbsp;		                 
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
                    </div>                                    
                </article>     
    <article>

        <form name="formAccion" action="" method="POST" class="frm_nuevo">  
            <input type="hidden" name="accion">
            <div>
		<ul>
		          <li>
		                    <h2>Debe Seleccionar botón con opción a Realizar</h2>
		                    <span class="required_notification">* Datos requeridos</span>
		                </li>
		    <li>
                        <label for="lblRut">Rut</label>                        
                        <input value="${rutUsuario}" type="text" placeholder="134582056" name="rutUsuario" id="rutUsuario" />
                        <input value="${dvUsuario}" type="text" placeholder="k"  maxlength="1" class="txtDv" name="dvUsuario" id="dvUsuario" />
		    </li>                                
		                <li>
                                    <label for="lblAño">Año</label>
                                    <input value="${insAnnio}" type="text" placeholder="2017" name="insAnnio" id="insAnnio" required/>
		                </li>                                
		                <li>
		                    <label for="lblSemestre">Semestre</label>
                                    <input value="${insSemestre}" type="text" placeholder="2" name="insSemestre" id="insSemestre" required />

		                </li>
				<li>
                                    <label for="Asignatura">Asignatura</label>                                    
                        <select id="codAsignV" name="codAsignV" class="form_hint" required>
                            <option value="0">Seleccione...</option>
                              <s:iterator value="listarAsignaturaMalla">
                                   <option value="${codAsign}" ${codAsign == codAsignV?'selected="selected"':'0'}>${sigla} - ${nomAsign}</option>
                                </s:iterator>
                        </select>                                      
		                </li>
				<li>
                                    <label for="Paralelo">Paralelo</label>
                                    <input value="${insParalelo}" type="text" placeholder="1" name="insParalelo" id="insParalelo" required/>                                    		                    
		                </li>  
				<li>
                                    <label for="estado">Estado</label>                                    
                        <select id="estAprobado" name="estAprobado" class="form_hint">
                            <option value="">Seleccione...</option>
                            <option value="PENDIENTE" ${estAprobado == 'PENDIENTE'?"selected":"0"}>PENDIENTE</option>
                            <option value="APROBADA" ${estAprobado == 'APROBADA'?"selected":"0"}>APROBADA</option>
                            <option value="REPROBADA" ${estAprobado == 'REPROBADA'?"selected":"0"}>REPROBADA</option>
                        </select>                                    
		                </li> 
                                <li>
                                    <label for="situacion">Situación</label>                                    
                        <select id="estInscripcion" name="estInscripcion" class="form_hint">
                            <option value="">Seleccione...</option>
                            <option value="INSCRITA" ${estInscripcion == 'INSCRITA'?"selected":"0"}>INSCRITA</option>
                            <option value="DESINSCRITA" ${estInscripcion == 'DESINSCRITA'?"selected":"0"}>DESINSCRITA</option>
                        </select>                                    
		                </li>  
                                <li>                                       
                    <button class="submit" type="button" name="eliminar" value="eliminar" onClick="javascript:enviar('eliminarInscripcionAsignatura.action')">Eliminar Inscripción</button>
                    <button class="submit" type="button" name="modificar" value="modificar" onClick="javascript:enviar('saveOrUpdateInscripcionAsignatura.action')">Modificar Inscripción</button>
                    <button class="submit" type="button" name="agregar" value="agregar" onClick="javascript:enviar('saveOrUpdateInscripcionAsignatura.action')">Insertar Inscripción</button>                                   
                </ul>
            </div>
        </form>
    </article>
    </section>                        
</body>
</html>