
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
        <link type="text/css" rel="stylesheet" href="css/theme.css" />
        <link type="text/css" rel="stylesheet" href="css/estilo.css" />         
        <link type="text/css" rel="stylesheet" href="css/enc_estilo.css" />
        <link href="css/datePicker.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/alertas.css" />
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.15.custom.min.js"></script>      
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos a Navegadorcito</title>
        
<script language="JavaScript">       
    function enviarMenu(accion){
        document.formAccionMenu.action = accion.valueOf();   
        document.formAccionMenu.submit();        
    }    
</script>          
    </head>
    <body style="margin-left: 40px; margin-top: 10px">
        
	<header>
		<img src="images/img-navegador.jpg" alt="" align="ri" width="30%" height="10%">
		<hgroup>
			<h1>NAVEGADORCITO - Ingenieria Web Avanzada</h1>
                        <h3>::.   Gesti&oacute;n Administrador   .::</h3>
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
	</section>
    </body>
</html>