$(function () {
    var initUrl = '/schoolshopper/shopadmin/getshopinitinfo';
    var editShopUrl = '/schoolshopper/shopadmin/registershop';
    function getCategory() {
        $.getJSON(initUrl, function(data) {
            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function(item, index) {
                    tempHtml += '<option data-id="' + item.shopCategoryId
                        + '">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shop-category').html(tempHtml);
                $('#shop-category').removeAttr('disabled');
                $('#area').html(tempAreaHtml);
            }
        });
    }

    $('#submit').click(function() {
        var shop = {};

        shop.shopName = $('#shop-name').val();
        shop.shopAddr = $('#shop-addr').val();
        shop.phone = $('#shop-phone').val();
        shop.shopDesc = $('#shop-desc').val();

        shop.shopCategory = {
            shopCategoryId : $('#shop-category').find('option').not(function() {
                return !this.selected;
            }).data('id')
        };
        shop.area = {
            areaId : $('#area').find('option').not(function() {
                return !this.selected;
            }).data('id')
        };

        var shopImg = $("#shop-img")[0].files[0];
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        var verifyCodeActual = $('#j_captcha').val();
        if (!verifyCodeActual) {
            $.toast('请输入验证码！');
            return;
        }
        formData.append("verifyCodeActual", verifyCodeActual);
        $.ajax({
            url : editShopUrl,
            type : 'POST',
            // contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data : formData,
            contentType : false,
            processData : false,
            cache : false,
            success : function(data) {
                if (data.success) {
                    $.toast('提交成功！');
                    if (isEdit){
                        $('#captcha_img').click();
                    } else{
                        window.location.href="/shop/shoplist";
                    }
                } else {
                    $.toast('提交失败！');
                    $('#captcha_img').click();
                }
            }
        });
    });


    getCategory();
})