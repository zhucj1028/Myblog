let linksApp = new Vue({
    el: '#linksApp',
    data: {
        links: [
            {id: 1, name: "百度", url: "http://www.baidu.com", createTime: "2021-01-03T19:13:32"},
            {id: 2, name: "淘宝", url: "http://www.taobao.com", createTime: "2021-01-03T19:13:32"},
        ]
    },
    methods: {
        loadLinks: function () {
            $.ajax({
                url: '/api/v1/links',
                type: 'get',
                success: function (json) {
                    let links = [];
                    for (let i = 0; i < json.data.length; i++) {
                        links[i] = json.data[i];
                    }
                    linksApp.links = links;
                }
            });
        },
        create: function () {
            //alert("准备创建");
            $.ajax({
                url: "/api/v1/links/create",
                data: $('#createLink').serialize(),
                type: 'post',
                dataType: 'json',
                success: function (json) {
                    console.log(json);
                    if (json.state == 2000) {
                        alert("创建成功！");
                    } else {
                        alert(json.message)
                    }
                }
            });
        },
        deleteLink: function (linkId) {
            let comfirmMessage = "您确定要删除此数据吗！";
            if (!confirm(comfirmMessage)){
                alert("您已取消了删除操作！");
                return;
            }
            else {
                // alert("您已确认删除操作，即将为您执行删除！");
                $.ajax({
                    url: 'api/v1/links/' + linkId + "/delete",
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
        this.loadLinks();
    }
});
