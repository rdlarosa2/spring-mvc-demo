<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar cliente</title>
</head>
<body>
  <h1>Consultar Cliente</h1>
  <table> 
     <form action="processEmployeeForm" method="GET"> <!-- processFormVersionTwo -->
     <tr>
        <td>
           <input type="text" name="clientName" id="clientName" placeholder="Cual es el nombre del cliente?" value="" />
        </td>
     </tr>
     <tr>   
        <td>       
           <input type="text" name="clientPassword" id="clientPassword" placeholder="Cual es la clave del cliente?" value="" />
        </td>
     </tr>
     <tr>  
        <td>        
           <input type="submit" value="Submit Query" />
        </td>
     </tr>   
     </form>
  </table>        
</body>
</html>