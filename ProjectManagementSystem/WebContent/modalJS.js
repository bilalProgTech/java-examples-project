function modalOpener(elem)
{
	var btn = document.getElementById(elem.id+"M");
	var modal = document.getElementById('mainModal');
	var span = document.getElementsByClassName("close")[0];
	btn.onclick = function() 
	{
	    modal.style.display = "block";
	}
	span.onclick = function() 
	{
	    modal.style.display = "none";
	}
	window.onclick = function(event) 
	{
	    if (event.target == modal) 
	    {
	        modal.style.display = "none";
	    }
	}
}
