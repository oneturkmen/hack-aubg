<?php	
	function qnumber() //change
	{
		return (count($_POST) - 1) / 5;
	}
	
	$dom               = new DOMDocument();
	$dom->encoding     = 'utf-8';
	$dom->xmlVersion   = '1.0';
	// $dom->formatOutput = true;
	$qnumber           = qnumber();
	$root              = $dom->createElement('questions');
	
	for ($j = 1; $j <= $qnumber; $j++) {
		$question_node    = $dom->createElement('question');
		$attr_question_id = new DOMAttr('question_id', $j);
		$question_node->setAttributeNode($attr_question_id);
		$attr_question_id = new DOMAttr('text', $_POST['q' . $j]);
		$question_node->setAttributeNode($attr_question_id);

		for ($i = 1; $i < 5; $i++) {
			if ($i == 1) {
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
	$dom->appendChild($root);
	if($_SERVER["REQUEST_METHOD"]=="POST")
	echo "<textarea cols='50' rows='30'>".$dom->saveXML()."</textarea>";
?>

<?php
////////////////////////
if($_SERVER["REQUEST_METHOD"]=="GET")
	include_once "index.inc.php";
////////////////////////
?>
