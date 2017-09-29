<%-- 
    Document   : newjspformAddUser
    Created on : 28-08-2017, 23:22:01
    Author     : karina.pasten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <link type="text/css" rel="stylesheet" href="css/theme.css" />
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />         
        <link type="text/css" rel="stylesheet" href="css/enc_estilo.css" />
        <link href="css/datePicker.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/alertas.css" />
        
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.15.custom.min.js"></script>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin-left: 40px; margin-top: 10px">
 <form name="form" method="post" action="xxxxx">
									
	<table>
            <tr><td>INGRESE CONTRASEÑA:<br><hr>
            </td></tr>
	<tr><td>(*) Ingrese su Rut</td>
            <td><input name="old"  id="old" type="password" maxlength="15" onkeypress="return f_ingresar_solo_alfanumericos(event);"></td><td></td></tr><input name="rut_num" type="hidden" value="13855538"><input name="cambio" type="hidden" value="1">   
	<tr> 
	<td class="w20 label"><span class="obligatorio">(*)</span>
	Ingrese contrase&ntilde;a 
	</td>
	<td class="w15">
	<input name="CONTRASENA" id="CONTRASENA" type="password" maxlength="15" onkeypress="valida_longitud_CONTRASENA()">
	</td>
	<td id="td_info_password1"></td>
	</tr>
	<tr> 
	<td class="label">
	<span class="obligatorio">(*)</span> Confirme contrase&ntilde;a
	</td>
	<td>
	<input name="RE_CONTRASENA" id="RE_CONTRASENA" type="password" maxlength="15" onkeypress="valida_longitud_RE_CONTRASENA()">
	</td>
	<td id="td_info_password2"></td>
	</tr>
	<tr>
	<td></td>
	<td>
	<input type="submit" class="boton" name="Submit" value="Guardar contrase&ntilde;a">		                		
	</td>
	<td></td>
	</tr>
	</table>
									                		                
	</form>

    </body>
</html>
