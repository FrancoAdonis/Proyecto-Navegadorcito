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
    <h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
    <h3>::.   CRUD Datos Personales   .::</h3>
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
 <div align="left" class="letra13" style="color: #D8000C"><div id="mensaje">${mensaje}</div></div>                                                 
        <form name="formAccion" action="" method="POST" class="frm_nuevo">  
            <input type="hidden" name="accion">
            <div>
		<ul>
                    <li>
                        <h2>Debe seleccionar botón con opción a realizar</h2>
                        <span class="required_notification">* Datos requeridos</span>
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
                    <button class="submit" type="button" name="modificar" value="modificar" onClick="javascript:enviar('modificarAluUsuario.action')">Modificar Usuario</button>                   
                </ul>
            </div>
        </form>
    </article>
    </section>                       
</body>
</html>