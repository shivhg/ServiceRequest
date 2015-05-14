<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page errorPage="badPage.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Home Page</title>
<head>
<link rel="stylesheet" type="text/css" href="../css/Stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="lblTitle" width="100%">
		<div id='DIVPageTitle'><b>Service Request System</b></div>
		</td>

		<!-- #EndEditable -->
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
</head>

<body class="background"  text="#000000" >
<form method="post" name="frmHome" >
<P align=center><FONT face="Bookman Old Style"><FONT color=mediumslateblue
size=5><STRONG>SERVICES OFFERED</STRONG></FONT></FONT></P>
<P align=center><FONT color=mediumslateblue><FONT face="Bookman Old Style"><FONT
size=5><STRONG><A HREF="./RequestLists.do">View Service Requests</A></STRONG><br>
<STRONG><A HREF="RequestType.do">Create New Request</A></STRONG>
</FONT></FONT></FONT></P>
<!-- Remove this note during development-->
<br>
<br>
<br>
<br>

 <!--End Remove-->

</form>
</body>
</html>

