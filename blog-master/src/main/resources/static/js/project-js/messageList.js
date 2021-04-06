let messageApp = new Vue({
    el: '#messageApp',
    data: {
        message: [
            {userNickname: "小李", content: "保持理智,相信未来！", createTime: "2021年01月05日", uid: "1"}
        ]
    },
    methods: {
        loadMessage: function () {
            $.ajax({
                url: '/api/v1/message',
                type: 'get',
                success: function (json) {
                    let message = [];
                    for (let i = 0; i < json.data.length; i++) {
                        message[i] = json.data[i];
                        let date = message[i].createTime;
                        let dateStr = date.replace("T", " ");
                        message[i].createTime = dateStr;
                    }
                    messageApp.message = message;
                }
            });
        },
        create: function () {
            let content = $('#Editor').val();
            console.log("留言：" + content);
            //alert("准备创建");
            $.ajax({
                url: "/api/v1/message/create",
                data: {
                    content: content
                },
                type: 'post',
                dataType: 'json',
                success: function (json) {
                    console.log(json);
                    if (json.state == 2000) {
                        alert("创建成功！");
                        $('#form-comment')[0].reset();
                    } else {
                        alert(json.message)
                    }
                }
            });
        },
        /*reply:function () {
            /!*let content = $('#replyEdit').val();
            let parentCommentId = $('#parentCommentId').val();
            console.log("回复：" + content);
            console.log("回复：" + parentCommentId);*!/
            $.ajax({
               url:"/api/v1/message/create",
                data: $('#replyEdit').serialize(),
                type:'post',
                dataType: 'json',
                success: function (json) {
                    console.log(json);
                    if (json.state == 2000) {
                        alert("回复成功");
                        window.location.reload();
                    } else {
                        alert(json.message);
                    }
                }
            });
        },*/
        deleteMessage: function (mId) {
            let comfirmMessage = "您确定要删除此数据吗！";
            if (!confirm(comfirmMessage)){
                alert("您已取消了删除操作！");
                return;
            }
            else {
                // alert("您已确认删除操作，即将为您执行删除！");
                $.ajax({
                    url: 'api/v1/message/' + mId + "/delete",
                    type: 'post',
                    success: function (json) {
                        if (json.state == 2000) {
                            alert("删除成功！");
                            // 强制刷新
                            window.location.reload();
                        } else {
                            alert(json.message);
                        }
                    }
                });
            }
        },
        erro: function () {
            alert("抱歉！回复功能暂未开放！")
        }
    },
    created: function () {
        this.loadMessage();
    }
});