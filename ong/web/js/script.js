/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var min=8;
var max=24;


function aumentar() {
   var p = document.getElementsByTagName('*');


   for(i=0;i<p.length;i++) {
      if(p[i].style.fontSize) {
         var s = parseInt(p[i].style.fontSize.replace("px",""));
      } else {
         var s = 14;
      }
      if(s!=max) {
         s += 1;
      }
      p[i].style.fontSize = s+"px"
   }
}
function diminuir() {
   var p = document.getElementsByTagName('*');
   for(i=0;i<p.length;i++) {
      if(p[i].style.fontSize) {
         var s = parseInt(p[i].style.fontSize.replace("px",""));
      } else {
         var s = 14;
      }
      if(s!=min) {
         s -= 1;
      }
      p[i].style.fontSize = s+"px"
   }   
}

function normal() {
    var p = document.getElementsByTagName('*');
    for(i=0;i<p.length;i++) {
        p[i].style.fontSize = "14px";
        
    }
    var h1 = document.getElementsByTagName('h1');
    for(i=0;i<h1.length;i++) {
        h1[i].style.fontSize = "36px";
        
    }
  
}

function mudarPreto() {
    $("body").css("background-image","none");
    $("body").css("background-color","#000000");
    $("*").css("color","#fff");
    $("#header").css("background-color","#000000");
    $("#lateral").css("background-color","#000000");
    $(".menu").css("background-color","#000000");
    $(".nav > li > a:hover").css("background-color","#000000");
    $('#contraste').addClass('clicado');
    
}

function voltarCor() {
    $("body").css("background-image","url('/ong/imagens/background.jpg')");
    $("body").css("min-height", "600px");
    $("body").css("background-repeat", "repeat");
    $("body").css("background-position", "top left");
    $("body").css("background-attachment", "scroll");
    $("body").css("background-color","#fff");
    $("*").css("color","#939da8");
    $("#header").css("background-color","#eaeaea");
    $("#lateral").css("background-color","#f9f9f4");
    $(".menu").css("background-color","#f9f9f4");
    $(".nav > li > a:hover").css("background-color","#eee");
    $('#contraste').removeClass('clicado');
}


$(document).ready(function () {
    $('#contraste').on('click', function() {
        //if ($("#contraste").text() === 'Original') {
        if($("#contraste").hasClass("clicado")){
            $("#contraste").attr("href", "javascript:voltarCor()");
        } else {
            $("#contraste").attr("href", "javascript:mudarPreto()");
        }
    });
});