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

    // check all checkboxes in table
    if(jQuery('.checkall').length > 0) {

        jQuery('.checkall').click(function(){
            var parentTable = jQuery('.checkall').parents('table');
            var ch = parentTable.find('tbody input[type=checkbox]');

            if(jQuery(this).is(':checked')) {
                //check all rows in table
                ch.each(function(){
                    jQuery(this).attr('checked',true);
                    jQuery(this).parent().addClass('warning');	//used for the custom checkbox style
                    jQuery(this).parents('tr').addClass('warning'); // to highlight row as selected
                });

            } else {
                //uncheck all rows in table
                ch.each(function(){
                    jQuery(this).attr('checked',false);
                    jQuery(this).parent().removeClass('warning');	//used for the custom checkbox style
                    jQuery(this).parents('tr').removeClass('warning');
                });

            }
        });
    }




})


var binf = {
    v:{
      ajaxOption:{method:'get',dataType:'json',async:true}
    },
    notify:function(msg,status){
        var option = { position:"top center",
            autoHideDelay:2000,
            className:status,
            arrowSize: 10
        }

        $.notify(msg, option);
    },
    uiform:function(){
//        if(jQuery().uniform){
//            jQuery('input:checkbox, input:radio').uniform();
//        }

        jQuery('tbody input:checkbox').click(function(){
            if(jQuery(this).is(':checked'))
                jQuery(this).parents('tr').addClass('warning');
            else
                jQuery(this).parents('tr').removeClass('warning');
        });
    },
    ajax:function(url, data, callbackFun, option){
        if(option==null || option==undefined){
            option=binf.v.ajaxOption;
        }else{
            if(option.method==null || option.method==undefined){
                option.method=binf.v.ajaxOption.method;
            }
            if(option.dataType==null || option.dataType==undefined){
                option.dataType=binf.v.ajaxOption.dataType;
            }
            if(option.async==null || option.async==undefined){
                option.async=binf.v.ajaxOption.async;
            }
        }
        jQuery.ajax({
            dataType: option.dataType,
            url: url,
            data: data,
            async: option.async,
            success: function(data){
                console.log(data)
                callbackFun(data);
            },
            statusCode: {
                401: function() {
                },
                403: function() {
                },
                500: function() {
                }
            }
        });
    }

}



