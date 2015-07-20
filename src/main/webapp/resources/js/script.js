(function($) {

  $.fn.menumaker = function(options) {
      
      var cssmenu = $(this), settings = $.extend({
        title: "Menu",
        format: "dropdown",
        sticky: false
      }, options);

      return this.each(function() {
        cssmenu.prepend('<div id="menu-button">' + settings.title + '</div>');
        $(this).find("#menu-button").on('click', function(){
          $(this).toggleClass('menu-opened');
          var mainmenu = $(this).next('ul');
          if (mainmenu.hasClass('open')) { 
            mainmenu.hide().removeClass('open');
          }
          else {
            mainmenu.show().addClass('open');
            if (settings.format === "dropdown") {
              mainmenu.find('ul').show();
            }
          }
        });

        cssmenu.find('li ul').parent().addClass('has-sub');
 
        multiTg = function() {
          cssmenu.find(".has-sub").prepend('<span class="submenu-button"></span>');
          cssmenu.find('.submenu-button').on('click', function() {
            $(this).toggleClass('submenu-opened');
            if ($(this).siblings('ul').hasClass('open')) {
              $(this).siblings('ul').removeClass('open').hide();
            }
            else {
              $(this).siblings('ul').addClass('open').show();
            }
          });
        };

        if (settings.format === 'multitoggle') multiTg();
        else cssmenu.addClass('dropdown');

        if (settings.sticky === true) cssmenu.css('position', 'fixed');

//        resizeFix = function() {
//            
//            // TRABALHANDO ... :-)
//          $("liCustomizado").css("padding-left", "100px");    
//        };
//        resizeFix();
//        return $(window).on('resize', resizeFix);

      });
  };
})(jQuery);

(function($){
$(document).ready(function(){

$("#cssmenu").menumaker({
   title: "Menu",
   format: "multitoggle"
});

});
})(jQuery);

/*
 * Customizacao para janela de login
 */
$(function() {
    var button = $('#loginButton');
    var box = $('#loginBox');
    var form = $('#loginForm');
    button.removeAttr('href');
    button.mouseup(function(login) {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() { 
        return false;
    });
    $(this).mouseup(function(login) {
        if(!($(login.target).parent('#loginButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });
});

/*
 * Customizando Menus existentes na pagina principal
 */
$(function () { 
    // Stack initialize
    var openspeed = 300;
    var closespeed = 300;
    $('.stack>img').toggle(function(){
        var vertical = 0;
        var horizontal = 0;
        var $el=$(this);
        $el.next().children().each(function(){
            $(this).animate({top: '-' + vertical + 'px', left: horizontal + 'px'}, openspeed);
            vertical = vertical + 55;
            horizontal = (horizontal+.75)*2;
        });
        $el.next().animate({top: '-50px', left: '10px'}, openspeed).addClass('openStack')
           .find('li a>img').animate({width: '50px', marginLeft: '9px'}, openspeed);
        $el.animate({paddingTop: '0'});
    }, function(){
        //reverse above
        var $el=$(this);
        $el.next().removeClass('openStack').children('li').animate({top: '55px', left: '-10px'}, closespeed);
        $el.next().find('li a>img').animate({width: '79px', marginLeft: '0'}, closespeed);
        $el.animate({paddingTop: '35'});
    });
     
    // Stacks additional animation
    $('.stack li a').hover(function(){
        $("img",this).animate({width: '56px'}, 100);
        $("span",this).animate({marginRight: '30px'});
    },function(){
        $("img",this).animate({width: '50px'}, 100);
        $("span",this).animate({marginRight: '0'});
    });
});