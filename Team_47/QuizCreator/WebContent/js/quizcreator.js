/** 
  * Author(s): Suraj Atmakuri
  * Date: 2019/2/27
  * Description: Page for creating quizzes
  */
var i=1;
    function addFields()
    {
      div1.innerHTML = div1.innerHTML + ("Q"+ i + ":")
      var id = "q";
      var id_var = id.concat(i.toString());
      div1.innerHTML = div1.innerHTML + "<input type='text' id="+ id_var +" name='question' value='enter the question'size='30'+i><br>"
      selectType(id_var);
      i++;
    }
    function selectType(a)
    {
      var j=0;
      var radio1 = a.concat("_radio1");
      var radio2 = a.concat("_radio2");
      var button_id = a.concat("_button")
      div1.innerHTML = div1.innerHTML + "select the number of answers: <br><input type='radio' id="+ radio1 +" name='a' value='sa'> single answer <br>" 
      div1.innerHTML = div1.innerHTML + "<input type='radio' id="+ radio2 +" name='a' value='ma'>multiple answers <br>"
      div1.innerHTML = div1.innerHTML + "<input type='button' id="+button_id+" onclick='validateType("+radio1+","+radio2+","+button_id+")' value='add answers'><br>"
    }
    function validateType(rad_a,rad_b,button_id)
    {
     if(rad_a.checked  || rad_b.checked) 
      {
        if(rad_a.checked)
         {
           addAnswerFields(1,rad_a);
          }
        else if(rad_b.checked)
                {
                 addAnswerFields(2,rad_b);
                }
      button_id.style.visibility = false;
     }
    }
    function addAnswerFields(a,ans)
    {
      var opt_a = ans.id.concat("_a");
      var opt_b = ans.id.concat("_b");
      var opt_c = ans.id.concat("_c");
      var opt_d = ans.id.concat("_d");
      var val = ans.id.concat("_cred");
      if(a==1)
       {
          div1.innerHTML = div1.innerHTML + "<input type='radio' id="+ opt_a +" name='choice' value='a'>&#97.<input type='text' value='enter the answer' name='a'size=30><br>"
          div1.innerHTML = div1.innerHTML + "<input type='radio' id="+ opt_b +" name='choice' value='b'>&#98.<input type='text' value='enter the answer' name='b'size=30><br>"
          div1.innerHTML = div1.innerHTML + "<input type='radio' id="+ opt_c +" name='choice' value='c'>&#99.<input type='text' value='enter the answer' name='c'size=30><br>"
          div1.innerHTML = div1.innerHTML + "<input type='radio' id="+ opt_d +" name='choice' value='d'>&#100.<input type='text' value='enter the answer' name='d'size=30><br>"
       }
      else if(a==2)
             {
               div1.innerHTML = div1.innerHTML + "<input type='checkbox' id="+ opt_a +" name='choice' value='a'>&#97.<input type='text' value='enter the answer' name='a'size=30><br>"
               div1.innerHTML = div1.innerHTML + "<input type='checkbox' id="+ opt_b +" name='choice' value='b'>&#98.<input type='text' value='enter the answer' name='b'size=30><br>"
               div1.innerHTML = div1.innerHTML + "<input type='checkbox' id="+ opt_c +" name='choice' value='c'>&#99.<input type='text' value='enter the answer' name='c'size=30><br>"
               div1.innerHTML = div1.innerHTML + "<input type='checkbox' id="+ opt_d +" name='choice' value='d'>&#100.<input type='text' value='enter the answer' name='d'size=30><br>"
             }
      div1.innerHTML = div1.innerHTML + "credits:<input type='text'id="+ val +" name='points' value='enter the points'size=2>"
    }