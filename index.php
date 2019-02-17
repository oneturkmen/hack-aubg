<?php require_once('./web/xml-gen.php') ?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>XML Generator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- Bootstrap CSS -->
<style> 
.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
</style> 
        <link rel="stylesheet" type="text/css" media="screen" href="./web/css/style.css">
    </head>
    <body>
	
	<a href="index.php"> <div id="header"> </div> </a>
	
	
        <!-- Form to get the questions and answers to them -->
        <?php
            if ($_SERVER['REQUEST_METHOD']=='POST') {
                echo "<a href='$xml_file_name' download>File</a>";
            }
        ?>
		
		<h1> </h1>
		<div class="container-fluid">
			<ul class="nav nav-pills nav-fill">
			  <li class="nav-item">
				<a class="nav-link active" href="#">Active</a>
			  </li>
			  <li class="nav-item">
				<a class="nav-link" href="./web/gen.php">Create your quiz</a>
			  </li>			 
			</ul>					
			</br>			
			<h2 style= "font: bold; text-align: left; font-family: verdana; font-size: 36px; text-align: center ">ABBREVIATE THE PROCRASTINATE!</h2>
			</br>
			</br>
			<p class="about" style="font-size: 24px;"> 
			 How many hours you spend each day in front of your screens without learning anything new?
			 </br>
			 Create your own personal quiz NOW! 
			 </br>
			 Our App is the new Anti-procrastination pill! It helps you improve meanwhile you procrastinate! 
			 </br> 
			 Don't miss your chancee! IT'S JUST A CLICK AWAY! 
			 </br>
			 
		     You can also click on <a href="./web/gen.php">create your own quiz</a> to create a personal query for better knowledge!
			</p>
			<button class="button"><p style="font-size: 14px; text-align: left;">Download App</p></button>
			
	<?php
		//phpinfo();
	?>
</html>
