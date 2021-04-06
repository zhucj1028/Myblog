let commentApp = new Vue({
    el: '#commentApp',
    data: {
        comments: [
            {userNickname: "小李", content: "保持理智,相信未来！", createTime: "2021年01月05日"},
            {userNickname: "阿杰", content: "今天的你在干嘛啊", createTime: "2021年01月05日"},
            {userNickname: "无趣", content: "这世界会好吗！", createTime: "2021年01月05日"}
        ]
    },
    methods: {
        loadComment: function () {
            // 获取网页中？往后的数据
            let articleId = location.search.substring(1);
            $.ajax({
                url: '/api/v1/comment/'+ articleId,
                success: function (json) {
                    // 替换返回时间中的T字符
                    let comments = [];
                    for (let i = 0; i < json.data.length; i++) {
                        comments[i] = json.data[i];
                        let date = comments[i].createTime;
                        let dateStr = date.replace("T", " ");
                        comments[i].createTime = dateStr;
                    }
                    commentApp.comments = comments;
                }
            });
        },
        loadError:function () {
            alert("抱歉！回复功能暂未开放！")
        }
    },
    created: function () {
        this.loadComment();
    }
});