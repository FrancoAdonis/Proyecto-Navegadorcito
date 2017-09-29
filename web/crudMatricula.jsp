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
    <img src="img/img-navegador.jpg" alt="" align="ri">
    <hgroup>
    <h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
    <h3>::.   CRUD Matrícula   .::</h3>
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
        <form name="formBuscar" id="formBuscar" action="buscarMatricula.action" method="POST" class="frm_nuevo">                               
                <ul>
                    <li>
			<p id="modificarP"></p>
			<h2>Ingrese Rut Alumno a buscar</h2>
			<span class="required_notification">* Datos requeridos</span>
                    </li>
                    <li>                                                                                       		                    
			<label for="lblRut">Rut:</label>
			<input value="${rutUsuario}" type="text" placeholder="134582056" name="rutUsuario" id="rutUsuario" required />
		        <input value="${dvUsuario}" type="text" placeholder="k" class="txtDv" name="dvUsuario" id="dvUsuario" required />                                  
		        <button class="submit" type="submit">Buscar Alumno</button>
		    </li>
                </ul>
        </form>  
        <div align="left" class="letra13" style="color: #D8000C"><div id="mensaje">${mensaje}</div></div>
    </article>  
                <article>
                    <div id="bloque_buscar">
                   Lista de Matrículas del Alumno&nbsp;&nbsp;		                 
                        <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Estudiante</b></td>
                        <td width="20%" style="text-align: center"><b>Año</b></td>
                        <td width="20%" style="text-align: center"><b>Semestre</b></td>
                        <td width="20%" style="text-align: center"><b>Carrera</b></td>
                    </tr>
                    <s:iterator value="listarMatriculaDTO">
                    <tr>
                        <td width="20%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="20%" style="text-align: center"><s:property value="matricula.id.getMatAño()" /></td>
                        <td width="20%" style="text-align: center"><s:property value="matricula.id.getMatSemestre()"/></td>
                        <td width="20%"><s:property value="carrera.getNomCarrera()" /></td>                       
                    </tr>
                    </s:iterator>
                    </table>                      
                    </div>                                    
                </article> 
		<article>                         
    <article>
        <form name="formAccion" action="" method="POST" class="frm_nuevo">  
            <input type="hidden" name="accion">
            <div>
		<ul>
                    <li>
                        <h2>Debe seleccionar botón con opción a realizar</h2>
                        <span class="required_notification">* Datos requeridos</span>
		    </li>
		    <li>
                        <label for="lblRut">Rut</label>                        
                        <input value="${rutUsuario}" type="text" placeholder="134582056" name="rutUsuario" id="rutUsuario" />
                        <input value="${dvUsuario}" type="text" placeholder="k"  maxlength="1" class="txtDv" name="dvUsuario" id="dvUsuario" />
		    </li>
		                <li>
                                    <label for="lblAño">Año</label>
                                    <input value="${matAnnio}" type="text" placeholder="2017" name="matAnnio" id="matAnnio" required/>
		                </li>                                
		                <li>
		                    <label for="lblSemestre">Semestre</label>
                                    <input value="${matSemestre}" type="text" placeholder="2" name="matSemestre" id="matSemestre" required />

		                </li>
				<li>
                                    <label for="Carrera">Carrera</label>
                           <select id="codCarreraV" name="codCarreraV" class="form_hint" required>
                             <option value="0">Seleccione...</option>
                        <s:iterator value="listarCarrera">
                            <option value="${codCarrera}" ${codCarrera == codCarreraV?'selected="selected"':'0'}>${nomCarrera}</option>
                         </s:iterator>
                    </select>   
                                </li>
                                <button class="submit" type="button" name="eliminar" value="eliminar" onClick="javascript:enviar('eliminarMatricula.action')">Eliminar Matr&iacute;cula</button>                    
                    <button class="submit" type="button" name="agregar" value="agregar" onClick="javascript:enviar('saveOrUpdateMatricula.action')">Insertar Matr&iacute;cula</button>                                   
                </ul>
            </div>
        </form>
    </article>
    </section>                      
</body>
</html>