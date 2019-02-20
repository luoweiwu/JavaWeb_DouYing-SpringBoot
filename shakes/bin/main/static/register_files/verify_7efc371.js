define("web:page/musician/apply/verify/verify",
function(t) {
    function a(t) {
        return t && t.__esModule ? t: {
            "default": t
        }
    }
    var e = a(t("web:page/musician/apply/utils/form")),
    s = a(t("web:page/musician/apply/utils/file")),
    n = a(t("web:page/musician/apply/utils/toast"));
    $(function() {
        function t(t) {
            if (t.lengthComputable) {
                var a = t.loaded / t.total;
                if ($("#progressNum").html("".concat(parseInt(100 * a), "%")), .5 > a) {
                    var e = 180 * a * 2 - 135;
                    $("#progressRight").css({
                        transform: "rotate(".concat(e, "deg)")
                    }),
                    $("#progressLeft").css({
                        transform: "rotate(-135deg)"
                    })
                } else {
                    var s = 180 * (a - .5) * 2 - 135;
                    $("#progressRight").css({
                        transform: "rotate(45deg)"
                    }),
                    $("#progressLeft").css({
                        transform: "rotate(".concat(s, "deg)")
                    })
                }
            }
        }
        function a(t) {
            var a = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            return a.test(t)
        }
        var r = function() {
            var t = $("#modal"),
            a = $("#modalContainer");
            return {
                show: function() {
                    t.addClass("submit-modal-show"),
                    setTimeout(function() {
                        a.addClass("submit-modal-container-show")
                    },
                    100)
                },
                hide: function() {
                    t.removeClass("submit-modal-show"),
                    a.removeClass("submit-modal-container-show")
                }
            }
        } (),
        i = function() {
            function t() {
                $.ajax({
                    url: "/aweme/v1/musician/verify/",
                    method: "POST",
                    data: c,
                    success: function(t) {
                        0 == t.status_code ? location.assign("/apply_submit/") : (console.error("请求错误： ", t), n.
                    default.show({
                            title:
                            "提交失败",
                            content: "信息提交失败，请重新提交"
                        }))
                    },
                    error: function(t) {
                        n.
                    default.show({
                            title:
                            "请求错误",
                            content: "请求错误，请重新提交"
                        }),
                        console.warn(t)
                    }
                })
            }
            function a() {
                var t = 6;
                u = setInterval(function() {
                    t-->1 ? o.val("我已阅读并接受《参赛协议》(".concat(t, ")")) : (clearInterval(u), o.val("我已阅读并接受《参赛协议》"), o.attr("class", "agreement-button"), o.removeAttr("disabled"))
                },
                1e3)
            }
            function e() {
                r.removeClass("submit-modal-show"),
                i.removeClass("submit-modal-container-show"),
                o.val("我已阅读并接受《参赛协议》"),
                o.attr({
                    "class": "agreement-button-disabled",
                    disabled: !0
                }),
                clearInterval(u)
            }
            function s(t) {
                c = t,
                r.addClass("submit-modal-show"),
                setTimeout(function() {
                    i.addClass("submit-modal-container-show")
                },
                0),
                a()
            }
            var r = $("#agreement"),
            i = $("#agreementContainer"),
            o = $("#agreeSubmit"),
            d = $("#agreeHideBtn"),
            u = null,
            c = {};
            return d.click(function() {
                e()
            }),
            {
                show: s,
                hide: e
            }
        } ();
        $.ajax({
            url: "/aweme/v1/musician/verify/status/",
            method: "GET",
            success: function(t) {
                0 == t.status_code && (1 == t.status || 2 == t.status ? location.assign("/apply_submit/") : 3 == t.status && r.show())
            }
        }),
        $("#hideModalBtn").click(function() {
            r.hide()
        }),
        $("#idCardFile").on("change",
        function(a) {
            var e = a.target.files[0];
            if (e) {
                var r = new s.
            default(e);
                r.getUrlData().then(function(a) {
                    return $("#idCardImg").attr("src", a),
                    $("#idCardTisp").html("照片上传中..."),
                    $("#idCardCover").show(),
                    r.upload({
                        url: "/aweme/v1/musician/upload/safeImage/",
                        progress: t,
                        success: function(t) {
                            0 == t.status_code ? ($("#idCardTisp").html("照片上传成功"), $("#idCardCover").hide(), $("#idCardUrl").val(t.data.uri).change()) : ($("#idCardTisp").html("照片上传失败"), n.
                        default.show({
                                title:
                                "上传失败",
                                content: "照片上传失败，请重新上传"
                            }))
                        },
                        error: function() {
                            $("#idCardTisp").html("照片上传失败，请重新上传"),
                            n.
                        default.show({
                                title:
                                "请求失败",
                                content: "请求失败，请重新上传"
                            })
                        }
                    })
                })
            }
            a.target.value = ""
        });
        var o = $("#stepForm"),
        d = new e.
    default(o[0]);
        o.change(function() {
            var t = d.verifyFrom(["name", "id_card", "id_card_uri"]);
            $("#submitBtn").attr(t.length < 1 ? {
                disabled: !1,
                "class": "step-button"
            }: {
                disabled: !0,
                "class": "step-button-disable"
            })
        }),
        jQuery.validator.addMethod("isIdCard",
        function(t, e, s) {
            return a(t, e, s)
        },
        "身份证／护照格式不正确"),
        o.validate({
            debug: !0,
            submitHandler: function() {
                var t = d.getObjData(["name", "wechat", "id_card", "id_card_uri", "stage_name"]);
                i.show(t)
            },
            rules: {
                name: {
                    required: !0,
                    minlength: 2
                },
                id_card: {
                    required: !0,
                    isIdCard: !0
                },
                id_card_uri: {
                    required: !0
                },
                stage_name: {
                    required: !0
                }
            },
            messages: {
                name: "姓名不能为空",
                auth_code: "验证码错误",
                id_card: "身份证号码错误",
                id_card_uri: "请上传身份证照片",
                stage_name: "歌手名不能为空"
            }
        })
    })
});