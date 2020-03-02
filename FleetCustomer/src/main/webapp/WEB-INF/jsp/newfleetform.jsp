<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>H1 {text-align:center;}
       h2{text-align:center;}
       form{text-align:center;}
</style>
<meta charset="ISO-8859-1">

<title> New or Edit Fleets</title>
</head>

<body>

<H1 style="color:green">FleetList</H1>
    </form>
       <h3><a href="/create">New FleetList</a></h3>
       <h2 style="color:green">New Fleet List </h2>
    <form method="post" action="saveFleetInfo" >
	Fleet ID     <input type="text" name="fleer_id" /><br/>	
	Fleet Name:  <input type="text" name="fleet_name" /><br/>	
	Fleet Model: <input type="text" name="fleet_madel" /><br/>	
	Fleet Make:  <input type="text" name="fleet_make" /><br/>		
	Latitude:    <input type="text" name="latitude" /><br/>		
	Longitude:   <input type="text" name="longitude" /><br/>		
	Category:    <input type="text" name="category" /><br/>		
	Serial Number:<input type="text" name="serial_number" /><br/>		
	
	 <input type="submit" value="Save" />
	 
	 </form>	
	 </body>
	 </html>