<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <h2>NAVEGADORCITO - Ingenieria Web Avanzada</h2>
    <h3>::.   CRUD Usuarios   .::</h3>
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
        <form name="formBuscar" id="formBuscar" action="buscarUsuario.action" method="POST" class="frm_nuevo">                               
                <ul>
                    <li>
			<h2>Ingrese Rut usuario a buscar</h2>
			<span class="required_notification">* Datos requeridos</span>
                    </li>
                    <li>                                                                                       		                    
			<label for="lblRut">Rut</label>
			<input value="${rutUsuario}" type="text" placeholder="134582056" name="rutUsuario" id="rutUsuario" required />
		        <input value="${dvUsuario}" type="text" placeholder="k" class="txtDv" name="dvUsuario" id="dvUsuario" required />
		        <button class="submit" type="submit">Buscar Usuario</button>
		    </li>
                </ul>
        </form>  
                        <div align="left" class="letra13" style="color: #D8000C"><div id="mensaje">${mensaje}</div></div>                        
    </article>  
                <article><div>                    
                    Ver Lista de Usuario existentes&nbsp;&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',2)"><img src="images/if_Zoom In_27888.png" alt="" width="20px" height="20px" ></a>&nbsp;<a onClick="javascript:escondeBloque('bloque_buscar',1)"><img src="images/if_Zoom Out_27889.png" alt="" width="20px" height="20px" ></a></li>			
                    </div>
                    <div id="bloque_buscar">
                        <table border ="1">
                    <tr>
                        <td width="20%" style="text-align: center"><b>Rut</b></td>
                        <td width="20%" style="text-align: center"><b>Nombre</b></td>
                        <td width="20%" style="text-align: center"><b>Dirección</b></td>
                        <td width="20%" style="text-align: center"><b>Correo</b></td>
                        <td width="20%" style="text-align: center"><b>Perfil</b></td>
                        <td width="20%" style="text-align: center"><b>Clave</b></td>
                    </tr>

                    <s:iterator value="listarUsuarioDTO">
                    <tr>
                        <td width="10%"><s:property value="usuario.getUsuRut()"/>-<s:property value="usuario.getUsuDv()"/></td>
                        <td width="25%"><s:property value="usuario.getUsuNombre()"/> <s:property value="usuario.getUsuPaterno()"/> <s:property value="usuario.getUsuMaterno()"/></td>
                        <td width="25%"><s:property value="usuario.getDireccion()"/></td>
                        <td width="20%"><s:property value="usuario.getCorreo()"/></td>
                        <td width="10%"><s:property value="tipoPerfil.getNomPerfil()"/></td>
                        <td width="10%"><s:property value="usuario.getClave()"/></td>
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
                        <h2>Debe seleccionar botón con opción a realizar</h2>
                        <span class="required_notification">* Datos requeridos</span>
		    </li>
		    <li>
                        <label for="lblRut">Rut</label>                        
                        <input value="${rutUsuario}" type="text" placeholder="134582056" name="rutUsuario" id="rutUsuario" />
                        <input value="${dvUsuario}" type="text" placeholder="k"  maxlength="1" class="txtDv" name="dvUsuario" id="dvUsuario" />
		    </li>
                    <li>
                        <label for="lblNombre">Nombre</label>
                        <input value="${nombreUsuario}" type="text" placeholder="Ismael" name="nombreUsuario" id="nombreUsuario" required />
                    </li>
                    <li>
                        <label for="lblApellidoP">Apellido Paterno</label>
                        <input value="${paternoUsuario}" type="text" placeholder="Figueroa" name="paternoUsuario" id="paternoUsuario" required />
                    </li>
                    <li>
                        <label for="lblApellidoM">Apellido Materno</label>
                        <input value="${maternoUsuario}" type="text" placeholder="Ponce" name="maternoUsuario" id="maternoUsuario"required />
                    </li>
                    <li>
                        <label for="lblDireccion">Direccion</label>
                        <input value="${direccionUsuario}" type="text" placeholder="Av. los pensamientos N° 555, Viña del Mar" name="direccionUsuario" id="direccionUsuario" required />
                    </li>
                    <li>
                        <label for="email">Email:</label>
                        <input value="${correoUsuario}" type="email" placeholder="info@pucv.com" name="correoUsuario" id="correoUsuario" required />
                        <span class="form_hint">Formato correcto: "taller2@mvc.cl"</span>
                    </li>
                    <li>
                        <label for="lblClave">Contraseña (inicial)</label>
                        <input value="${claveUsuario}" type="text" placeholder="123456" name="claveUsuario" id="claveUsuario" required />
                    </li>                    
                    <li>
                     <label for="perfil">Tipo Usuario:</label>                                                                                
                    <select id="codTipoPerfil" name="codTipoPerfil" class="form_hint">
                        <option value="0">Seleccione...</option>
                <s:iterator value="listarTipoPerfil">
                    <option value="${codPerfil}" ${codPerfil == codTipoPerfil?'selected="selected"':''}>${nomPerfil}</option>
                </s:iterator>
                    </select>                         
                    </li>                    
                    <li>                                       
                    <button class="submit" type="button" name="eliminar" value="eliminar" onClick="javascript:enviar('eliminarUsuario.action')">Eliminar Usuario</button>
                    <button class="submit" type="button" name="modificar" value="modificar" onClick="javascript:enviar('modificarUsuario.action')">Modificar Usuario</button>
                    <button class="submit" type="button" name="agregar" value="agregar" onClick="javascript:enviar('agregarUsuario.action')">Insertar Usuario</button>                                   
                </ul>
            </div>
        </form>
    </article>
    </section>                       
</body>
</html>