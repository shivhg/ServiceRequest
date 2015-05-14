<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page errorPage="badPage.jsp"  %>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.nttdata.infra.services.InfraSystemFacade"%>
<%@page import="com.nttdata.infra.domain.User"%>
<%@page import="com.nttdata.infra.services.InfraAppException"%>
<html><!-- #BeginTemplate "../template/NNTemplate.dwt" -->
<title> Create Service Request </title>
<head>
<link rel="stylesheet" type="text/css" href="../css/Stylesheet.css">
<script Language="JavaScript" src="../js/ServiceRequest.js"> </script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="lblTitle" width="100%">
		<div id='DIVPageTitle'><b>Service Request System</b></div>
		</td>
		<td width="266" align="right" valign="top"><img src="../images/caritor.jpg" alt="caritor"
		width="40%" height="100"></td>
	</tr>
	<tr height="13%" align="left">
		<td colspan="3" class="blueBackGround"></td>
	</tr>
	<tr height="13%" align="left" valign="top">
		<td colspan="3" class="orangeBackGround"></td>
	</tr>
</table>
<script type="text/javascript">
function validate() {
var x = document.getElementById("cn").value;
var y = document.getElementById("dp").value;
var z = document.getElementById("rd").value;
var a = document.getElementById("rt").value;
if(x==null||x==""||y==null||y==""||z==null||z==""||a==null||a=="") {
alert("required all fields");
return false;
}
}


</script>
</head>


<body class="background" text="#000000" >
<form method="post" name="frmCreateRequest" action="CreateRequest.do" onsubmit="return validate()">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
    	<tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>Create Service Request</b>
			  </td>
    	</tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Location
			  </td>
			  <td align="left" class="mainLabel">
			  <Select  name= "loc" class="txbEnabledText">
			   <Option value="0">--Select--</Option>
			   <Option value="1">BLR-SER1</Option>
			   <Option value="2">BLR-SER2</Option>
			   <Option value="3">BLR-BTR1</Option>
			   <Option value="4">BLR-BTR2</Option>
			   <Option value="5">CHN-PGR1</Option>
			   <Option value="6">CHN-PGR2</Option>
			   <Option value="7">CHN-PGR3</Option>
			  </Select>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Cubical No.
			  </td>
			  <td align="left" class="mainLabel">
			  <input type="text" name="cub" class="txbEnabledText" id = "cn">
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
					Department
				  </td>
				  <td align="left" class="mainLabel">
				  <Select  name= "dept" class="txbEnabledText" id = "dp">
				  			   <Option value="0">--Select--</Option>
				  			   <Option value="1">Training</Option>
				  			   <Option value="2">HR</Option>
				  			   <Option value="3">Infrastructure</Option>
				  			   <Option value="4">Delivery</Option>
			  		</Select>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		  	 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Required By
				  </td>
				  <td align="left" class="mainLabel">
				  <input type="text" name="reqby" class="txbEnabledText" id = "rd" >
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request Type
			  </td>
			  <td align="left" class="mainLabel">
				  <Select  name= "rti" class="txbEnabledText" id = "rt">
				  
				  
				 <c:forEach  items="${requestScope.lst}" var="temp">
				 <option value="${temp.id}"> ${temp.desc} </option>
				 
				 </c:forEach>
			  		</Select>
				  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
		 

		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Justification
			  </td>
			  <td align="left" class="mainLabel">
			   <input type="text" name="jus" class="txbEnabledText" required>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>

		 <tr >
				<td align="center" colspan=4>
				<div align="center">
				<input type="submit" value = "save">&nbsp;
				<BUTTON name="btnCancel" title="Close"
				onClick="window.close();" >Close</BUTTON>
				</div>
				</td>
  		  </tr>
		  <tr>
		  <td colspan=4 class="mainLabel">
		  <!-- Display the SR number here. This should be displayed only on
		  successful creation of the Request-->
		  <!-- Display error message here, In case of unsuccessful creation
		  of Request-->
		  </td>
		  </tr>
    	</table>
    </td>
  </tr>
  </table>

</body>
<!-- #EndTemplate --></html>

