Vue.component('v-select', VueSelect.VueSelect);
let createQuestionApp = new Vue({
    el: '#createQuestionApp',
    data: {
        title: null,
        tags: [],
        selectedTagIds: []
    },
    methods: {
        loadTags: function () {
            $.ajax({
                url: '/api/v1/tags',
                type: 'get',
                success: function (json) {
                    let tags = [];
                    for (let i = 0; i < json.data.length; i++) {
                        let op = {
                            label: json.data[i].name,
                            value: json.data[i].id
                        };
                        tags[i] = op;
                    }
                    createQuestionApp.tags = tags;
                }
            });
        },
        createQuestion: function () {
            let content = $('#summernote').val();
            console.log("标题：" + this.title);
            console.log("选中的标签：" + this.selectedTagIds);
            console.log("正文：" + content);
                $.ajax({
                    url: '/api/v1/questions/create',
                    type: 'post',
                    traditional: true,
                    data: {
                        title: createQuestionApp.title,
                        tagIds: createQuestionApp.selectedTagIds,
                        content: content
                    },
                    success: function (json) {
                        if (json.state == 2000) {
                            alert("发表博客成功！！！");
                              $('#form-comment')[0].reset();
                              $('#summernote').summernote('reset');
                        } else {
                            alert(json.message);
                        }
                    },error:function(json){
                        alert(alert);
                    }
                });
            }
    },
    created: function () {
        this.loadTags();
    }
});