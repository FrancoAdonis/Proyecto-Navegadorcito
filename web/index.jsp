<%-- 
    Document   : index
    Created on : 28-08-2017, 22:37:43   
 
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
        <title>Navegador Académico</title>
    </head>
    <body style="margin-left: 40px; margin-top: 10px">
    <form action="checkLogin.action" method="POST">            
        <table border="0">
        <tr>                    
            <td colspan="3">
                <br><br>Ingrese su Rut y Contraseña para iniciar sesión.<br><br>
            </td>
        </tr>            
        <tr>                    
            <td>Rut:</td>
            <td colspan="2">
                <input size="9" maxLength="9" type="text" name="usuRut" value=""  /> 
                - 
                <input size="1" maxLength="1" type="text" name="dv" value="" />
            </td>
        </tr>
        <tr>                    
            <td colspan="3"><br></td>
        </tr>          
        <tr>            
            <td>
               Contrase&ntilde;a:
            </td>
            <td>
                <input size="15" maxLength="15" type="password" name="password" />                								
            </td>
            <td>
             <input type="submit" value="Ingresar" />   
            </td>
        </tr>
        <tr>
            <td colspan="3" style="color: #cd0a0a; font-size:14px;">${mensaje}</td>
        </tr>
        <tr>            
            <td colspan="3">
                <a href="AddUser.jsp">Nuevo usuario</a>
            </td>
        </tr>        
        </table>      
 </form>        
    </body>
</html>
