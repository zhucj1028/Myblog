let userListApp = new Vue({
    el: '#userListApp',
    data: {
        userLists: [
            // 以下数据为测试数据
            {id: 1, nickname: '朱成杰', phone: '18385244736', type: '1', typeText: '管理员',createTime: '2020-12-10 16:58:22'},
            {id: 2, nickname: '杜方露', phone: '18385244736', type: '0', typeText: '普通用户',createTime: '2020-12-10 16:58:22'},
            {id: 3, nickname: '李明航', phone: '18385244736', type: '1', typeText: '管理员',createTime: '2020-12-10 16:58:22'},
            {id: 4, nickname: '杨超', phone: '18385244736', type: '0', typeText: '普通用户',createTime: '2020-12-10 16:58:22'},
        ]
    },
    methods: {
        loadUserList: function () {
            $.ajax({
                url: '/api/v1/users/userList',
                success: function (json) {
                    let userLists = [];
                    let typeTexts = ['普通用户', '管理员'];
                    for (let i = 0; i < json.data.length; i++) {
                        userLists[i] = json.data[i];
                        userLists[i].typeText = typeTexts[userLists[i].type];
                        let date = userLists[i].createTime;
                        let dateStr = date.replace("T", " ");
                        userLists[i].createTime = dateStr;
                    }
                    userListApp.userLists = userLists;
                }
            });
        }
    },
    created: function () {
        this.loadUserList();
    }
});