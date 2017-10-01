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
    function enviarMenu(accion){
        document.formAccionMenu.action = accion.valueOf();   
        document.formAccionMenu.submit();        
    }  
       
</script>
</head>
<body>
<header>
    <img src="images/img-navegador.jpg" alt="" align="ri" width="30%" height="10%">
    <hgroup>
    <h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
    <h3>::.   CRUD Ficha Estudiante   .::</h3>
    </hgroup>
		<nav>
                    <ul>
                        <form name="formAccionMenu" action="" method="POST">                                                 
                            <li><a href="JavaScript:window.close();">Cerrar Ficha</a></li>                                    
                        </form>                                
                    </ul>
		</nav>
</header>
<section>                                      
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
                        <label for="lblNombre">Nombre</label>
                        <input value="${nombreUsuario}" type="text" placeholder="Ismael" name="nombreUsuario" id="nombreUsuario" disabled />
                    </li>
                    <li>
                        <label for="lblApellidoP">Apellido Paterno</label>
                        <input value="${paternoUsuario}" type="text" placeholder="Figueroa" name="paternoUsuario" id="paternoUsuario" disabled />
                    </li>
                    <li>
                        <label for="lblApellidoM">Apellido Materno</label>
                        <input value="${maternoUsuario}" type="text" placeholder="Ponce" name="maternoUsuario" id="maternoUsuario" disabled />
                    </li>
                    <li>
                        <label for="lblDireccion">Direccion</label>
                        <input value="${direccionUsuario}" type="text" placeholder="Av. los pensamientos N° 555, Viña del Mar" name="direccionUsuario" id="direccionUsuario" disabled />
                    </li>
                    <li>
                        <label for="email">Email:</label>
                        <input value="${correoUsuario}" type="email" placeholder="info@pucv.com" name="correoUsuario" id="correoUsuario" disabled />
                        <span class="form_hint">Formato correcto: "taller2@mvc.cl"</span>
                    </li>                                     
                    <li>                                       
                </ul>
            </div>
        </form>
    </article>
    </section>                       
</body>
</html>