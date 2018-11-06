<?php
 
  // array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['email']) && isset($_POST['password'])) {
   
    $email = $_POST['email'];
    $message = $_POST['message'];
 
    $response["success"] = 1;
    $response["message"] = "Login successful.";
    $response["email"] = $email;
 
 	// connessione a DB
    $conn = mysql_connect("my_submitcss","submitcss","");
	if(! $conn ) {die('Could not connect: ' . mysql_error());}
	mysql_select_db("my_submitcss",$conn);
    
    // inserimento dei dati dell'utente
 	$salt=1; // da aggiungere anche il salt nel DB
    $passwordHash=openssl_digest($password.$salt,'sha512');
    $retval = mysql_query("INSERT INTO utenti (email,password) VALUES ('".$email."','".$passwordHash."')", $conn );
    if(! $retval ) {die('Could not enter data: ' . mysql_error());}
 
    // echoing JSON response
    print(json_encode($response));
     
   
 } else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) missing";
 
    // echoing JSON response
    print(json_encode($response));
}
?>