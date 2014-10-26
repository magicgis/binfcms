$(function() {

    $('#side-menu').metisMenu();

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
});

var binf = {
    v:{
      ajaxOption:{method:'get',dataType:'json',async:true},
      notifyMethod:null
    },
    notify:function(msg,status){
        var option = { position:"top center",
            autoHideDelay:2000,
            className:status,
            arrowSize: 10
        }
        $.notify(msg, option);
    },
    delNotify:function(method){
        $.notify({
            title: '确认删除么？删除后不可恢复！',
            button: '删除'
        }, {
            style: 'foo',
            autoHide: false,
            clickToHide: false,
            position:"top center"
        });
        if(method!=undefined){
            binf.v.notifyMethod = method;
        }
    },
    uiform:function(){
        jQuery('tbody input:checkbox').click(function(){
            if(jQuery(this).is(':checked')){
                jQuery(this).parent().addClass('checked');
                jQuery(this).parents('tr').addClass('warning');
            }else{
                jQuery(this).parent().removeClass('checked');
                jQuery(this).parents('tr').removeClass('warning');
            }
        });
    },
    checkAll:function(obj){
        var parentTable = jQuery(obj).parents('table');
        var ch = parentTable.find('tbody input[type=checkbox]');
        if(jQuery(obj).is(':checked')) {
            ch.each(function(){
                jQuery(this).prop('checked', true);
                jQuery(this).parent().addClass('checked');
                jQuery(this).parents('tr').addClass('warning');
            });
        } else {
            ch.each(function(){
                jQuery(this).removeAttr('checked')
                jQuery(this).parent().removeClass('checked');
                jQuery(this).parents('tr').removeClass('warning');
            });
        }
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



$.notify.addStyle('foo', {
    html:
        "<div>" +
            "<div class='clearfix'>" +
            "<div class='title' data-notify-html='title'/>" +
            "<div class='buttons'>" +
            "<button class='no'>取消</button>" +
            "<button class='yes' data-notify-text='button'></button>" +
            "</div>" +
            "</div>" +
            "</div>"
});

$(document).on('click', '.notifyjs-foo-base .no', function() {
    $(this).trigger('notify-hide');
});
$(document).on('click', '.notifyjs-foo-base .yes', function() {
    if(binf.v.notifyMethod!=null){
        console.log(binf.v.notifyMethod)
        eval("binf.v.notifyMethod()");
    }
    $(this).trigger('notify-hide');
});


;(function($){
    $.fn.getInputId = function(sigle){
        var checkIds = [];

        this.each(function(){
            checkIds.push($(this).val())
        });

        if(sigle){
            if(checkIds.length>1){
                binf.notify('只能选择一条记录！','error');
                return false;
            }
            else if(checkIds.length==0){
                binf.notify('请选择一条记录操作！','error');
                return false;
            }
            else{
                return checkIds[0];
            }
        }else{
            if(checkIds.length==0){
                binf.notify('请选择至少一条记录操作！','error');
                return false;
            }else{
                return checkIds;
            }

        }
    };
})(jQuery);



