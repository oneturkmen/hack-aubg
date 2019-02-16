<?php
	function qnumber() //change
	{
		return (count($_POST) - 1) / 5;
	}

	$FNAME = time();

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	    	$dom               = new DOMDocument();
	    	$dom->encoding     = 'utf-8';
	    	$dom->xmlVersion   = '1.0';
	    	$dom->formatOutput = true;
	    	$xml_file_name     = $FNAME . '.xml';
	    	$qnumber           = qnumber();
	    	$root              = $dom->createElement('questions');
	    	for ($j = 1; $j <= $qnumber; $j++) {
			$question_node    = $dom->createElement('question');
			$attr_question_id = new DOMAttr('question_id', $j);
			$question_node->setAttributeNode($attr_question_id);
			$attr_question_id = new DOMAttr('text', $_POST['q' . $j]);
			$question_node->setAttributeNode($attr_question_id);
	
			for ($i = 1; $i < 5; $i++) {
				if($i == 1){
					$child_node = $dom->createElement('Answer', $_POST['q' . $j . 'a' . $i]);
					$attr_answer = new DOMAttr('correct', '1');
					$child_node->setAttributeNode($attr_answer);
					$question_node->appendChild($child_node);
				}else{
					$child_node = $dom->createElement('Answer' . $i, $_POST['q' . $j . 'a' . $i]);
					$question_node->appendChild($child_node);
				}
			}
			$root->appendChild($question_node);
		}
	    	/*$question_node = $dom->createElement('question');
	    	$attr_question_id = new DOMAttr('question_id', 2);
	   	$question_node->setAttributeNode($attr_question_id);

	    	for($i=1;$i<5;$i++){
	    		$child_node = $dom->createElement('Answer'.$i,$_POST['q2a'.$i]);
	    		$question_node->appendChild($child_node);
	    	}
	    	$root->appendChild($question_node);*/
	
		$dom->appendChild($root);
	
		$dom->save($xml_file_name);
	
		echo "$xml_file_name has been successfully created";
	}
?>
