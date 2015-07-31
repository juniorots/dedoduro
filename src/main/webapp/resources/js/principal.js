var bancas = [
    ".stack", // cespe
    ".stackQuadrix"
]

function fecharOutrasCestas( banca ) {
    var closespeed = 300;
    
    for (i = 0; i < bancas.length; i++) {
        if ( (bancas[i] !== banca) && ( $(bancas[i]).find('ul').attr('class') == 'openStack' ) ) {
            $(bancas[i]).find('ul').removeClass('openStack').children('li').animate({top: '72px', left: '-10px'}, closespeed);
            $("img", $(bancas[i]) ).animate({width: '72px'}, 100);
//            $(bancas[i]).find('ul').animate({top: '465px', left: '190px'}, closespeed);
//            $(bancas[i]).removeClass('openStack').children('li').animate({top: '72px', left: '-110px'}, closespeed);
//            $(bancas[i]).find('li a>img').animate({width: '71px', marginLeft: '99'}, closespeed);
        }
    }
}