function textareaValidation()
{
	var input = document.getElementById("ta").value;
	var l = input.length;
	if(l == 0 || l == -1)
	{
		document.getElementById("error").innerHTML = 1455 + '/1455';
	}
	else
	{
		document.getElementById("error").innerHTML = 1455-l + '/1455';
	}
}