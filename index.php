<!DOCTYPE html>
<html>
  	<head>
        <meta charset="utf-8">
        <title>XML Generator</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" media="screen" href="./web/css/main.css">
    </head>
    <body>
        <!-- Form to get the questions and answers to them -->
        <?php
            /*if ($_SERVER['REQUEST_METHOD'] == 'POST') {
                echo "<a href='$xml_file_name' download>File</a>";
            }*/
        ?>
        <form method="post">
            <div class="questions">
                <!-- Questions here -->
            </div>
            <button type="button" class="btn btn-info" id="checkQuestions">More questions?</button>            
            <button type="submit" class="btn btn-primary" id="submitQuestions" name="submitted">Submit</button>
        </form>

        <!-- Load JQuery for dynamic input fields -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/js/bootstrap.min.js" integrity="sha384-7aThvCh9TypR7fIc2HV4O/nFMVCBwyIUKL8XCtKE+8xgCgl/PQGuFsvShjr74PBp" crossorigin="anonymous"></script>
    </body>    

    <!-- For creating more checkboxes -->
    <script>
        /* Keep question-answer pairs counted */
        let qCounter = 1;
        let aCounter = 1;
        $('#checkQuestions').click(function() {
            /* Append question */
            $('.questions').append(
                '<div class="form-group">' + 
                `<label for="q-${qCounter}">${qCounter}. Question</label>` + 
                `<input type="text" class="form-control" name="q${qCounter}" placeholder="Your question here">` +
                '</div>'
            );
            /* Append answers to each question */
						for(aCounter = 1; aCounter < 5; aCounter++) {
								if(aCounter == 1){
										$('.questions').append(
																	'<div class="form-group" style="margin-left: 20px;">' +
																	`<label for="a-${qCounter}">Correct answer</label>` +
																	`<input type="text" class="form-control" name="q${qCounter}a${aCounter}" placeholder="Your answer here">` +
																	'</div>'
															);
										} else {
															$('.questions').append(
																	'<div class="form-group" style="margin-left: 20px;">' +
																	`<label for="a-${qCounter}">${aCounter}. Answer</label>` +
																	`<input type="text" class="form-control" name="q${qCounter}a${aCounter}" placeholder="Your answer here">` +
																	'</div>'
															);
										}
						}
				
            /* Increment the number of question-answer pairs asked */
            qCounter++;
        });
    </script>

    <?php require('./xml-gen.php') ?>
</html>