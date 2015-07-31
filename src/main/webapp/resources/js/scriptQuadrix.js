/*
 * Customizando Menus existentes na pagina principal
 */
$(function () { 
    // Stack initialize
    var openspeed = 300;
    var closespeed = 300;
    $('.stackQuadrix>img').toggle(function(){
        var vertical = 0;
        var horizontal = 0;
        var $el=$(this);
        $el.next().children().each(function(){
            $(this).animate({top: '-' + vertical + 'px', left: horizontal + 'px'}, openspeed);
            vertical = vertical + 55;
            horizontal = (horizontal+.75)*2;
        });
        $el.next().animate({top: '405px', left: '348px'}, openspeed).addClass('openStack')
            .find('li a>img').animate({width: '60px', marginLeft: '2px'}, openspeed);
        $el.animate({paddingTop: '0'});
        fecharOutrasCestas('.stackQuadrix');
    }, function(){
        //reverse above
        var $el=$(this);
        $el.next().removeClass('openStack').children('li').animate({top: '71px', left: '-110px'}, closespeed);
        $el.next().find('li a>img').animate({width: '71px', marginLeft: '99'}, closespeed);
//        $el.animate({paddingTop: '35px'});
    });
     
    // Stacks additional animation
    $('.stackQuadrix li a').hover(function(){
        $("img",this).animate({width: '71px'}, 100);
        $("span",this).animate({marginRight: '30px'});
    },function(){
        $("img",this).animate({width: '69px'}, 100);
        $("span",this).animate({marginRight: '0px'});
    });
});