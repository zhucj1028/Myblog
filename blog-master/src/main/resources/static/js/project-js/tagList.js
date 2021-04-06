let tagsListApp = new Vue({
    el: '#tagsListApp',
    data: {
        tags: [
            // 以下数据为测试数据
            {id: 1, name: "Java"},
            {id: 2, name: "Java基础"},
            {id: 3, name: "Spring"},
            {id: 4, name: "SpringBoot"},
            {id: 5, name: "SpringMVC"}
        ]
    },
    methods: {
        loadTags: function () {
            $.ajax({
                url: '/api/v1/tags',
                type: 'get',
                success: function (json) {
                    let tags = [];
                    for (let i = 0; i < json.data.length; i++) {
                        tags[i] = json.data[i];
                    }
                    tagsListApp.tags = tags;
                }
            });
        },
        create: function () {
            //alert("准备创建");
            $.ajax({
                url: "/api/v1/tags/create",
                data: $('#createTag').serialize(),
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
        deleteTag:function (tagId) {
            let comfirmMessage = "您确定要删除此数据吗！";
            if (!confirm(comfirmMessage)){
                alert("您已取消了删除操作！");
                return;
            }
            else {
                // alert("您已确认删除操作，即将为您执行删除！");
                $.ajax({
                    url: 'api/v1/tags/' + tagId + "/delete",
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
        this.loadTags();
    }

});