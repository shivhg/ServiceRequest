<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="badPage.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Login Page</title>
<head>
<link rel="stylesheet" type="text/css" href="../css/Stylesheet.css">
<script Language="JavaScript" src="../js/AccountMgmt.js"> </script>

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
var x = document.getElementById("uis").value;
var y = document.getElementById("pds").value;

if(x==null||x==""||y==null||y=="") {
alert("Required all fields");
return false;
}

}


</script>


</head>

<body class="background"  text="#000000" >
<form method="post" name="frmLogin" action = "login.do" onsubmit="return validate()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="3" height="15">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td></td>
				<td></td>
				<td width="10">&nbsp;</td>
			</tr>

			<tr>
				<td width="10">&nbsp;</td>
				<td colspan="2" align="middle">
				<table  border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
				  <tr align="center" >
				  <td class="tableHeader" align="center" colspan=2>
  				  <b>Enter Login Information</b>
  				  </td>
				  </tr>
				  <tr>
				  <td align="middle" class="mainLabel">UserId : </td>
				  <td><input type="text" name="userid" class="txbEnabledText"  id = "uis">
				  </td>
				  </tr>
				  <tr>
				  <td align="middle" class="mainLabel" >PASSWORD : </td>
				  <td><input type="password" name="password" class="txbEnabledText" id = "pds"></td>
				</tr>
				<tr >
				   <td align="right" colspan=2>
				   <div align="center">
				   <input type="submit" value = "submit" >
				   <BUTTON name="btnClose" title="Close"
				    onClick="window.close();">Close</BUTTON>
				   </div>
				   </td>
				</tr>
				</table>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
			<td colspan=4>&nbsp;
			</td>
			</tr>
			<tr>
			<td colspan=4>&nbsp;
			<!-- Display error message here, in case the user is not successfully logged in-->
			</td>
			</tr>

		</table>
      </TABLE>
<table>
</table>
<!-- Remove this note during development-->
<br>
<br>
<br>
<br>
<FONT > <STRONG> Depending on the logged in user the Home page will be displayed.
</STRONG></FONT>
 <!--End Remove-->

</form>
</body>
</html>

