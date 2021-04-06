let questionInfoApp = new Vue({
    el: '#questionInfoApp',
    data: {
        questions: [
            {
                title: 'HashMao和HashTable的区别',
                content: '一个是线程安全一个是线程不安全',
                userNickname: '无趣',
                createTime: '2021-01-01',
                tags: [
                    {id: 2, name: 'Java基础'},
                    {id: 3, name: 'Java面试题'}
                ]
            }]
    },
    methods: {
        loadQuestion:function () {
            let id = location.search;// 获取网页中？往后的数据
            if (!id) {
                alert("非法访问！参数不足！");
                location.href = '/article.html';
                return;
            }
            id = id.substring(1); // 从下标1开始取往后的数据
            if (!id || isNaN(id)) {  //is not a number 不是一个数字
                alert("非法访问！参数不足！");
                location.href = '/article.html';
                return;
            }
            $.ajax({
                url: '/api/v1/questions/' + id,
                success: function (json) {
                    // 替换返回时间中的T字符
                    let date = json.data.createTime;
                    let dateStr = date.replace("T", " ");
                    json.data.createTime = dateStr;
                    if (json.state == 2000) {
                        questionInfoApp.questions = json.data;
                    } else {
                        alert(json.message);
                        location.href = "/article.html";
                    }
                }
            });
        }
    },
    created: function () {
        this.loadQuestion();
    }
});