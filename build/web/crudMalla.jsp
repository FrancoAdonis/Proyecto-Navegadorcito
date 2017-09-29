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
<body onload="escondeBloque('bloque_buscar',1);">
	<header>
		<img src="img/img-navegador.jpg" alt="" align="ri">
		<hgroup>
			<h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
			<h3>::.   CRUD Mallas Curriculares   .::</h3>
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
		<form name="formBuscar" id="formBuscar" action="buscarMallaCurricular.action" method="POST" class="frm_nuevo"> 
		<div>
                    <ul>
			<li>
			<h2>Ingrese datos de Malla Curricular a buscar</h2>
			</li>
                    <li>
                     <label for="carrera">Carrera:</label>                                                                                 
                    <select id="codCarreraV" name="codCarreraV" class="form_hint">
                             <option value="0">Seleccione...</option>
                        <s:iterator value="listarCarrera">                            
                            <option value="${codCarrera}" ${codCarrera == codCarreraV?'selected="selected"':'0'}>${nomCarrera}</option>
                         </s:iterator>
                    </select>                         
		     </li> 
                                <li>
		            <label for="lblAsignatura">Asignatura:</label>
                        <select id="codAsignV" name="codAsignV" class="form_hint">
                            <option value="0">Seleccione...</option>
                         <s:iterator value="listarAsignatura">
                             <option value="${codAsign}" ${codAsign == codAsignV?'selected="selected"':'0'}>${sigla} - ${nomAsign}</option>
                             </s:iterator>
                        </select>  
                                </li>
                                <li>
                                    <label for="lblCodigoP">Código plan:</label>
                                    <input value="${codPlan}" type="text" placeholder="1" name="codPlan" id="codPlan" />
		                    <button class="submit" type="submit">Buscar Malla Curricular</button>
		                </li>
				</ul>
				</div>
			</form>
                <div align="left" class="letra13" style="color: #D8000C"><div id="mensaje">${mensaje}</div></div>                                       
		</article> 
                <article><div>                                      
                    Ver Lista de Mallas Curriculares&nbsp;&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',2)"><img src="images/if_Zoom In_27888.png" alt="" width="20px" height="20px" ></a>&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',1)"><img src="images/if_Zoom Out_27889.png" alt="" width="20px" height="20px" ></a></li>			
                    </div>
                    <div id="bloque_buscar">
                        <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Código Plan</b></td>
                        <td width="20%" style="text-align: center"><b>Nombre Carrera</b></td>
                        <td width="20%" style="text-align: center"><b>Nombre Asignatura</b></td>
                        <td width="20%" style="text-align: center"><b>Año Malla</b></td>
                        <td width="20%" style="text-align: center"><b>Estado</b></td>
                    </tr>

                    <s:iterator value="listarMallaDTO">
                    <tr>
                        <td width="20%" style="text-align: center"><s:property value="mallaCurricular.id.getCodPlan()" /></td>
                        <td width="20%"><s:property value="carrera.getNomCarrera()"/></td>
                        <td width="20%"><s:property value="asignatura.getNomAsign()" /></td>
                        <td width="20%" style="text-align: center"><s:property value="mallaCurricular.getAñoMalla()"/></td>
                        <td width="20%" style="text-align: center"><s:property value="mallaCurricular.getVigente()" /></td>                        
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
                                    <label for="lblPlan">N° plan</label>
                                    <input value="${codPlan}" type="text" placeholder="1" name="codPlan" id="codPlan" required/>
		                </li>                                
		                <li>
		                    <label for="lblCodigoC">Código carrera</label>                                    
                                 <select id="codCarreraV" name="codCarreraV" class="form_hint" required>
                                     <option value="0">Seleccione...</option>
                                 <s:iterator value="listarCarrera">
                                  <option value="${codCarrera}" ${codCarrera == codCarreraV?'selected="selected"':'0'}>${nomCarrera}</option>
                                 </s:iterator>
                                 </select>   
		                </li>
				<li>
                                    <label for="Sigla">Asignatura</label>
                             <select id="codAsignV" name="codAsignV" class="form_hint" required>
                                 <option value="0">Seleccione...</option>
                             <s:iterator value="listarAsignatura">
                                 <option value="${codAsign}" ${codAsign == codAsignV?'selected="selected"':'0'}>${sigla} - ${nomAsign}</option>
                             </s:iterator>
                             </select>                                                                          
		                </li>
				<li>
                                    <label for="añoMalla">Año malla</label>
                                    <input value="${añoMalla}" type="text" placeholder="2017" name="añoMalla" id="añoMalla" required/>                                    		                    
		                </li>  
				<li>
                                    <label for="vigente">Vigencia</label>
                             <select id="vigente" name="vigente" class="form_hint" required>
                            <option value="0">Seleccione...</option>
                            <option value="VIGENTE" ${vigente == 'VIGENTE'?"selected":''}>VIGENTE</option>
                            <option value="NO VIGENTE" ${vigente == 'NO VIGENTE'?"selected":''}>NO VIGENTE</option>                            
                        </select>                                                         
		                </li>                                                                   
			<li>
                    <button class="submit" type="button" name="eliminar" value="eliminar" onClick="javascript:enviar('eliminarMallaCurricular.action')">Eliminar Malla Curricular</button>
                    <button class="submit" type="button" name="modificar" value="modificar" onClick="javascript:enviar('saveOrUpdateMallaCurricular.action')">Modificar Malla Curricular</button>
                    <button class="submit" type="button" name="agregar" value="agregar" onClick="javascript:enviar('saveOrUpdateMallaCurricular.action')">Insertar Malla Curricular</button>                                   
		                </li>
		                
		            </ul>
        		</div>
			</form>
		</article>		
	</section>
</body>
</html>