function myFunction(elem)
{
    if (elem.checked)
    {
    	document.getElementById('minutes').readOnly = false;
    	document.getElementById('hours').readOnly = false;
    }
    else
    {
    	document.getElementById('minutes').readOnly = true;
    	document.getElementById('hours').readOnly = true;
    }
}