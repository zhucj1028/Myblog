let writeCommentApp = new Vue({
    el: '#writeCommentApp',
    data: {},
    methods: {
        postComment: function () {
            let articleId = location.search.substring(1);
            let content = $('#Editor').val();
            // 注意：以下data表示提交到服务器端的数据
            // 属性名称必须与CommentDTO的属性名称保持一致
            console.log(articleId);
            let data = {
                articleId: articleId,
                content: content
            }
            $.ajax({
                url: '/api/v1/comment/post',
                data: data,
                type: 'post',
                success: function (json) {
                    if (json.state == 2000) {
                        alert('评论成功！');
                        // 应该将数据显示到列表
                        // 如果要上传图片，必须启动静态资源服务器
                        $('#form-comment')[0].reset();
                    } else {
                        alert(json.message);
                    }
                }
            });
        }
    }
});