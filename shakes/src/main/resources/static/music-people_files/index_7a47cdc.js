define("web:page/musician/header/index",
function(require, exports, module) {
    $(function() {
        var modalCtrl = function() {
            function show() {
                console.log("show"),
                $modal || ($(document.body).append(ModalTmplRender({})), $modal = $("#headerModal"), $modalCont = $("#headerModalCont")),
                $modal.addClass("header-modal-show"),
                setTimeout(function() {
                    $modalCont.addClass("header-modal-container-show")
                },
                100)
            }
            var ModalTmplRender = function(obj) {
                {
                    var __p = "";
                    Array.prototype.join
                }
                with(obj || {}) __p += '<div class="header-modal" id="headerModal">\n    <div class="header-modal-container" id="headerModalCont">\n        <p class="header-modal-content">Gary溫馨提示</p>\n        <p class="header-modal-tips">如果已有抖音账号，请先到抖音app个人主页。点击右上角“…”—设置—账号管理，绑定手机号，再用该手机号来登录哦！</p>\n        	\n            <div class="header-modal-button" id="modalBtn">我知道了</div>\n        </a>\n    </div>\n</div>';
                return __p
            },
            $modal = null,
            $modalCont = null;
            return {
                show: show
            }
        } ();
        $("#loginBtn").click(modalCtrl.show)
    })
});