/**
 * @author - janiceabraham
 * @version - 1.0
 * @since - 02/22/2019
 */

function validateTimeCheckbox(elem)
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