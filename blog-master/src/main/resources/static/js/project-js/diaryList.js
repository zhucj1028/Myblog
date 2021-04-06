let diaryApp = new Vue({
    el: '#diaryApp',
    data: {
        diary: [
            {content: "保持理智,相信未来！", createTime: "2021年01月05日"}
        ]
    },
    methods: {
        loadDiary: function () {
            $.ajax({
                url: '/api/v1/diary',
                type: 'get',
                success: function (json) {
                    let diary = [];
                    for (let i = 0; i < json.data.length; i++) {
                        diary[i] = json.data[i];
                        let date = diary[i].createTime;
                        let dateStr = date.replace("T", " ");
                        diary[i].createTime = dateStr;
                    }
                    diaryApp.diary = diary;
                }
            });
        },
        create: function () {
            let content = $('#summernote').val();
            console.log("正文：" + content);
            //alert("准备创建");
            $.ajax({
                url: "/api/v1/diary/create",
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
                        $('#summernote').summernote('reset');
                    } else {
                        alert(json.message)
                    }
                }
            });
        },
        deleteDiary:function (dId) {
            let comfirmMessage = "您确定要删除此数据吗！";
            if (!confirm(comfirmMessage)){
                alert("您已取消了删除操作！");
                return;
            }
            else {
                // alert("您已确认删除操作，即将为您执行删除！");
                $.ajax({
                    url: 'api/v1/diary/' + dId + "/delete",
                    type: 'post',
                    success: function (json) {
                        if (json.state == 2000) {
                            alert("删除成功！");
                        } else {
                            alert(json.message);
                        }
                    }
                });
            }
        }
    },
    created: function () {
        this.loadDiary();
    }
});