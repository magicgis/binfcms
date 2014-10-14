$(function() {

    $('#side-menu').metisMenu();

});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        topOffset = 50;
        width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse')
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse')
        }

        height = (this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    })


    //menu

    $('#side-menu').find("li").each(function(){
        var menu_a =  $(this).find("a").eq(0);
        var page_title = $("#page-wrapper .page-header").text();
        if(menu_a.text()==page_title){
            menu_a.addClass("active");
            var ul = $(this).parent("ul .nav-second-level")

            if(ul.length>0){
                ul.addClass("in")

            }

        }

    })
})
