let questionsApp = new Vue({
    el: '#questionsApp',
    data: {
        questions: [
            // 测试数据
            {
                title: '这是第1个问题',
                content: '在我们使用Spring的时候，有XML和Java两种配置方式。在使用SpringBoot时，已经推荐使用Java配置，基本不用xml配置了。使用Dynamic SQL就好比是使用Java的方式来操作MyBatis。Dynamic SQL是用于生成动态SQL语句的框架，提倡使用Java API的方式来实现SQL操作，支持复杂查询和多表查询。',
                tags: [
                    {id: 8, name: 'Java基础'},
                    {id: 12, name: 'Spring'},
                    {id: 15, name: 'SpringBoot'}
                ],
                userNickName: '天下第一',
                hits: '826',
                commentCount: 1,
                createdTimeText: '8小时之前',
                tagImage: 'image/cover/one.png'
            },
            {
                title: '这是第2个问题',
                content: '我也不告诉你是什么问题……',
                tags: [
                    {id: 10, name: 'MySQL'},
                    {id: 17, name: 'SpringSecurity'}
                ],
                userNickName: '天下第一',
                hits: '537',
                commentCount: 1,
                createdTimeText: '15小时之前',
                tagImage: 'image/cover/one.png'
            }
        ],
        pageInfo: null
    },
    methods: {
        loadMyQuestions: function (page) {
            if (!page || page < 1) {
                page = 1
            }
            $.ajax({
                url: '/api/v1/questions/my',
                data : 'page=' + page,
                success: function (json) {
                    let data = json.data;
                    let questions = data.list;
                    //let questions = data;
                    for (let i = 0; i < questions.length; i++) {
                        questions[i].tagImage = '/image/cover/' + questions[i].tags[0].id + '.png';
                        // 获取时间
                        let now = new Date().getTime();
                        let pastTime = (now - new Date(questions[i].createTime).getTime()) / 1000;
                        let createdTimeTexts = questions[i].createTime;
                        let createdTimeText = createdTimeTexts.replace("T", " ");
                        if (pastTime < 60) {
                            createdTimeText = "刚刚";
                        } else if (pastTime < 60 * 60) {
                            createdTimeText = parseInt(pastTime / 60) + "分钟前";
                        } else if (pastTime < 60 * 60 * 24) {
                            createdTimeText = parseInt(pastTime / 60 / 60) + "小时前";
                        } else if (pastTime < 60 * 60 * 24 * 7) {
                            createdTimeText = parseInt(pastTime / 60 / 60 / 24) + "天前";
                        }
                        createdTimeText = createdTimeText;
                        questions[i].createdTimeText = createdTimeText;
                    }
                    questionsApp.questions = questions;
                    questionsApp.pageInfo = data;
                }
            });
        },
        deleteQuestion:function (questionId) {
            let comfirmMessage = "您确定要删除此数据吗！";
            if (!confirm(comfirmMessage)){
                alert("您已取消了删除操作！");
                return;
            }
            else {
                // alert("您已确认删除操作，即将为您执行删除！");
                $.ajax({
                    url: 'api/v1/questions/' + questionId + "/delete",
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
        this.loadMyQuestions();
    }
});